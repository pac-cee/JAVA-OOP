import java.util.*;

public class GraphApplications {
    // Cycle detection in undirected graph (DFS)
    public static boolean hasCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        return dfs(-1, 0, visited, adj);
    }
    private static boolean dfs(int parent, int v, boolean[] visited, List<Integer>[] adj) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n]) {
                if (dfs(v, n, visited, adj)) return true;
            } else if (n != parent) {
                return true;
            }
        }
        return false;
    }
    // Topological sort (Kahn's Algorithm)
    public static List<Integer> topologicalSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) for (int n : adj[i]) inDegree[n]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (inDegree[i] == 0) q.add(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int n : adj[u]) {
                if (--inDegree[n] == 0) q.add(n);
            }
        }
        return order.size() == V ? order : new ArrayList<>();
    }
    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        adj[0].add(1); adj[1].add(2); adj[2].add(3); adj[3].add(1); // Cycle
        System.out.println("Has cycle: " + hasCycle(V, adj));
        // Topological Sort
        List<Integer>[] dag = new List[4];
        for (int i = 0; i < 4; i++) dag[i] = new ArrayList<>();
        dag[0].add(1); dag[0].add(2); dag[1].add(2); dag[2].add(3);
        System.out.println("Topological sort: " + topologicalSort(4, dag));
    }
}
