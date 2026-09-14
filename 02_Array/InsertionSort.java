// Insertion Sort-:
// Insertion sort is a simple, intuitive sorting algorithm that builds the final sorted array one item at a time. It works similarly to the way you sort playing cards in your hands: you take one card from an unsorted pile and insert it into its correct position within your sorted hand.

public class InsertionSort
{
    static void insertionSort (int arr[])
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;        
            }
            arr[j + 1] = key;
        }
    }
    public static void main (String args[])
    {
        int arr[] =  {47, 24, 18, 55, 15, 20, };
        insertionSort(arr);
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