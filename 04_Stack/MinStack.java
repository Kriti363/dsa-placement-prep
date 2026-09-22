import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // If minStack is empty, the current value is the min.
        // Otherwise, push the smaller value between val and the current min.
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // Main method to test locally in VS Code / Codespaces
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Current Min: " + minStack.getMin()); // Returns -3

        minStack.pop();
        System.out.println("Top Element: " + minStack.top());    // Returns 0
        System.out.println("Current Min: " + minStack.getMin()); // Returns -2
    }
}