public class MultiDimensionalArrays {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // Print matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // Sum of diagonal
        int diagSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagSum += matrix[i][i];
        }
        System.out.println("Diagonal sum: " + diagSum);
    }
}
