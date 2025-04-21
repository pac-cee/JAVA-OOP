import java.util.*;

public class PathFinder {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) { this.to = to; this.weight = weight; }
    }
    public static List<Integer> dijkstra(List<Edge>[] graph, int src, int dest) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); Arrays.fill(prev, -1);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;
            for (Edge e : graph[u]) {
                if (dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                    prev[e.to] = u;
                    pq.add(new int[]{e.to, dist[e.to]});
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = prev[at]) path.add(at);
        Collections.reverse(path);
        return path.get(0) == src ? path : new ArrayList<>();
    }
    public static void main(String[] args) {
        int n = 5;
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        graph[0].add(new Edge(1, 2)); graph[0].add(new Edge(2, 4));
        graph[1].add(new Edge(2, 1)); graph[1].add(new Edge(3, 7));
        graph[2].add(new Edge(4, 3)); graph[3].add(new Edge(4, 1));
        List<Integer> path = dijkstra(graph, 0, 4);
        System.out.println("Shortest path from 0 to 4: " + path);
    }
}
