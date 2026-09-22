import java.util.Stack;

public class ValidParentheses {
    public static void main(String args[]) {
        Solution obj = new Solution();

        // Test cases
        System.out.println(obj.isValid("()[]{}")); // Should print: true
        System.out.println(obj.isValid("(]"));     // Should print: false
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                
                // Corrected condition check:
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}