public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Base edge case check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Map the 1D index back to 2D coordinates
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        Search2DMatrix solver = new Search2DMatrix();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Test Case 1: Target exists in the matrix
        int target1 = 3;
        System.out.println("Target " + target1 + " found: " + solver.searchMatrix(matrix, target1)); // Expected: true

        // Test Case 2: Target does not exist in the matrix
        int target2 = 13;
        System.out.println("Target " + target2 + " found: " + solver.searchMatrix(matrix, target2)); // Expected: false
    }
}

// Target 3 found: true
// Target 13 found: false