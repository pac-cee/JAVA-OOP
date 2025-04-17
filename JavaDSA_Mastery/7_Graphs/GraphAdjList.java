import java.util.*;
public class GraphAdjList {
    private int V;
    private List<List<Integer>> adj;
    public GraphAdjList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected
    }
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int n : adj.get(node)) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
        System.out.println();
    }
    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int n : adj.get(node)) {
            if (!visited[n]) dfsUtil(n, visited);
        }
    }
    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(5);
        g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 3); g.addEdge(1, 4);
        System.out.print("BFS: "); g.bfs(0); // BFS: 0 1 2 3 4
        System.out.print("DFS: "); g.dfs(0); // DFS: 0 1 3 4 2
    }
}
