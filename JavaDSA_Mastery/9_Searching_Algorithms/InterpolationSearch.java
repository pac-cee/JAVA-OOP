public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) return low;
                return -1;
            }
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == key) return pos;
            if (arr[pos] < key) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int key = 18;
        int idx = interpolationSearch(arr, key);
        System.out.println("Index of " + key + ": " + idx);
    }
}
