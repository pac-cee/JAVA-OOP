# Linked Lists in Java

Linked Lists are dynamic data structures that allow efficient insertion and deletion of elements.

---

## What is a Linked List?
- A linear data structure where each element (node) contains data and a reference (pointer) to the next node.
- Types:
  - **Singly Linked List:** Each node points to the next.
  - **Doubly Linked List:** Each node points to both next and previous.
  - **Circular Linked List:** Last node points back to the first node.

**Analogy:** Like a treasure hunt where each clue tells you where to find the next clue!

**Visual:**
```
[10] -> [20] -> [30] -> null
```

## When to Use Linked Lists?
- When you need fast insertions/deletions (O(1) at head/tail)
- When array resizing is expensive

## Pitfalls
- No random access (O(n) to find an element)
- Extra memory for pointers

## Example: Singly Linked List Node
```java
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}
```

## Further Reading
- [Java LinkedList (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
- [Singly vs Doubly Linked List](https://www.geeksforgeeks.org/difference-between-singly-and-doubly-linked-list/)

## Exercise
- Implement a singly linked list with methods to add, remove, and print elements.
- Write a function to reverse a linked list.

---

Continue to 4_Stacks_Queues after this.
