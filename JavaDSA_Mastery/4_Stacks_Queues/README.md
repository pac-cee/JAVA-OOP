# Stacks & Queues in Java

Stacks and Queues are fundamental linear data structures with different access patterns.

---

## Stack
- **LIFO** (Last In, First Out): The last element added is the first to be removed.
- Methods: `push`, `pop`, `peek`
- **Real-World Analogy:** Stack of plates in a cafeteria.
- **Visual:**
```
Bottom [ 1 | 2 | 3 | 4 ] Top
```
- **Use Cases:** Undo feature in editors, backtracking, function call stack

## Queue
- **FIFO** (First In, First Out): The first element added is the first to be removed.
- Methods: `enqueue`, `dequeue`, `front`
- **Real-World Analogy:** People in a queue at a ticket counter.
- **Visual:**
```
Front [ 1 | 2 | 3 | 4 ] Rear
```
- **Use Cases:** Print queue, task scheduling, breadth-first search

## Pitfalls
- Stack overflow (pushing too many elements)
- Queue underflow (removing from empty queue)

## Further Reading
- [Java Stack (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)
- [Java Queue (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
- [Stack vs Queue](https://www.geeksforgeeks.org/difference-between-stack-and-queue-data-structures/)

## Example: Stack
```java
import java.util.Stack;
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.pop();
```

## Example: Queue
```java
import java.util.LinkedList;
import java.util.Queue;
Queue<Integer> queue = new LinkedList<>();
queue.add(5);
queue.remove();
```

## Exercise
- Implement a stack using an array.
- Implement a queue using a linked list.
- Design a browser history (back/forward) using two stacks.

---

Continue to 5_Trees after this.
