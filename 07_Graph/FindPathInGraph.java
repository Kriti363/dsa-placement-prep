import java.util.ArrayList;
import java.util.List;

class FindPathInGraph
{
    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);   // bi-directional
        }

        boolean[] visited = new boolean[n];
        return dfs(adjList, source, destination, visited);
    }

    boolean dfs(List<List<Integer>> adjList, int curr, int destination, boolean[] visited)
    {
        if (curr == destination)
        {
            return true;
        }
        visited[curr] = true;

        for (int neighbor : adjList.get(curr))
        {
            if (!visited[neighbor] && dfs(adjList, neighbor, destination, visited))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        FindPathInGraph solver = new FindPathInGraph();

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(solver.validPath(3, edges1, 0, 2));   // true

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(solver.validPath(6, edges2, 0, 5));   // false
    }
}