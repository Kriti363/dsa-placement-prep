import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        
        // Total number of elements in an n-bit Gray code sequence is 2^n
        int totalElements = 1 << n; // Equivalent to 2^n using bit shifting
        
        for (int i = 0; i < totalElements; i++) {
            // Apply the standard formula: i XOR (i shifted right by 1)
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        GrayCode solver = new GrayCode();

        // Test Case 1: n = 2
        int n1 = 2;
        System.out.println("n = " + n1 + " -> Gray Code Sequence: " + solver.grayCode(n1));
        // Expected: [0, 1, 3, 2]
        // Binary equivalent: [00, 01, 11, 10] (Notice only 1 bit changes at each step)

        // Test Case 2: n = 1
        int n2 = 1;
        System.out.println("n = " + n2 + " -> Gray Code Sequence: " + solver.grayCode(n2));
        // Expected: [0, 1]

        // Test Case 3: n = 3
        int n3 = 3;
        System.out.println("n = " + n3 + " -> Gray Code Sequence: " + solver.grayCode(n3));
        // Expected: [0, 1, 3, 2, 6, 7, 5, 4]
    }
}
