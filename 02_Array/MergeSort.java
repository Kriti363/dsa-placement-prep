// Merge Sort-:
// Merge Sort is an efficient, stable, and comparison-based sorting algorithm that follows the Divide and Conquer paradigm. It works by recursively splitting an array in half until individual elements are reached, and then merging those halves back together in sorted order.

// We'll define two pointers- left and right.
// First we'll write the code for diving and the for merging.
// Therefore the time complexity for this is O(nlogn)

public class MergeSort
{
    static void merge(int[] arr, int left, int mid, int right)
    {
        int temp[] = new int[right - left + 1];
        int idx1 = left;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= right)
        {
            if (arr[idx1] <= arr[idx2])
            {
                temp[x++] = arr[idx1++];
            }
            else
            {
                temp[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid)
        {
            temp[x++] = arr[idx1++];
        }
        while (idx2 <= right)
        {
            temp[x++] = arr[idx2++];
        }

        for (int i = 0; i < temp.length; i++)
        {
            arr[left + i] = temp[i];
        }
    }

    static void mergeSort(int arr[], int left, int right)
    {
        if (left >= right)
        {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args)
    {
        int arr[] = {47, 24, 18, 55, 15, 20, 36};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}