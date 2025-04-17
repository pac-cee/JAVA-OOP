public class ArrayExamples {
    public static void main(String[] args) {
        // Find max in array
        int[] arr = {3, 7, 2, 9, 4};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Max value: " + max); // Output: 9
    }
}
