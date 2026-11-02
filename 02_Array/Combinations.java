import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from number 1 with an empty combination list
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int start, int n, int k) {
        // Base case: if the combination reaches the target size k, add it to the result
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Optimization: Only loop up to the point where there are enough remaining numbers to fill the combination
        // n - (k - currentCombination.size()) + 1 ensures we don't explore dead ends
        for (int i = start; i <= n - (k - currentCombination.size()) + 1; i++) {
            // 1. Include the current number
            currentCombination.add(i);
            
            // 2. Move deeper into the decision tree to pick the next number
            backtrack(result, currentCombination, i + 1, n, k);
            
            // 3. Backtrack by removing the last added number to try other choices
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        Combinations solver = new Combinations();
        int n = 4, k = 2;
        
        List<List<Integer>> output = solver.combine(n, k);
        System.out.println("Combinations (n=" + n + ", k=" + k + "): " + output);
        // Expected Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
