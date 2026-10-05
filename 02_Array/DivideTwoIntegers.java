public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        // Handle overflow case: Integer.MIN_VALUE / -1 = Integer.MAX_VALUE + 1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // true if signs match (positive result), false if they differ (negative result)
        boolean isPositive = (dividend < 0) == (divisor < 0);

        // Convert to absolute values using long to avoid integer overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Shift divisor exponentially until it fits into the remaining dividend
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Double the divisor and the multiple as long as it fits
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Deduct the highest found value from dividend and add multiple to result
            absDividend -= tempDivisor;
            result += multiple;
        }

        return isPositive ? result : -result;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        DivideTwoIntegers solver = new DivideTwoIntegers();

        // Test Case 1: Standard positive result
        int dividend1 = 10, divisor1 = 3;
        System.out.println("Input: " + dividend1 + " / " + divisor1 + " -> Output: " + solver.divide(dividend1, divisor1)); // Expected: 3

        // Test Case 2: Negative result
        int dividend2 = 7, divisor2 = -3;
        System.out.println("Input: " + dividend2 + " / " + divisor2 + " -> Output: " + solver.divide(dividend2, divisor2)); // Expected: -2

        // Test Case 3: Overflow scenario
        int dividend3 = Integer.MIN_VALUE, divisor3 = -1;
        System.out.println("Input: MIN_VALUE / -1 -> Output: " + solver.divide(dividend3, divisor3)); // Expected: 2147483647 (Integer.MAX_VALUE)
    }
}

// Input: 10 / 3 -> Output: 3
// Input: 7 / -3 -> Output: -2
// Input: MIN_VALUE / -1 -> Output: 2147483647