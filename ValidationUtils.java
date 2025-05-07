public final class ValidationUtils {
    private ValidationUtils() {}

    public static void requireNonNull(Object o, String paramName) {
        if (o == null) {
            throw new IllegalArgumentException(paramName + " must not be null");
        }
    }

    public static void requireNonEmpty(String s, String paramName) {
        requireNonNull(s, paramName);
        if (s.trim().isEmpty()) {
            throw new IllegalArgumentException(paramName + " must not be empty");
        }
    }

    public static void requireInRange(int value, int min, int max, String paramName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                String.format("%s must be between %d and %d (was %d)", paramName, min, max, value));
        }
    }

    public static void requireMatch(String s, String regex, String paramName) {
        requireNonNull(s, paramName);
        if (!s.matches(regex)) {
            throw new IllegalArgumentException(paramName + " has invalid format");
        }
    }

    private static final String NAME_REGEX = "^[A-Za-z\\s'-]{1,50}$";
    public static void requireName(String name, String paramName) {
        requireMatch(name, NAME_REGEX, paramName);
    }

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static void requireEmail(String email, String paramName) {
        requireMatch(email.toUpperCase(), EMAIL_REGEX, paramName);
    }

    private static final String PHONE_REGEX = "^\\+?[0-9\\-\\s]{7,20}$";
    public static void requirePhone(String phone, String paramName) {
        requireMatch(phone, PHONE_REGEX, paramName);
    }
}
