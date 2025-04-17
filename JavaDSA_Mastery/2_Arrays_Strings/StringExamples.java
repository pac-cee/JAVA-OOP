public class StringExamples {
    public static void main(String[] args) {
        // Reverse a string
        String s = "hello";
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        System.out.println("Reversed: " + reversed); // Output: olleh
    }
}
