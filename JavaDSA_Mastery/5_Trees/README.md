# Trees in Java

Trees are hierarchical data structures used to represent relationships and hierarchies.

---

## What is a Tree?
- A tree consists of nodes connected by edges.
- Has a single root node, internal nodes, and leaf nodes (no children).
- **Types:**
  - **Binary Tree:** Each node has at most 2 children.
  - **Binary Search Tree (BST):** Left < root < right.
  - **AVL/Red-Black Tree:** Self-balancing BSTs.
  - **Trie, Heap, Segment Tree, etc.**

**Analogy:** Like a family tree or folder structure on your computer.

**Visual:**
```
      [10]
     /    \
   [5]    [20]
  /   \      \
[3]  [7]    [30]
```

## When to Use Trees?
- Hierarchical data (file systems, organization charts)
- Fast search, insert, delete (BST: O(log n) average)
- Priority queues (Heap)

## Pitfalls
- Skewed trees can degrade performance to O(n)
- Balancing is required for optimal performance

## Further Reading
- [Java Tree Data Structures](https://www.geeksforgeeks.org/binary-tree-data-structure/)
- [Binary Search Trees](https://www.geeksforgeeks.org/binary-search-tree-data-structure/)
- [Tree Traversals](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)

## Example: Binary Tree Node
```java
class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) { this.data = data; }
}
```

## Exercise
- Implement a binary search tree (BST) with insert and search methods.
- Write code to traverse a tree (inorder, preorder, postorder).
- Find the height of a binary tree.

---

Continue to 6_Hashing_HashMaps after this.
