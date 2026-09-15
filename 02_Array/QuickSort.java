// Quick Sort-:
// Quick Sort is an efficient, in-place sorting algorithm that follows the divide-and-conquer strategy. It works by picking an element as a pivot, partitioning the array around that pivot so that smaller elements go to the left and larger elements go to the right, and then recursively sorting the resulting sub-arrays.

public class QuickSort
{
    static void quickSort(int arr[], int start, int end)
    {
        if(start >= end)
        {
            return;
        }
        int pi = partition(arr, start, end);
        quickSort(arr, start, pi - 1);
        quickSort(arr, pi + 1, end);
    }
    static int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];
        int i = start - 1;

        for(int j = start; j < end; j++)
            {
                if(arr[j] <= pivot)
                {
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            i++;
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            return i; 
    }
    public static void main(String[] args)
    {
        int arr[] = {47, 24, 18, 55, 15, 20, 36};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}


// 15
// 18
// 20
// 24
// 36
// 47
// 55