import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImplementations
{
    // ================= ADJACENCY LIST (undirected) =================
    static class GraphList
    {
        int vertices;
        ArrayList<ArrayList<Integer>> adjList;

        GraphList(int vertices)
        {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++)
            {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v)
        {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        void bfs(int start)
        {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            System.out.print("BFS (list): ");
            while (!queue.isEmpty())
            {
                int curr = queue.poll();
                System.out.print(curr + " ");

                for (int neighbor : adjList.get(curr))
                {
                    if (!visited[neighbor])
                    {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        void dfsRecursive(int start)
        {
            boolean[] visited = new boolean[vertices];
            System.out.print("DFS recursive (list): ");
            dfsHelper(start, visited);
            System.out.println();
        }

        void dfsHelper(int curr, boolean[] visited)
        {
            visited[curr] = true;
            System.out.print(curr + " ");

            for (int neighbor : adjList.get(curr))
            {
                if (!visited[neighbor])
                {
                    dfsHelper(neighbor, visited);
                }
            }
        }

        void dfsIterative(int start)
        {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            System.out.print("DFS iterative (list): ");
            while (!stack.isEmpty())
            {
                int curr = stack.pop();

                if (!visited[curr])
                {
                    visited[curr] = true;
                    System.out.print(curr + " ");

                    for (int neighbor : adjList.get(curr))
                    {
                        if (!visited[neighbor])
                        {
                            stack.push(neighbor);
                        }
                    }
                }
            }
            System.out.println();
        }

        boolean hasPath(int src, int dest)
        {
            boolean[] visited = new boolean[vertices];
            return hasPathHelper(src, dest, visited);
        }

        boolean hasPathHelper(int curr, int dest, boolean[] visited)
        {
            if (curr == dest)
            {
                return true;
            }
            visited[curr] = true;

            for (int neighbor : adjList.get(curr))
            {
                if (!visited[neighbor] && hasPathHelper(neighbor, dest, visited))
                {
                    return true;
                }
            }
            return false;
        }
    }

    // ================= ADJACENCY MATRIX (directed) =================
    static class GraphMatrix
    {
        int vertices;
        int[][] matrix;

        GraphMatrix(int vertices)
        {
            this.vertices = vertices;
            matrix = new int[vertices][vertices];
        }

        void addEdge(int u, int v)
        {
            matrix[u][v] = 1;   // directed: only one direction
        }

        void printMatrix()
        {
            System.out.println("Adjacency Matrix:");
            for (int i = 0; i < vertices; i++)
            {
                for (int j = 0; j < vertices; j++)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        void bfs(int start)
        {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            System.out.print("BFS (matrix): ");
            while (!queue.isEmpty())
            {
                int curr = queue.poll();
                System.out.print(curr + " ");

                for (int i = 0; i < vertices; i++)
                {
                    if (matrix[curr][i] == 1 && !visited[i])
                    {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        System.out.println("=== Adjacency List Graph (undirected) ===");
        GraphList g1 = new GraphList(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 5);
        g1.addEdge(4, 5);

        g1.bfs(0);
        g1.dfsRecursive(0);
        g1.dfsIterative(0);
        System.out.println("Path from 0 to 5? " + g1.hasPath(0, 5));

        System.out.println("\n=== Adjacency Matrix Graph (directed) ===");
        GraphMatrix g2 = new GraphMatrix(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(3, 0);

        g2.printMatrix();
        g2.bfs(0);
    }
}

// === Adjacency Matrix Graph (directed) ===
// Adjacency Matrix:
// 0 1 0 0 
// 0 0 1 0 
// 0 0 0 1 
// 1 0 0 0 
// BFS (matrix): 0 1 2 3 