# Searching Algorithms in Java

## What is Searching?
- Finding an element in a data structure.

## Common Searching Algorithms
- Linear Search
- Binary Search

## Example: Linear Search
```java
int[] arr = {2, 4, 6, 8};
int target = 6;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        System.out.println("Found at index: " + i);
        break;
    }
}
```

## Exercise
- Implement binary search (iterative and recursive).

Continue to 10_Recursion_Backtracking after this.
