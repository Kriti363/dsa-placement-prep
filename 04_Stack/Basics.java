// Stack-: In Java, a Stack is a linear data structure that follows the LIFO (Last-In-First-Out) principle. The last element added to the stack is the first one to be removed.

// While Java provides a legacy java.util.Stack class, modern Java development favors using the Deque interface (via ArrayDeque) to implement stack behavior.

// Stack Implementation using Array-:

public class Basics
{
    public static void main (String args[])
    {
        Stack s = new Stack(5);
        s.push(20);
        s.push(10);
        s.push(50);
        s.push(30);
        s.push(40);

        System.out.println(s.pop());           // 40
        System.out.println(s.peek());         //  30
        System.out.println(s.isEmpty());     //   false
    }
}

class Stack
{
    int[] stack;
    int top;
    int capacity;

    Stack (int capacity)
    {
        stack = new int[capacity];
        this.capacity = capacity;
        top = -1;
    }

    void push (int val)
    {
        if (top == capacity - 1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = val;
    }

    int pop()
    {
        if (top == -1)
        {
            System.out.println("Stack is Empty");
        }
        int deleted = stack[top];
        top--;

        return deleted;
    }

    int peek ()
    {
        if (top == -1)
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    boolean isEmpty()
    {
        return top == -1;
    }
}


// push, pop, peek, isEmpty, size