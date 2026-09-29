import java.util.*;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        // Step 1: Sort
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];   // smaller k first
            return b[0] - a[0];       // taller first
        });

        // Step 2: Insert
        List<int[]> list = new ArrayList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        // Convert list to array
        return list.toArray(new int[people.length][]);
    }

    // Optional main for testing
    public static void main(String[] args) {
        QueueReconstructionByHeight obj = new QueueReconstructionByHeight();

        int[][] people = {
            {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };

        int[][] result = obj.reconstructQueue(people);

        for (int[] p : result) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}

// 5 0
// 7 0
// 5 2
// 6 1
// 4 4
// 7 1