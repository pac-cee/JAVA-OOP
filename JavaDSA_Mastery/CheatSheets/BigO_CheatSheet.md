# Big O Complexity Cheat Sheet (Java DSA)

| Operation         | Array | Linked List | Stack/Queue | HashMap | Binary Tree | Heap | Graph |
|-------------------|-------|-------------|-------------|---------|-------------|------|-------|
| Access            | O(1)  | O(n)        | O(n)        | O(1)    | O(log n)    | O(1) | O(1)  |
| Search            | O(n)  | O(n)        | O(n)        | O(1)    | O(log n)    | O(n) | O(V+E)|
| Insert            | O(n)  | O(1)        | O(1)        | O(1)    | O(log n)    | O(log n)|O(1) |
| Delete            | O(n)  | O(1)        | O(1)        | O(1)    | O(log n)    | O(log n)|O(1)|

- n = number of elements
- V = vertices, E = edges

**Tip:** HashMap operations are O(1) on average, but can degrade to O(n) in worst case (hash collisions).
