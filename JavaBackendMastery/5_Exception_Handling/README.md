# 5. Exception Handling

## Overview
Handle errors in Java using exceptions: try-catch, throw, throws, and custom exceptions.

## Topics
- Try-catch-finally
- Throw and throws
- Checked vs unchecked exceptions
- Custom exceptions

## Example: Try-Catch
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## Exercise
- Write a program that reads a number and throws an exception if it is negative.
- Create your own custom exception and use it in a program.

Continue to 6_Data_Structures_Algorithms after this.
