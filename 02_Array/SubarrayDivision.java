import java.util.*;

class SubarrayDivision
{
    public static int birthday (List<Integer> s, int d, int m)
    {
        int sum = 0;
        int count = 0;

        // First window: sum of first m elements
        for (int i = 0; i < m; i++)
        {
            sum += s.get(i);
        }
        if (sum == d)
        {
            count++;
        }

        // Slide the window across the rest of the array
        for (int i = m; i < s.size(); i++)
        {
            sum += s.get(i);
            sum -= s.get(i - m);
            if (sum == d)
            {
                count++;
            }
        }

        return count;
    }

    public static void main (String argss[])
    {
        List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
        int d = 3;
        int m = 2;

        int result = birthday(s, d, m);
        System.out.println(result);          // 2
    }
}