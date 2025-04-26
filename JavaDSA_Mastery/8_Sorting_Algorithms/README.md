# Sorting Algorithms in Java

Sorting is a fundamental concept in computer science, used to organize data for easier searching and analysis.

---

## What is Sorting?
- Arranging data in a particular order (usually ascending or descending).

**Analogy:** Like arranging books on a shelf by title or author.

**Visual:**
```
Unsorted: [5, 3, 8, 4]
Sorted:   [3, 4, 5, 8]
```

## Why Sort?
- Faster searching (binary search requires sorted data)
- Data presentation (leaderboards, reports)

## Common Sorting Algorithms
- **Bubble Sort:** Repeatedly swaps adjacent elements if out of order (simple, slow)
- **Selection Sort:** Selects minimum and swaps to front
- **Insertion Sort:** Builds sorted array one element at a time
- **Merge Sort:** Divide and conquer, O(n log n), stable
- **Quick Sort:** Partition-based, O(n log n) average, fast in practice

## When to Use Which?
- Small datasets: Insertion, Bubble (for simplicity)
- Large datasets: Merge, Quick (for efficiency)

## Pitfalls
- Using inefficient sorts for large data (Bubble/Selection = O(n^2))
- Forgetting to handle duplicate values

## Further Reading
- [Sorting Algorithms (GeeksforGeeks)](https://www.geeksforgeeks.org/sorting-algorithms/)
- [Java Arrays.sort()](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-java.lang.Object:A-)
- [Stable vs Unstable Sorting](https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/)

## Example: Bubble Sort
```java
int[] arr = {5, 3, 8, 4};
for (int i = 0; i < arr.length-1; i++) {
    for (int j = 0; j < arr.length-1-i; j++) {
        if (arr[j] > arr[j+1]) {
            int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
        }
    }
}
```

## Exercises
- Implement selection sort and quick sort.
- Implement merge sort for an integer array.
- Sort an array of objects by a custom field (e.g., Student by grade).
- Explore built-in Java sorting with `Arrays.sort()` and `Collections.sort()`.

---

Continue to 9_Searching_Algorithms after this.
