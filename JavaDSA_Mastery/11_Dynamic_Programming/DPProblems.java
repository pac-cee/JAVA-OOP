public class DPProblems {
    // Tabulation (Bottom-Up) example: Fibonacci
    public static int fibTab(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
    // Memoization (Top-Down) example: Fibonacci
    public static int fibMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci Tabulation: " + fibTab(n));
        int[] memo = new int[n + 1];
        System.out.println("Fibonacci Memoization: " + fibMemo(n, memo));
    }
}
