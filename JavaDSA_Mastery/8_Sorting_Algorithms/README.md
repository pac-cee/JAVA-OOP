# Sorting Algorithms in Java

## What is Sorting?
- Arranging data in a particular order (ascending/descending).

## Common Sorting Algorithms
- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort

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

## Exercise
- Implement selection sort and quick sort.

Continue to 9_Searching_Algorithms after this.
