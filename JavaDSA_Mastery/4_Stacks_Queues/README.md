# Stacks & Queues in Java

## Stack
- LIFO (Last In First Out) structure.
- Methods: push, pop, peek
- Example: Undo feature in editors

## Queue
- FIFO (First In First Out) structure.
- Methods: enqueue, dequeue, front
- Example: Print queue

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

Continue to 5_Trees after this.
