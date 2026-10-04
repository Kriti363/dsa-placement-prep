public class RomanToInteger {

    public int romanToInt(String s) {
        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentVal = getValue(s.charAt(i));

            // If this is not the last character and the current value is less 
            // than the next value, apply the subtraction rule
            if (i < n - 1 && currentVal < getValue(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }

        return total;
    }

    // Helper method using a switch case for optimal performance over a HashMap
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        RomanToInteger solver = new RomanToInteger();

        // Test Case 1: Simple Addition
        String test1 = "III";
        System.out.println("Input: " + test1 + " -> Output: " + solver.romanToInt(test1)); // Expected: 3

        // Test Case 2: Subtraction Rule Mixture
        String test2 = "LVIII";
        System.out.println("Input: " + test2 + " -> Output: " + solver.romanToInt(test2)); // Expected: 58

        // Test Case 3: Complex Subtractions
        String test3 = "MCMXCIV";
        System.out.println("Input: " + test3 + " -> Output: " + solver.romanToInt(test3)); // Expected: 1994
    }
}

// Input: III -> Output: 3
// Input: LVIII -> Output: 58
// Input: MCMXCIV -> Output: 1994