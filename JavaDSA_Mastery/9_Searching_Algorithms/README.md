# Searching Algorithms in Java

Searching is the process of finding a specific element within a data structure.

---

## What is Searching?
- Locating the position of a target value within an array, list, or other structure.

**Analogy:** Like looking for a friend's name in a phone book.

**Visual:**
```
Array: [2, 4, 6, 8]
Find: 6
Result: Found at index 2
```

## Common Searching Algorithms
- **Linear Search:** Check each element one by one (O(n))
- **Binary Search:** Repeatedly divide sorted array in half (O(log n))

## When to Use Which?
- Use linear search for small or unsorted data.
- Use binary search for large, sorted data.

## Pitfalls
- Using binary search on unsorted data (will fail!)
- Off-by-one errors in binary search implementation

## Further Reading
- [Linear Search (GeeksforGeeks)](https://www.geeksforgeeks.org/linear-search/)
- [Binary Search (GeeksforGeeks)](https://www.geeksforgeeks.org/binary-search/)
- [Java Arrays.binarySearch()](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#binarySearch-int:A-int-)

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

## Exercises
- Implement binary search (iterative and recursive).
- Given a rotated sorted array, search for a target value.
- Find the first and last occurrence of a number in a sorted array.
- Use Java's built-in `Arrays.binarySearch()` method.

---

Continue to 10_Recursion_Backtracking after this.
