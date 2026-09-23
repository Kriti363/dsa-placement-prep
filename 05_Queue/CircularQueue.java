// Circular Queue using Stack-:

import java.util.Stack;

class CircularQueue {
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.print();

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        System.out.println("After dequeue, front is: " + q.peek());

        q.print();
    }
}

class QueueUsingStacks {
    Stack<Integer> inStack;   // used for enqueue
    Stack<Integer> outStack;  // used for dequeue/peek

    QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Enqueue is always O(1) - just push to inStack
    void enqueue(int value) {
        inStack.push(value);
    }

    // Dequeue removes the front element
    void dequeue() {
        shiftIfNeeded();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        outStack.pop();
    }

    // Peek returns the front element without removing it
    int peek() {
        shiftIfNeeded();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outStack.peek();
    }

    // Moves elements from inStack to outStack only when outStack is empty
    // This reverses the order so the oldest element ends up on top
    private void shiftIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    void print() {
        // Print outStack (front to back) then inStack (back to front)
        Stack<Integer> tempOut = (Stack<Integer>) outStack.clone();
        Stack<Integer> tempIn = (Stack<Integer>) inStack.clone();

        System.out.print("Queue: ");
        while (!tempOut.isEmpty()) {
            System.out.print(tempOut.pop() + " ");
        }
        // inStack needs to be reversed to show correct front-to-back order
        Stack<Integer> reversed = new Stack<>();
        while (!tempIn.isEmpty()) {
            reversed.push(tempIn.pop());
        }
        while (!reversed.isEmpty()) {
            System.out.print(reversed.pop() + " ");
        }
        System.out.println();
    }
}

// Queue: 10 20 30 40 
// Front element is: 10
// After dequeue, front is: 20
// Queue: 20 30 40