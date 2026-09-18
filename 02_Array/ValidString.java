import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (c < 'a' || c > 'z') continue; // skip any unexpected characters
            freq[c - 'a']++;
        }

        // Count how many characters have each frequency value
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq) {
            if (f > 0) {
                freqCount.merge(f, 1, Integer::sum);
            }
        }

        // All characters already occur the same number of times
        if (freqCount.size() == 1) {
            return "YES";
        }

        // More than 2 distinct frequencies -> removing 1 char can't fix it
        if (freqCount.size() > 2) {
            return "NO";
        }

        // Exactly two distinct frequencies
        List<Integer> keys = new ArrayList<>(freqCount.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = freqCount.get(f1), c2 = freqCount.get(f2);

        // Ensure f1 < f2
        if (f1 > f2) {
            int tf = f1; f1 = f2; f2 = tf;
            int tc = c1; c1 = c2; c2 = tc;
        }

        // Case A: the lower frequency is 1 and only one char has it
        //         (dropping that character entirely fixes the string)
        if (c1 == 1 && f1 == 1) {
            return "YES";
        }

        // Case B: only one char has the higher frequency, and it's
        //         exactly 1 more than the lower frequency
        //         (removing one occurrence of it fixes the string)
        if (c2 == 1 && (f2 - f1 == 1)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}