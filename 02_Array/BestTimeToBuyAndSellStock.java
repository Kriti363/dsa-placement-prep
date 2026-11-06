public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Edge case: if there are fewer than 2 days, no transaction is possible
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Track the lowest price encountered so far
        int minPrice = Integer.MAX_VALUE;
        // Track the maximum profit achievable
        int maxProfit = 0;

        for (int price : prices) {
            // Update the lowest buying price if we find a cheaper day
            if (price < minPrice) {
                minPrice = price;
            } 
            // Otherwise, check if selling today yields a better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        int[] test1 = {7, 1, 5, 3, 6, 4}; // Expected: 5 (Buy at 1, sell at 6)
        int[] test2 = {7, 6, 4, 3, 1};    // Expected: 0 (Prices only decrease)

        System.out.println("Test 1 Profit: " + solver.maxProfit(test1));
        System.out.println("Test 2 Profit: " + solver.maxProfit(test2));
    }
}
