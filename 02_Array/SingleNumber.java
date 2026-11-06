public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // XORing a number with itself gives 0 (a ^ a = 0)
        // XORing a number with 0 gives the number itself (a ^ 0 = a)
        // All duplicate pairs cancel out, leaving only the single unique number
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        SingleNumber solver = new SingleNumber();
        
        int[] test1 = {2, 2, 1};       // Expected: 1
        int[] test2 = {4, 1, 2, 1, 2}; // Expected: 4
        int[] test3 = {1};             // Expected: 1
        
        System.out.println("Test 1: " + solver.singleNumber(test1));
        System.out.println("Test 2: " + solver.singleNumber(test2));
        System.out.println("Test 3: " + solver.singleNumber(test3));
    }
}
