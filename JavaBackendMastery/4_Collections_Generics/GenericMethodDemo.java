public class GenericMethodDemo {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};

        System.out.print("Integer Array: ");
        printArray(intArray);
        System.out.print("String Array: ");
        printArray(strArray);
    }
}
