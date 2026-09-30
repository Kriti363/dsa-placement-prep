public class FindTownJudge {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;
        int[][] trust = {
            {1, 3},
            {2, 3}
        };

        int judge = solution.findJudge(n, trust);
        System.out.println("The town judge is person: " + judge);
    }
}

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n + 1];
        
        for (int[] relation : trust) {
            int personA = relation[0]; // missing index fixed
            int personB = relation[1]; // missing index fixed
            
            trustScores[personA]--;
            trustScores[personB]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}

// The town judge is person: 3