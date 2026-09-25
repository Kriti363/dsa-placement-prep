// Graph-:
// It is a non-linear data structure like tree data structure. A Graph is composed of a set of vertices(V) and a set of edges(E). The vertices are connected with each other through edges.
// The limitation of tree is, it can only represent hierarchical data. For situations where nodes or vertices are randomly connected with each other other, we use Graph.
// Example situations where we use graph data structure are, a social network, a computer network, a network of locations used in GPS and many more examples where different nodes or vertices are connected without any hierarchic or constraint on structure.

// Types-:
// 1) Weighted graph  2) Unweighted graph  3) Undirected graph  4) Directed graph  5) Cyclic graph  6) Acyclic graph

import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.Queue;

class Basics
{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    Basics(int vertices)
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
        adjList.get(v).add(u);   // undirected graph, so add both directions
    }

    void bfs(int start)
    {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");
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

    void dfs(int start)
    {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        dfsRec(start, visited);
        System.out.println();
    }

    void dfsRec(int curr, boolean[] visited)
    {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (int neighbor : adjList.get(curr))
        {
            if (!visited[neighbor])
            {
                dfsRec(neighbor, visited);
            }
        }
    }

    public static void main(String[] args)
    {
        Basics graph = new Basics(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);
        graph.dfs(0);
    }
}


// BFS: 0 1 2 3 4 5 
// DFS: 0 1 3 5 4 2 