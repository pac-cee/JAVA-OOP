public class BinarySearch {
    // Iterative
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    // Recursive
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearchRecursive(arr, mid + 1, right, target);
        else return binarySearchRecursive(arr, left, mid - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        System.out.println(binarySearchIterative(arr, 8)); // 3
        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 10)); // 4
    }
}
