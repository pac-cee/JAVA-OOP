# Java Exceptions & Error Handling

## What are Exceptions?
Exceptions are events that disrupt the normal flow of a program. Java uses exceptions to handle errors gracefully.

## Types of Exceptions
- **Checked** (IOException, SQLException)
- **Unchecked** (NullPointerException, ArithmeticException)
- **Errors** (OutOfMemoryError)

## Try-Catch Example
```java
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
```

## Custom Exceptions
```java
class MyException extends Exception {
    MyException(String msg) { super(msg); }
}
```

## Exercise
- Write a program that reads an integer from the user and throws an exception if the input is negative.
- Create your own custom exception and use it in a program.

See example files for more!
