# Recursion & Backtracking in Java

## Recursion
- Method calls itself to solve smaller instances of a problem.
- Example: Factorial, Fibonacci

## Backtracking
- Trying out all possibilities and undoing (backtracking) if needed.
- Example: Maze solving, N-Queens

## Example: Factorial
```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

## Exercise
- Write a recursive function to compute Fibonacci numbers.
- Solve the N-Queens problem using backtracking.

Continue to 11_Dynamic_Programming after this.
