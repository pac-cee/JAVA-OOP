
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise {

    public class ImprovedExercises {

        // 1. Triangle Type - with validation
        public static class Triangle {
            public enum Type {
                EQUILATERAL, ISOSCELES, SCALENE, INVALID
            }

        }

        public static Type determineType(double side1, double side2, double side3) {
            if (!isValidTriangle(side1, side2, side3)) {
                return Type.INVALID;
            }

            if (side1 == side2 && side2 == side3) {
                return Type.EQUILATERAL;
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                return Type.ISOSCELES;
            }
            return Type.SCALENE;
        }

        private static boolean isValidTriangle(double a, double b, double c) {
            return a > 0 && b > 0 && c > 0 &&
                   a + b > c && b + c > a && a + c > b;
        }
    }

    // 2. Number Properties - using record
    public record NumberProperties(int value) {
        public String describe() {
            return String.format("The number is %s and %s",
                getType(),
                isEven() ? "even" : "odd");
        }

        private String getType() {
            return value > 0 ? "positive" : 
                   value < 0 ? "negative" : "zero";
        }

        private boolean isEven() {
            return value % 2 == 0;
        }
    }

    // 3. Employee Bonus - using enum and record
    public record Employee(double salary, int yearsOfService) {
        public enum BonusRate {
            JUNIOR(0.05, years -> years < 5),
            INTERMEDIATE(0.10, years -> years >= 5 && years <= 10),
            SENIOR(0.15, years -> years > 10);

            private final double rate;
            private final Predicate<Integer> condition;

            BonusRate(double rate, Predicate<Integer> condition) {
                this.rate = rate;
                this.condition = condition;
            }

            static BonusRate forYears(int years) {
                return Arrays.stream(values())
                    .filter(rate -> rate.condition.test(years))
                    .findFirst()
                    .orElse(JUNIOR);
            }
        }

        public double calculateBonus() {
            return salary * BonusRate.forYears(yearsOfService).rate;
        }
    }

    // 4. Password Validator - using builder pattern
    public static class PasswordValidator {
        private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        
        public static class ValidationResult {
            private final boolean isValid;
            private final String message;

            private ValidationResult(boolean isValid, String message) {
                this.isValid = isValid;
                this.message = message;
            }

            public boolean isValid() { return isValid; }
            public String getMessage() { return message; }
        }

        public static ValidationResult validate(String password) {
            if (password == null || password.length() < 8) {
                return new ValidationResult(false, "Password must be at least 8 characters");
            }

            boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
            boolean hasDigit = password.chars().anyMatch(Character::isDigit);
            boolean hasSpecial = password.chars().anyMatch(ch -> SPECIAL_CHARS.indexOf(ch) >= 0);

            if (!hasUpper || !hasDigit || !hasSpecial) {
                return new ValidationResult(false, 
                    "Password must contain uppercase letter, number, and special character");
            }

            return new ValidationResult(true, "Password is valid");
        }
    }

    // 5. Time Greeting - using enum
    public enum TimeGreeting {
        NIGHT("Good Night", hour -> hour >= 0 && hour <= 5),
        MORNING("Good Morning", hour -> hour >= 6 && hour <= 11),
        AFTERNOON("Good Afternoon", hour -> hour >= 12 && hour <= 17),
        EVENING("Good Evening", hour -> hour >= 18 && hour <= 23);

        private final String greeting;
        private final Predicate<Integer> timeRange;

        TimeGreeting(String greeting, Predicate<Integer> timeRange) {
            this.greeting = greeting;
            this.timeRange = timeRange;
        }

        public static String forHour(int hour) {
            return Arrays.stream(values())
                .filter(g -> g.timeRange.test(hour))
                .findFirst()
                .map(g -> g.greeting)
                .orElse("Invalid hour");
        }
    }

    // 6. Palindrome - using streams
    public static class PalindromeChecker {
        public static boolean isPalindrome(int number) {
            String numStr = String.valueOf(Math.abs(number));
            return numStr.equals(new StringBuilder(numStr).reverse().toString());
        }
    }

    // 7. BMI Calculator - using enum and record
    public record BMI(double weight, double height) {
        public enum Category {
            UNDERWEIGHT(bmi -> bmi < 18.5),
            NORMAL(bmi -> bmi >= 18.5 && bmi < 25),
            OVERWEIGHT(bmi -> bmi >= 25 && bmi < 30),
            OBESE(bmi -> bmi >= 30);

            private final Predicate<Double> range;

            Category(Predicate<Double> range) {
                this.range = range;
            }

            static Category fromBMI(double bmi) {
                return Arrays.stream(values())
                    .filter(cat -> cat.range.test(bmi))
                    .findFirst()
                    .orElse(NORMAL);
            }
        }

        public Category calculate() {
            double bmi = weight / (height * height);
            return Category.fromBMI(bmi);
        }
    }

    // 8. Electricity Bill - using record and builder
    public record ElectricityUsage(int units) {
        private static final double RATE_FIRST_SLAB = 0.50;
        private static final double RATE_SECOND_SLAB = 0.75;
        private static final double RATE_THIRD_SLAB = 1.20;

        public double calculateBill() {
            if (units <= 100) {
                return units * RATE_FIRST_SLAB;
            } else if (units <= 300) {
                return (100 * RATE_FIRST_SLAB) + 
                       ((units - 100) * RATE_SECOND_SLAB);
            }
            return (100 * RATE_FIRST_SLAB) + 
                   (200 * RATE_SECOND_SLAB) + 
                   ((units - 300) * RATE_THIRD_SLAB);
        }
    }

    // 9. Loan Eligibility - using record and validation
    public record LoanApplication(double income, int creditScore, int existingLoans) {
        private static final double MIN_INCOME = 30000;
        private static final int MIN_CREDIT_SCORE = 700;
        private static final int MAX_EXISTING_LOANS = 2;

        public Optional<String> checkEligibility() {
            if (income < MIN_INCOME) {
                return Optional.of("Income below minimum requirement");
            }
            if (creditScore < MIN_CREDIT_SCORE) {
                return Optional.of("Credit score too low");
            }
            if (existingLoans >= MAX_EXISTING_LOANS) {
                return Optional.of("Too many existing loans");
            }
            return Optional.empty(); // Eligible
        }
    }

    // 10. Number Game - using modern practices
    public static class NumberGame {
        private final Random random;
        private final Scanner scanner;
        private final int maxNumber;

        public NumberGame(Scanner scanner, int maxNumber) {
            this.random = new Random();
            this.scanner = scanner;
            this.maxNumber = maxNumber;
        }

        public void play() {
            int target = random.nextInt(maxNumber) + 1;
            int attempts = 0;

            System.out.printf("Guess a number between 1 and %d%n", maxNumber);

            while (true) {
                System.out.print("Your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.printf("Correct! You got it in %d attempts%n", attempts);
                    break;
                }
                System.out.println(guess < target ? "Too low!" : "Too high!");
            }
        }
    }

    // 11. Number to Word - using enum
    public enum Digit {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
        FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

        private final int value;

        Digit(int value) {
            this.value = value;
        }

        public static Optional<String> toString(int digit) {
            return Arrays.stream(values())
                .filter(d -> d.value == digit)
                .map(Enum::name)
                .map(String::toLowerCase)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .findFirst();
        }
    }

    // Additional improved methods

    // 25. DateTime - using modern date/time API
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // 26. Name Formatter - using record
    public record Name(String firstName, String lastName) {
        public String format() {
            return String.format("%s, %s", lastName, firstName);
        }
    }

    // 27. Word Reverser - using streams
    public static String reverseWords(String sentence) {
        return Arrays.stream(sentence.split("\\s+"))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    java.util.Collections.reverse(list);
                    return String.join(" ", list);
                }
            ));
    }

    // 28. URL Generator - using builder pattern
    public static class URLGenerator {
        public static String generate(String username) {
            return Optional.ofNullable(username)
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^a-z0-9]", ""))
                .map(s -> String.format("www.%s.com", s))
                .orElse("www.invalid.com");
        }
    }

    // 29. Log Message - using builder pattern
    public static class LogMessage {
        private final LocalDateTime timestamp;
        private final String username;
        private final String action;

        private LogMessage(Builder builder) {
            this.timestamp = builder.timestamp;
            this.username = builder.username;
            this.action = builder.action;
        }

        public static class Builder {
            private LocalDateTime timestamp = LocalDateTime.now();
            private String username;
            private String action;

            public Builder withUsername(String username) {
                this.username = username;
                return this;
            }

            public Builder withAction(String action) {
                this.action = action;
                return this;
            }

            public LogMessage build() {
                return new LogMessage(this);
            }
        }

        @Override
        public String toString() {
            return String.format("[%s] User '%s' performed action: %s",
                formatDateTime(timestamp), username, action);
        }
    }

    // 30. String Encoder - using streams
    public static String encodeString(String input) {
        return input.chars()
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("-"));
    }
}
