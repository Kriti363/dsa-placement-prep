public class DecodeWays {
    public int numDecodings(String s) {
        // Edge case: an empty string or a string starting with '0' cannot be decoded
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        
        // dp[i] will store the number of decode ways for a string of length i
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty string has 1 valid way to be decoded (doing nothing)
        dp[1] = 1; // A single non-zero digit has 1 valid way to be decoded
        
        for (int i = 2; i <= n; i++) {
            // Check single-digit decode (look at the character just before the current position)
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // Check two-digit decode (look at the two characters before the current position)
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();
        
        String test1 = "12";   // Expected: 2 ("AB" or "L")
        String test2 = "226";  // Expected: 3 ("BZ", "VF", or "BBF")
        String test3 = "06";   // Expected: 0 (Leading zero makes it invalid)
        
        System.out.println("Test 1: " + solver.numDecodings(test1));
        System.out.println("Test 2: " + solver.numDecodings(test2));
        System.out.println("Test 3: " + solver.numDecodings(test3));
    }
}
