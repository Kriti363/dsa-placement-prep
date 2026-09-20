import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridSearch {

    static String gridSearch(String[] G, String[] P) {
        int R = G.length, r = P.length;

        for (int i = 0; i <= R - r; i++) {
            // find every occurrence of the first pattern row in this grid row
            int start = G[i].indexOf(P[0]);
            while (start != -1) {
                boolean match = true;
                for (int k = 1; k < r; k++) {
                    if (!G[i + k].startsWith(P[k], start)) {
                        match = false;
                        break;
                    }
                }
                if (match) return "YES";
                start = G[i].indexOf(P[0], start + 1);
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String[] G = new String[R];
            for (int i = 0; i < R; i++) {
                G[i] = br.readLine().trim();
            }

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String[] P = new String[r];
            for (int i = 0; i < r; i++) {
                P[i] = br.readLine().trim();
            }

            out.append(gridSearch(G, P)).append("\n");
        }

        System.out.print(out);
    }
}