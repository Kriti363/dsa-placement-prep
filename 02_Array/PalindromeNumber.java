public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = (reversedNum * 10) + (x % 10);
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by reversedNum/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, reversedNum = 123,
        // since the middle digit doesn't matter in palindrome, we can simply get rid of it.
        return x == reversedNum || x == reversedNum / 10;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        PalindromeNumber solver = new PalindromeNumber();

        // Test Case 1: Positive Palindrome
        int test1 = 121;
        System.out.println("Input: " + test1 + " -> Output: " + solver.isPalindrome(test1)); // Expected: true

        // Test Case 2: Negative Number
        int test2 = -121;
        System.out.println("Input: " + test2 + " -> Output: " + solver.isPalindrome(test2)); // Expected: false

        // Test Case 3: Not a Palindrome
        int test3 = 10;
        System.out.println("Input: " + test3 + " -> Output: " + solver.isPalindrome(test3)); // Expected: false
    }
}

// Input: 121 -> Output: true
// Input: -121 -> Output: false
// Input: 10 -> Output: false