# 7. Java Functional Programming (Java 8+)

## Overview
Covers functional programming features in Java: lambdas, streams, method references, and Optionals.

## Topics
- Lambda expressions
- Functional interfaces (Predicate, Function, etc.)
- Streams API
- Method references
- Optional class

## Example: Lambda & Streams
```java
List<Integer> nums = Arrays.asList(1,2,3,4);
nums.stream().filter(n -> n%2==0).forEach(System.out::println); // 2 4
```

## Exercise
- Write a lambda that squares a number.
- Use a stream to sum all even numbers in a list.

Continue to 8_Multithreading_Concurrency after this.
