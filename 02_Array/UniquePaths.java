import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Create a 1D DP array to track paths for the current row
        int[] dp = new int[n];
        
        // Base case: There is exactly 1 way to reach any cell in the first row (moving only right)
        Arrays.fill(dp, 1);
        
        // Build the solution row by row from top to bottom
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The paths to the current cell = paths from the top cell (dp[j]) + paths from the left cell (dp[j-1])
                dp[j] += dp[j - 1];
            }
        }
        
        // The last element contains the total unique paths to the bottom-right corner
        return dp[n - 1];
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        UniquePaths solver = new UniquePaths();
        
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;
        
        System.out.println("Grid 3x7 (Expected: 28): " + solver.uniquePaths(m1, n1));
        System.out.println("Grid 3x2 (Expected: 3):  " + solver.uniquePaths(m2, n2));
    }
}
