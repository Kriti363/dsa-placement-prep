import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // An IP address has exactly 4 segments, maximum length cannot exceed 12
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, s, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<String> result, String s, List<String> currentSegments, int start) {
        // Base Case: If we have successfully formed 4 segments
        if (currentSegments.size() == 4) {
            // If we also consumed the entire input string, it's a valid combination
            if (start == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }

        // Optimization: If the remaining characters are too many or too few for the remaining segments
        int remainingSegments = 4 - currentSegments.size();
        int remainingChars = s.length() - start;
        if (remainingChars < remainingSegments || remainingChars > remainingSegments * 3) {
            return;
        }

        // Try generating segments of length 1, 2, and 3
        for (int len = 1; len <= 3; len++) {
            // Out of bounds check
            if (start + len > s.length()) {
                break;
            }

            String segment = s.substring(start, start + len);
            
            // Check for leading zero rule: lengths of 2 or 3 cannot start with '0'
            if (len > 1 && segment.charAt(0) == '0') {
                continue;
            }
            
            // Check for value cap rule: value must be between 0 and 255
            if (len == 3 && Integer.parseInt(segment) > 255) {
                continue;
            }

            // 1. Choose: Add the valid segment
            currentSegments.add(segment);
            
            // 2. Explore: Move deeper into the decision tree
            backtrack(result, s, currentSegments, start + len);
            
            // 3. Backtrack: Remove the segment to explore other lengths
            currentSegments.remove(currentSegments.size() - 1);
        }
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        RestoreIPAddresses solver = new RestoreIPAddresses();
        
        String test1 = "25525511135";
        String test2 = "0000";
        String test3 = "101023";
        
        System.out.println("Test 1: " + solver.restoreIpAddresses(test1));
        // Expected: ["255.255.11.135", "255.255.111.35"]
        
        System.out.println("Test 2: " + solver.restoreIpAddresses(test2));
        // Expected: ["0.0.0.0"]
        
        System.out.println("Test 3: " + solver.restoreIpAddresses(test3));
        // Expected: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}
