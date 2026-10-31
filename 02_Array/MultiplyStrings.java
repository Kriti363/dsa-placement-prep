public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Direct edge case check: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // The maximum possible length of the product of two numbers is m + n
        int[] pos = new int[m + n];
        
        // Loop from right to left to simulate manual long multiplication
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;       // Tens position index
                int p2 = i + j + 1;   // Ones position index
                
                int sum = mul + pos[p2];
                
                pos[p1] += sum / 10;  // Carry over to the left
                pos[p2] = sum % 10;   // Remainder at current position
            }
        }
        
        // Convert the tracking array into the final result string
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }

    // Optional main method to verify locally
    public static void main(String[] args) {
        MultiplyStrings solver = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println("Product: " + solver.multiply(num1, num2)); // Expected: 56088
    }
}
