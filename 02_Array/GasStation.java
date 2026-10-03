public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If we run out of gas before reaching the next station
            if (currentGas < 0) {
                // The current station cannot be the start, and neither can any previous ones
                startingStation = i + 1;
                // Reset our tank for the new starting point
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, completing the circuit is impossible
        if (totalGas < totalCost) {
            return -1;
        }

        return startingStation;
    }

    // Main method to run and verify the solution locally
    public static void main(String[] args) {
        GasStation solver = new GasStation();

        // Test Case 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        int result1 = solver.canCompleteCircuit(gas1, cost1);
        System.out.println("Test Case 1 Output: " + result1); // Expected: 3

        // Test Case 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        int result2 = solver.canCompleteCircuit(gas2, cost2);
        System.out.println("Test Case 2 Output: " + result2); // Expected: -1
    }
}

// Test Case 1 Output: 3
// Test Case 2 Output: -1
