// Searching In Array-: 1) Linear search  2) Binary search

// Linear search- When data is limited and the data is unsorted.
// We need to run a loop and then compare all the values one by one with our key, as soon as we get the key value we will return the index value.

class LinearSearch
{
    static int linearSearch (int[] arr, int key)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == key)
            {
                return i;
            }
        }
        return -1;
    }
public static void main (String args[])
{
    int [] arr = {10, 12, 20, 15, 6};
    int key = 15;

    SearchingInArray obj = new SearchingInArray();
    int result = obj.linearSearch(arr, key);

    System.out.println("Element found at index: " + result);          // Element found at index: 3
}
}


