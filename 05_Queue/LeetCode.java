// Number of Students Unable to Eat Lunch-:

import java.util.Scanner;

class LeetCode {

    // Method that solves LeetCode 1700: Number of Students Unable to Eat Lunch
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0, zeros = 0;

        // Count how many students want circular (0) vs square (1) sandwiches
        for (int s : students) {
            if (s == 0) zeros++;
            else ones++;
        }

        // Go through the sandwich stack in order (top to bottom)
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeros == 0) return ones;  // no one wants it, rest are stuck forever
                zeros--;
            } else {
                if (ones == 0) return zeros;  // no one wants it, rest are stuck forever
                ones--;
            }
        }

        return 0; // everyone got fed
    }

    public static void main(String[] args) {
        LeetCode solution = new LeetCode();

        // Example 1
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println("Test 1 -> Students unable to eat: " 
            + solution.countStudents(students1, sandwiches1));
        // Expected output: 0

        // Example 2
        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println("Test 2 -> Students unable to eat: " 
            + solution.countStudents(students2, sandwiches2));
        // Expected output: 3
    }
}

// Test 1 -> Students unable to eat: 0
// Test 2 -> Students unable to eat: 3