public class ArrayOperations {
    // Insert an element at a given position
    public static int[] insert(int[] arr, int pos, int value) {
        int[] result = new int[arr.length + 1];
        for (int i = 0, j = 0; i < result.length; i++) {
            if (i == pos) {
                result[i] = value;
            } else {
                result[i] = arr[j++];
            }
        }
        return result;
    }

    // Delete an element at a given position
    public static int[] delete(int[] arr, int pos) {
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != pos) {
                result[j++] = arr[i];
            }
        }
        return result;
    }

    // Search for an element
    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    // Update an element at a given position
    public static void update(int[] arr, int pos, int value) {
        if (pos >= 0 && pos < arr.length) {
            arr[pos] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = insert(arr, 2, 99);
        arr = delete(arr, 4);
        int idx = search(arr, 99);
        update(arr, 1, 77);
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\nIndex of 99: " + idx);
    }
}
