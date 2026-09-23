// Number of Recent Calls-:

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {

    Queue<Integer> queue;

    public NumberofRecentCalls() {
        queue = new LinkedList<>();
    }

    // Adds a new request at time t, and returns the number of requests
    // that occurred in the inclusive range [t - 3000, t]
    public int ping(int t) {
        queue.add(t);

        // Remove all requests that are older than (t - 3000)
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        NumberofRecentCalls obj = new NumberofRecentCalls();

        System.out.println(obj.ping(1));     // 1  -> requests in [-2999, 1] = [1]
        System.out.println(obj.ping(100));   // 2  -> requests in [-2900, 100] = [1, 100]
        System.out.println(obj.ping(3001));  // 3  -> requests in [1, 3001] = [1, 100, 3001]
        System.out.println(obj.ping(3002));  // 3  -> requests in [2, 3002] = [100, 3001, 3002] (1 dropped)
    }
}
