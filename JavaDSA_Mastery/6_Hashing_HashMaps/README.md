# Hashing & HashMaps in Java

## What is Hashing?
- Technique to convert data into a fixed-size value (hash code).
- Used in hash tables for fast lookup.

## HashMap
- Stores key-value pairs.
- Syntax: `HashMap<String, Integer> map = new HashMap<>();`

## Example
```java
import java.util.HashMap;
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 2);
System.out.println(map.get("apple")); // 2
```

## Exercise
- Write a program to count word frequency in a string using HashMap.

Continue to 7_Graphs after this.
