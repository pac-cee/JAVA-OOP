public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4};
        selectionSort(arr);
        for (int n : arr) System.out.print(n + " "); // Output: 3 4 5 8
    }
}
