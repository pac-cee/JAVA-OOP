# Dynamic Programming in Java

## What is Dynamic Programming (DP)?
- Solving complex problems by breaking them into simpler subproblems and storing results.
- Used for optimization problems (e.g., shortest path, knapsack).

## Example: Fibonacci with DP
```java
int fib(int n) {
    int[] dp = new int[n+1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++)
        dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}
```

## Exercise
- Implement the coin change problem using DP.

Continue to 12_Greedy_Algorithms after this.
