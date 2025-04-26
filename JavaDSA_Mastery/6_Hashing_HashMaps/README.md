# Hashing & HashMaps in Java

Hashing enables fast data lookup and is the foundation for many powerful data structures.

---

## What is Hashing?
- A technique to convert data (like a string or number) into a fixed-size value called a hash code.
- Hash code is used as an index to store/retrieve data in a hash table.

**Analogy:** Like assigning a unique locker number to each student based on their name.

**Visual:**
```
"apple" --[hash function]--> 42
"banana" --[hash function]--> 17
```

## What is a HashMap?
- Stores key-value pairs for fast lookup, insertion, and deletion.
- Average-case O(1) operations.
- Handles collisions (when two keys hash to the same index) using chaining or open addressing.

**Syntax:**
```java
HashMap<String, Integer> map = new HashMap<>();
```

## When to Use HashMaps?
- Fast lookup by key (dictionary, word count, caching)
- Avoiding duplicates (using keys as a set)

## Pitfalls
- Poor hash functions can cause collisions and degrade performance.
- Keys must be immutable and have proper `hashCode()` and `equals()` implementations.
- Not thread-safe (use `ConcurrentHashMap` for concurrency).

## Further Reading
- [Java HashMap (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
- [How HashMap Works in Java (GeeksforGeeks)](https://www.geeksforgeeks.org/how-hashmap-works-in-java/)
- [Hash Functions Explained](https://www.geeksforgeeks.org/hashing-data-structure/)

## Example
```java
import java.util.HashMap;
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 2);
System.out.println(map.get("apple")); // 2
```

## Exercises
- Write a program to count word frequency in a string using HashMap.
- Check if two strings are anagrams using HashMap.
- Find the first non-repeating character in a string.

---

Continue to 7_Graphs after this.
