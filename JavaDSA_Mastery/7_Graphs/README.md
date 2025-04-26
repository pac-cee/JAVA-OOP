# Graphs in Java

Graphs are powerful data structures for modeling relationships and connections.

---

## What is a Graph?
- A set of nodes (vertices) connected by edges (links).
- **Types:**
  - **Directed:** Edges have a direction (A → B)
  - **Undirected:** Edges have no direction (A — B)
  - **Weighted:** Edges have weights (distances, costs)
  - **Unweighted:** All edges are equal

**Analogy:** Like a city map (intersections = nodes, roads = edges) or a social network (people = nodes, friendships = edges).

**Visual:**
```
A --- B
|   / |
C --- D
```

## Applications
- Social networks (friend recommendations)
- Maps & GPS navigation (shortest path)
- Web page links (Google PageRank)
- Network routing, dependency graphs

## When to Use Graphs?
- To model relationships, connections, or networks

## Pitfalls
- Choosing the wrong representation (adjacency list vs matrix)
- Infinite loops in traversal (forgetting to mark visited nodes)

## Further Reading
- [Graph Data Structure (GeeksforGeeks)](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
- [Graph Implementation in Java](https://www.geeksforgeeks.org/graph-implementation-using-java/)
- [Graph Traversal Algorithms](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/)

## Example: Adjacency List
```java
import java.util.*;
List<List<Integer>> adj = new ArrayList<>();
```

## Exercises
- Implement a simple undirected graph using adjacency list.
- Write BFS and DFS traversals.
- Find the shortest path between two nodes (BFS for unweighted, Dijkstra for weighted).
- Detect a cycle in a directed graph.

---

Continue to 8_Sorting_Algorithms after this.
