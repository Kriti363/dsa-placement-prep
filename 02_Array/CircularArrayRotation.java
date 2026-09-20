import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class CircularArrayRotation {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        k %= n;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = ((queries[i] - k) % n + n) % n;
            result[i] = a[idx];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            in.nextToken();
            queries[i] = (int) in.nval;
        }

        int[] result = circularArrayRotation(a, k, queries);

        StringBuilder out = new StringBuilder();
        for (int v : result) {
            out.append(v).append("\n");
        }
        System.out.print(out);
    }
}