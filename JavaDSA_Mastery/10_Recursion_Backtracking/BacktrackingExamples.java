public class BacktrackingExamples {
    // N-Queens Problem
    public static boolean solveNQueens(int[][] board, int row) {
        int N = board.length;
        if (row == N) {
            printBoard(board);
            return true;
        }
        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                res = solveNQueens(board, row + 1) || res;
                board[row][col] = 0;
            }
        }
        return res;
    }
    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) if (board[i][col] == 1) return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 1) return false;
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) if (board[i][j] == 1) return false;
        return true;
    }
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
        System.out.println();
    }
    // Subset Sum Problem
    public static boolean subsetSum(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (arr[n-1] > sum) return subsetSum(arr, n-1, sum);
        return subsetSum(arr, n-1, sum) || subsetSum(arr, n-1, sum-arr[n-1]);
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        System.out.println("N-Queens solutions:");
        solveNQueens(board, 0);
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("Subset sum exists: " + subsetSum(arr, arr.length, sum));
    }
}
