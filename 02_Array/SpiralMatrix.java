import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case check for empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        // Initialize boundaries
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 1. Traverse Right along the top boundary
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++; // Shrink top boundary
            
            // 2. Traverse Down along the right boundary
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--; // Shrink right boundary
            
            // 3. Traverse Left along the bottom boundary (check if row still exists)
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--; // Shrink bottom boundary
            }
            
            // 4. Traverse Up along the left boundary (check if column still exists)
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++; // Shrink left boundary
            }
        }
        
        return result;
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        SpiralMatrix solver = new SpiralMatrix();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Spiral Order: " + solver.spiralOrder(matrix));
        // Expected Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
