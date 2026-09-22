class DoublyLinkedList
{
    class Node
    {
        int data;
        Node prev;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void addLast(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    void addFirst(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void deleteValue(int value)
    {
        Node curr = head;

        while (curr != null)
        {
            if (curr.data == value)
            {
                if (curr.prev != null)
                {
                    curr.prev.next = curr.next;
                }
                else
                {
                    head = curr.next;
                }

                if (curr.next != null)
                {
                    curr.next.prev = curr.prev;
                }
                else
                {
                    tail = curr.prev;
                }

                return;
            }
            curr = curr.next;
        }
    }

    void printForward()
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    void printBackward()
    {
        Node curr = tail;
        while (curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.print("Forward: ");
        list.printForward();

        System.out.print("Backward: ");
        list.printBackward();

        list.deleteValue(20);

        System.out.print("After deleting 20, Forward: ");
        list.printForward();
    }
}