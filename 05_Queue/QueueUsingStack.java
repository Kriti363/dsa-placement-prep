import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> inStack;   // used for enqueue
    Stack<Integer> outStack;  // used for dequeue and peek

    QueueUsingStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Add an element to the queue - O(1)
    void enqueue(int value) {
        inStack.push(value);
    }

    // Remove and return the front element - amortized O(1)
    int dequeue() {
        shiftIfNeeded();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outStack.pop();
    }

    // Return the front element without removing it - amortized O(1)
    int peek() {
        shiftIfNeeded();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outStack.peek();
    }

    boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    int size() {
        return inStack.size() + outStack.size();
    }

    // Moves all elements from inStack to outStack, but only when outStack is empty
    // This reverses the order so the oldest element ends up on top of outStack
    private void shiftIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Front element: " + q.peek());       // 10
        System.out.println("Dequeued: " + q.dequeue());          // 10
        System.out.println("Front element now: " + q.peek());    // 20

        q.enqueue(50);
        System.out.println("Dequeued: " + q.dequeue());          // 20
        System.out.println("Dequeued: " + q.dequeue());          // 30
        System.out.println("Queue size: " + q.size());           // 2
        System.out.println("Is queue empty? " + q.isEmpty());    // false
    }
}