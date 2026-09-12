// Binary search- Data must be in sorted order either in ascending or decending order. 

// We assign two pointers, one from left and one from right. 
// Left will be kept on first index and right on last index.
// Calculte mid.
// 1st condition-> key == mid
// 2nd conditon-> arr[mid] < key
// 3rd condition-> arr[mid] > key
// Then shift accordingly to the mid value and continue repeating until the key is found.
// At last return mid which will be equal to the key.

class BinarySearch
{
    static int binarySearch(int[] arr, int key)
    {
        int left = 0, right = arr.length - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;

            if(arr[mid] == key)
            {
                return mid;
            }
            else if(arr[mid] < key)
            {
                left = mid +  1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main (String args[])
    {
        int arr[] = {15, 19, 20, 26, 32, 37, 43, 57, 60, 74, 85};

        System.out.println(binarySearch(arr, 57));      // 7
    }
   
}