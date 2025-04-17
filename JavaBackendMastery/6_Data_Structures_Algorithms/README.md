# 6. Data Structures & Algorithms

## Overview
Master the basics of DSA: arrays, lists, stacks, queues, trees, graphs, sorting, searching, recursion, DP, greedy algorithms.

## Topics
- Arrays, linked lists, stacks, queues, trees, graphs, hash tables
- Sorting and searching
- Recursion, dynamic programming, greedy algorithms

## Example: Binary Search
```java
int[] arr = {1, 3, 5, 7};
int left = 0, right = arr.length - 1, target = 5;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) System.out.println("Found at " + mid);
    if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## Exercise
- Implement a stack using an array.
- Write a recursive function for factorial.

Continue to 7_Functional_Programming after this.
