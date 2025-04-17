# 4. Collections and Generics

## Overview
Learn about Java's built-in data structures (collections) and how to use generics for type safety.

## Topics
- List, Set, Map, Queue
- ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, PriorityQueue
- Generics and type safety
- Iterators and enhanced for-loop

## Example: Generics
```java
List<Integer> numbers = new ArrayList<>();
numbers.add(10);
for (int n : numbers) System.out.println(n);
```

## Exercise
- Create a generic class `Box<T>` that can hold any type of object.
- Write a program that uses a `Map` to count word frequencies in a sentence.

Continue to 5_Exception_Handling after this.
