// Floyd's cycle detection algorithm, also known as the Tortoise and Hare Algorithm, is a pointer method that uses two speeds to find a loop in a linked list or sequence.

class LinkedListCycle
{
    static class Node
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
        }
    }

    static boolean hasCycle(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;   // creates a cycle back to n2

        System.out.println(hasCycle(n1));   // true
    }
}