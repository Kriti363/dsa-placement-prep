// At a Node at nth position;

public class AddNodeAtNth
{
    public static void main (String arg[])
    {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.print();
        list.add(45, 5);
        list.print();
    }
}

class LinkedList
{
    class Node
    {
        int data;
        Node next;                             // By default next pointer will be null.

        Node (int data)
        {
            this.data = data;              // To initialize the value of data we made a constructor.
        }
    }

    Node head;

    void add(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    void add(int data, int n)
    {
        Node newNode = new Node(data);

        if (n == 1)
        {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node curr = head;
        for (int i = 1; i < n - 1; i++)
        {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    void print()
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}