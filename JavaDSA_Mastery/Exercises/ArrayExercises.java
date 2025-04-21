public class ArrayExercises {
    // Find the maximum element in an array
    public static int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) if (arr[i] > max) max = arr[i];
        return max;
    }
    // Reverse an array
    public static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l]; arr[l] = arr[r]; arr[r] = temp;
            l++; r--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};
        System.out.println("Max element: " + maxElement(arr));
        reverse(arr);
        System.out.print("Reversed: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
