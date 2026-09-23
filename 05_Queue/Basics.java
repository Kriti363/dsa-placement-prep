//  Queue-:
// In Java, a Queue is a collection designed for holding elements prior to processing, typically arranging elements in a First-In-First-Out (FIFO) order. This means elements are inserted at the back (tail) and removed from the front (head).

// Queue operations- 1) Enqueue (operation to insert an element at the tail of the queue.)  2) Dequeue (operation to remove and return the element at the head)  3) Peek (returns the head element without removing it)  4) size  5) isEmpty  6) Deque (Double Ended Queue)

class Basics {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.print();

        System.out.println("Front element is: " + q.peek());
    }
}

class Queue {
    int front;
    int rear;
    int size;
    int capacity;
    int[] queue;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = value;
        size++;
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        front++;
        size--;
    }

    int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1; // sentinel value indicating "no element"
        }
        return queue[front];
    }

    void print() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

// 10 20 30 40 
// Front element is: 10