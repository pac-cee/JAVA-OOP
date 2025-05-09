import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = promptUntilValid(sc, "Enter name: ", input -> {
            ValidationUtils.requireName(input, "Name");
        });

        int age = Integer.parseInt(promptUntilValid(sc, "Enter age: ", input -> {
            int parsedAge;
            try {
                parsedAge = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Age must be a valid integer");
            }
            ValidationUtils.requireInRange(parsedAge, 0, 150, "Age");
        }));

        String email = promptUntilValid(sc, "Enter email: ", input -> {
            ValidationUtils.requireEmail(input, "Email");
        });

        String phone = promptUntilValid(sc, "Enter phone: ", input -> {
            ValidationUtils.requirePhone(input, "Phone");
        });

        System.out.println("All inputs valid!\nName: " + name + ", Age: " + age + ", Email: " + email + ", Phone: " + phone);

        sc.close();
    }

    interface Validator {
        void validate(String input) throws IllegalArgumentException;
    }

    private static String promptUntilValid(Scanner sc, String prompt, Validator validator) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                validator.validate(input);
                return input;
            } catch (IllegalArgumentException ex) {
                System.err.println("Invalid input: " + ex.getMessage());
            }
        }
    }
}

