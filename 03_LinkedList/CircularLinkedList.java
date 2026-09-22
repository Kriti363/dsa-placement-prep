class CircularLinkedList
{
    class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void add(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            tail.next = head;   // points back to itself
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;       // keep the circle closed
    }

    void addFirst(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;       // re-close the circle to the new head
    }

    void delete(int value)
    {
        if (head == null)
        {
            return;
        }

        if (head.data == value)
        {
            if (head == tail)
            {
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            tail.next = head;
            return;
        }

        Node curr = head;
        while (curr.next != head)
        {
            if (curr.next.data == value)
            {
                if (curr.next == tail)
                {
                    tail = curr;
                }
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    void print()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        do
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }

    public static void main(String[] args)
    {
        CircularLinkedList list = new CircularLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);

        System.out.print("List: ");
        list.print();

        list.delete(20);

        System.out.print("After deleting 20: ");
        list.print();
    }
}


// List: 5 10 20 30 
// After deleting 20: 5 10 30 