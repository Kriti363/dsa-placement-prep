public class JumpGame {
    public boolean canJump(int[] nums) {
        // Track the furthest index we can possibly reach
        int maxReachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the furthest reachable index, we are stuck
            if (i > maxReachable) {
                return false;
            }
            
            // Dynamically update the furthest reachable index from the current position
            maxReachable = Math.max(maxReachable, i + nums[i]);
            
            // Early exit optimization: if we can already reach or pass the last index, return true
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        
        int[] test1 = {2, 3, 1, 1, 4};
        int[] test2 = {3, 2, 1, 0, 4};
        
        System.out.println("Test 1 (Expected: true): " + game.canJump(test1));
        System.out.println("Test 2 (Expected: false): " + game.canJump(test2));
    }
}
