// Array-:
// An array in Java is a dynamically allocated object that acts as a container holding a fixed number of values of a single data type.
// Contiguous memory location, fixed size, homogeneous elements.

// How to initialize and Array?
// Two ways-: 1) Static  2) Dynamic

class ArrayExample
{
    public static void main (String args[])
    {
        //int[] arr1 = new int [5];                 // Dynamic initialization (cause we don't know the value)
        int[] arr2 = { 10, 12, 45, 85, 46 };      //  Static initialization (cause values are known)
        int[] prefixSum = new int[arr2.length];
        prefixSum[0] = arr2[0];

        //arr1[2] = 50;

        //System.out.println(arr2[1]);           // 12 
        //System.out.println(arr1[2]);          //  50

        //int sum = 0;

        //for(int i = 0; i < 5; i++)
        for(int i = 1; i < arr2.length; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + arr2[i];
            //sum = sum + arr2[i];                   // Sum of all the elements.

            //System.out.println(arr1[i]); 
            //System.out.println(arr2[i]);     
            //System.out.println(sum);             // sum of the prefixes.
        }

        for (int i = 0; i < prefixSum.length; i++)
            System.out.println(prefixSum[i] + " ");
        //System.out.println(sum);        // sum of all the elements.
    }
}




