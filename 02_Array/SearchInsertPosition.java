public class SearchInsertPosition {

    // Standard LeetCode method signature
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Prevent potential integer overflow
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // low represents the correct sorted insertion index if the element is not found
        return low;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        SearchInsertPosition solver = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};

        // Test Case 1: Target exists in the array
        int target1 = 5;
        System.out.println("Target " + target1 + " Index: " + solver.searchInsert(nums, target1)); // Expected: 2

        // Test Case 2: Target does not exist (inserted in the middle)
        int target2 = 2;
        System.out.println("Target " + target2 + " Index: " + solver.searchInsert(nums, target2)); // Expected: 1

        // Test Case 3: Target does not exist (inserted at the end)
        int target3 = 7;
        System.out.println("Target " + target3 + " Index: " + solver.searchInsert(nums, target3)); // Expected: 4
    }
}

// Target 5 Index: 2
// Target 2 Index: 1
// Target 7 Index: 4
