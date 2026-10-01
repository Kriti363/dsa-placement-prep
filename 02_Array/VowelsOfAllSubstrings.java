public class VowelsOfAllSubstrings {
    
    // LeetCode solution method
    public long countVowels(String word) {
        long totalVowels = 0;
        long n = word.length();
        
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                totalVowels += (i + 1) * (n - i);
            }
        }
        
        return totalVowels;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Instantiate the class to call the non-static method
        VowelsOfAllSubstrings solver = new VowelsOfAllSubstrings();

        // Test Case 1
        String word1 = "aba";
        System.out.println("Input: \"" + word1 + "\" -> Output: " + solver.countVowels(word1)); // Expected: 6

        // Test Case 2
        String word2 = "abc";
        System.out.println("Input: \"" + word2 + "\" -> Output: " + solver.countVowels(word2)); // Expected: 3
    }
}

// Input: "aba" -> Output: 6
// Input: "abc" -> Output: 3