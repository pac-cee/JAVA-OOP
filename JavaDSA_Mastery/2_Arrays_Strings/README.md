# Arrays & Strings in Java

Arrays and Strings are fundamental data structures in Java. Mastering them is key for most DSA problems!

---

## What is an Array?
- Fixed-size container for elements of the same type.
- Elements are stored in contiguous memory locations.

**Analogy:** Like a row of mailboxes, each with a unique number (index).

**Visual:**
```
Index: 0 1 2 3 4
Array: [7 3 5 1 2]
```

## Common Array Operations
- Access: `arr[i]` (O(1))
- Update: `arr[i] = x` (O(1))
- Search: Linear (O(n)), Binary (O(log n) if sorted)
- Insert/Delete: O(n) (need to shift elements)

## What is a String?
- Sequence of characters.
- Immutable in Java (cannot be changed after creation).

**Analogy:** Like a necklace made of letter beads.

## Common String Operations
- Concatenation: `str1 + str2`
- Substring: `str.substring(start, end)`
- Comparison: `str1.equals(str2)`

## Real-World Examples
- Contact list (array of names)
- DNA sequence (string of A/C/G/T)
- Game board (2D array)

## Pitfalls
- Array index out of bounds
- Modifying strings in a loop (creates new objects)

## Further Reading
- [Java Arrays (Oracle)](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Java Strings (Oracle)](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
- [Array vs ArrayList](https://www.geeksforgeeks.org/difference-between-array-and-arraylist-in-java/)

## Example: Array
```java
int[] numbers = {1, 2, 3, 4, 5};
System.out.println(numbers[0]); // 1
```

## Example: String
```java
String name = "Alice";
System.out.println(name.length()); // 5
```

## Exercise
- Write a program to reverse a string.
- Write a program to find the maximum value in an integer array.
- Given a string, count the number of vowels.

---

Continue to 3_Linked_Lists after this.
