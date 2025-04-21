public class SortingExercises {
    // Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) return false;
        }
        return true;
    }
    // Find kth smallest element (simple selection)
    public static int kthSmallest(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
        }
        return arr[k-1];
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println("Is sorted: " + isSorted(arr));
        System.out.println("3rd smallest: " + kthSmallest(arr, 3));
    }
}
