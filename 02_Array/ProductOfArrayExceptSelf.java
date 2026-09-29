public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Left products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Right products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] result = obj.productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

// 24 12 8 6