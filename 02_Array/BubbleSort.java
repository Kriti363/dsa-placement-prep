// Bubble Sort-:
// We swap with the immediate indexes.

// Bubble Sort is a simple, comparison-based sorting algorithm that works by repeatedly swapping adjacent elements if they are in the wrong order. Over multiple passes through the array, the largest unsorted elements "bubble up" to their correct positions at the end of the list.

// On completing the first pass, the greatest element will reach at last.


public class BubbleSort
{
    static void bubbleSort(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 1; j < arr.length; j++)
            {
                if (arr[j] < arr[j-1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                }
            }
        }
    }
    public static void main(String args[])
    {
        int arr[] = {47, 24, 18, 55, 15, 20, };
        bubbleSort(arr);
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
// 47
// 55