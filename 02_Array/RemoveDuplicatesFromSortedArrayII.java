public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        // If the array has 2 or fewer elements, it already meets the condition
        if (nums.length <= 2) {
            return nums.length;
        }

        // Initialize the pointer where the next valid element will be written.
        // The first two elements are always allowed.
        int writeIndex = 2;

        // Iterate through the array starting from the third element
        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element located 2 positions back
            // from our current writing position.
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        // writeIndex represents the new length of the modified array
        return writeIndex;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII solver = new RemoveDuplicatesFromSortedArrayII();

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int len1 = solver.removeDuplicates(nums1);
        System.out.print("Test Case 1 New Length: " + len1 + " -> Elements: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println(); // Expected output: 1 1 2 2 3

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len2 = solver.removeDuplicates(nums2);
        System.out.print("Test Case 2 New Length: " + len2 + " -> Elements: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println(); // Expected output: 0 0 1 1 2 3 3
    }
}

// Test Case 1 New Length: 5 -> Elements: 1 1 2 2 3 
// Test Case 2 New Length: 7 -> Elements: 0 0 1 1 2 3 3 