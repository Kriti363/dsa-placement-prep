import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from index 0 with an empty current subset list
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to the final result list
        result.add(new ArrayList<>(currentSubset));

        // Explore all possible subsequent elements to build the power set
        for (int i = start; i < nums.length; i++) {
            // 1. Include the current element in the subset
            currentSubset.add(nums[i]);
            
            // 2. Move deeper into the decision tree with the next available elements
            backtrack(result, currentSubset, nums, i + 1);
            
            // 3. Backtrack by removing the last added element to explore other choices
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        Subsets solver = new Subsets();
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> output = solver.subsets(nums);
        System.out.println("All Subsets: " + output);
    }
}
