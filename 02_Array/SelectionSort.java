// Selection Sort is a straightforward, comparison-based sorting algorithm in Java. It works by repeatedly dividing the array into a sorted and an unsorted boundary, finding the minimum element from the unsorted section, and swapping it with the first element of that unsorted section.

// When to Use Selection Sort:
// 1) Costly Memory Writes-> Selection sort performs a maximum of O(n) swaps. If writing to memory or disk is significantly more expensive than reading from it, selection sort holds an advantage over algorithms like bubble sort.
// 2) Small Datasets-> Useful when the dataset size is small enough that the overhead of more complex algorithms (\(O(n \log n)\) algorithms like Quick Sort or Merge Sort) is unnecessary.

// Steps-:
// 1) We check the smallest element first.
// 2) We will assume that the first element is the smallest.
// 3) Store it's index and compare.
// 4) Keep replacing if the next value is small from the stored value.

public class SelectionSort
{
    static void selectionSort(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            int smallest = i;
            for(int j = i; j < arr.length; j++)
            {
                if( arr[j] < arr[smallest])
                {
                   smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }    
    }
    public static void main(String args[])
    {
        int arr[] = {47, 24, 18, 55, 15, 20, };
        selectionSort(arr);
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