// Reversing of an Array-:

class ReverseAnArray
{
    static void reverse(int[] arr)
    {
        int left = 0, right = arr.length - 1;
        while (left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public static void main (String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50};

        reverse(arr);

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}