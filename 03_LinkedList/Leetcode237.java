// Leetcode 237-: Delete Node in a Linked List

class Leetcode237
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
        }
    }

    static void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static void print(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.print("Before: ");
        print(n1);

        deleteNode(n3);   // node with value 1 is "deleted"

        System.out.print("After: ");
        print(n1);
    }
}

// Before: 4 5 1 9 
// After: 4 5 9