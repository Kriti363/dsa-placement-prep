// Linked List-:
// A linked list is a fundamental linear data structure used in computer science to store collections of data. Unlike arrays, which store elements in contiguous (side-by-side) physical memory locations, a linked list consists of independent nodes that are scattered throughout memory. These nodes are chained together using pointers or references.
// Better memory optimization than Array.
// Implementation of Linked List from scratch;

// Linked List-:
// A linked list is a fundamental linear data structure used in computer science to store collections of data. Unlike arrays, which store elements in contiguous (side-by-side) memory locations,
// Better memory optimization than Array.
// Implementation of Linked List from scratch;

public class Basics
{
    public static void main (String arg[])
    {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println(list.head.data);

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

    void add (int data)
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