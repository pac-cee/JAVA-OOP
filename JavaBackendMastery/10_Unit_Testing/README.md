# 10. Unit Testing

## Overview
Learn how to write and run unit tests for Java code using JUnit and Mockito.

## Topics
- JUnit basics (annotations, assertions)
- Mockito for mocking
- Test-driven development (TDD) concepts

## Example: JUnit Test
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MathTest {
    @Test
    void testSum() {
        assertEquals(5, 2 + 3);
    }
}
```

## Exercise
- Write a JUnit test for a method that reverses a string.
- Mock a dependency using Mockito.

Continue to 11_Build_Tools after this.
