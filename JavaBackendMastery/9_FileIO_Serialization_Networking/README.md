# 9. File I/O, Serialization, and Networking

## Overview
Work with files, serialize objects, and communicate over networks in Java.

## Topics
- Reading/writing files
- Object serialization
- Sockets and basic networking

## Example: File I/O
```java
import java.nio.file.*;
String content = Files.readString(Path.of("test.txt"));
System.out.println(content);
```

## Exercise
- Write a program that writes user input to a file.
- Create a simple client-server socket program.

Continue to 10_Unit_Testing after this.
