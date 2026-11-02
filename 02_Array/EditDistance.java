public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] will store the minimum operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: converting an empty string to word2 requires insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Base case: converting word1 to an empty string requires deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, no new operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If characters don't match, take the minimum of:
                    // 1. Replace: dp[i-1][j-1] + 1
                    // 2. Delete:  dp[i-1][j] + 1
                    // 3. Insert:  dp[i][j-1] + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        EditDistance solver = new EditDistance();
        
        String word1 = "horse", word2 = "ros";
        String word3 = "intention", word4 = "execution";
        
        System.out.println("Test 1 (Expected: 3): " + solver.minDistance(word1, word2));
        System.out.println("Test 2 (Expected: 5): " + solver.minDistance(word3, word4));
    }
}
