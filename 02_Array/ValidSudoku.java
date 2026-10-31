import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Use a set to track numbers we have already seen in rows, columns, and 3x3 sub-boxes
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                // Only validate if the cell contains a digit
                if (number != '.') {
                    // Create unique string identifiers for rows, columns, and blocks
                    String rowKey = number + " in row " + i;
                    String colKey = number + " in col " + j;
                    String blockKey = number + " in block " + (i / 3) + "-" + (j / 3);
                    
                    // If add() returns false, the value already exists in that row, col, or block
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(blockKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    // Optional main method to verify the implementation locally
    public static void main(String[] args) {
        ValidSudoku validator = new ValidSudoku();
        
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println("Is the Sudoku board valid? " + validator.isValidSudoku(board));
    }
}
