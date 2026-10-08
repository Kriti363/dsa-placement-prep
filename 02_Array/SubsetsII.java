import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to ensure duplicate elements are placed next to each other
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the currently built subset to our final result list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // If the element is a duplicate of the previous element at the same recursion depth, skip it
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the element in the current subset branch
            currentSubset.add(nums[i]);
            
            // Move deeper into the decision tree with the next index
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: remove the last element before checking alternative branches
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        SubsetsII solver = new SubsetsII();

        // Test Case 1: Array with duplicates
        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets for [1, 2, 2]:");
        System.out.println(solver.subsetsWithDup(nums1));
        // Expected output contains 6 unique subsets: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

        // Test Case 2: Array with single element
        int[] nums2 = {0};
        System.out.println("\nSubsets for [0]:");
        System.out.println(solver.subsetsWithDup(nums2));
        // Expected output: [[], [0]]
    }
}
