public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int key) {
        int n = arr.length;
        if (arr[0] == key) return 0;
        int i = 1;
        while (i < n && arr[i] <= key) i *= 2;
        return binarySearch(arr, i / 2, Math.min(i, n - 1), key);
    }
    private static int binarySearch(int[] arr, int l, int r, int key) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) return m;
            if (arr[m] < key) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 44, 55, 60};
        int key = 44;
        int idx = exponentialSearch(arr, key);
        System.out.println("Index of " + key + ": " + idx);
    }
}
