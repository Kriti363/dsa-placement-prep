// 2D Array-:

public class MultiDimensionalArray 
{
    public static void main(String[] args) 
    {
        int[][] arr = new int[3][3];
        int[][] nums = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };           // 3x3 2D array initialization

        System.out.println(nums[1][0]);           // 4

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;

        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Sum of digonal elements of a 2D array-:
        int sum = 0;
        for (int i = 0; i < arr.length; i++) 
            {
                sum += arr[i][i]; // Summing the diagonal elements
            }
        System.out.println("Sum of diagonal elements: " + sum);

        // Transpose of a 2D array-:
        int[][] transpose = new int[3][3];
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                transpose[j][i] = arr[i][j];    // Transposing the array 
            }
        }

        System.out.println("Transpose of the array: ");
        for (int i = 0; i < transpose.length; i++) 
        {
            for (int j = 0; j < transpose[i].length; j++)
            {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}

