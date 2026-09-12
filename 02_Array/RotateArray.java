// Rotate an Array-:

class RotateArray
{
    static void rotateLeft(int[] arr)
    {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++)
        {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int k = 3;   // number of rotations
        for (int r = 0; r < k; r++)
        {
            rotateLeft(arr);
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}