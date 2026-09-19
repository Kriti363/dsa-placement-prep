import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;

public class LeftRotation {

    // Complete the rotateLeft function below.
    static int[] rotateLeft(int d, int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i - d + n) % n;
            result[newIndex] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] nd = scanner.nextLine().trim().split("\\s+");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);

        int[] arr = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] result = rotateLeft(d, arr);

        System.out.println(
            Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(joining(" "))
        );

        scanner.close();
    }
}