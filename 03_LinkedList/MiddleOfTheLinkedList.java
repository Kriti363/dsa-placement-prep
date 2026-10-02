/**
 * Definition for a singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

/**
 * Class name requested: MiddleOfTheLinkedList
 */
public class MiddleOfTheLinkedList {

    /**
     * Finds the middle node using the Two-Pointer (Tortoise and Hare) approach.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps
        }
        
        return slow;
    }

    /**
     * Helper method to print the linked list from a given node onwards.
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Main method to test the functionality.
     */
    public static void main(String[] args) {
        MiddleOfTheLinkedList solver = new MiddleOfTheLinkedList();

        // 1. Create an odd-lengthed linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode oddList = new ListNode(1, 
                           new ListNode(2, 
                           new ListNode(3, 
                           new ListNode(4, 
                           new ListNode(5)))));
        
        System.out.print("Original Odd List: ");
        printList(oddList);
        
        ListNode middleOdd = solver.middleNode(oddList);
        System.out.print("From Middle Node onwards: ");
        printList(middleOdd); // Expected Output: 3 -> 4 -> 5

        System.out.println("-----------------------------------");

        // 2. Create an even-lengthed linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode evenList = new ListNode(1, 
                            new ListNode(2, 
                            new ListNode(3, 
                            new ListNode(4, 
                            new ListNode(5, 
                            new ListNode(6))))));
        
        System.out.print("Original Even List: ");
        printList(evenList);
        
        ListNode middleEven = solver.middleNode(evenList);
        System.out.print("From Middle Node onwards: ");
        printList(middleEven); // Expected Output: 4 -> 5 -> 6
    }
}

// Original Odd List: 1 -> 2 -> 3 -> 4 -> 5
// From Middle Node onwards: 3 -> 4 -> 5
// -----------------------------------
// Original Even List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
// From Middle Node onwards: 4 -> 5 -> 6