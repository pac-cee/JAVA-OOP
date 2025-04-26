# Java DSA Syntax Cheat Sheet

## Arrays
```java
int[] arr = new int[5];
int[] nums = {1, 2, 3};
```

## ArrayList
```java
import java.util.ArrayList;
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.get(0);
```

## LinkedList
```java
import java.util.LinkedList;
LinkedList<String> ll = new LinkedList<>();
ll.add("A");
ll.removeFirst();
```

## Stack
```java
import java.util.Stack;
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.pop();
```

## Queue
```java
import java.util.Queue;
import java.util.LinkedList;
Queue<Integer> queue = new LinkedList<>();
queue.offer(5);
queue.poll();
```

## HashMap
```java
import java.util.HashMap;
HashMap<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.get("a");
```

## For-each Loop
```java
for (int num : arr) {
    System.out.println(num);
}
```

## Enhanced for ArrayList
```java
for (int val : list) {
    System.out.println(val);
}
```

---
Expand with more as you learn!
