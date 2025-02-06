package exercises.security;

public class SecurityValidator {
    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasNumber = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (specialChars.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasNumber && hasUpper && hasLower && hasSpecial;
    }

    public static String identifyOS(String osName) {
        osName = osName.toLowerCase();
        if (osName.contains("win")) {
            return "Windows";
        } else if (osName.contains("mac")) {
            return "macOS";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return "Linux/Unix";
        } else {
            return "Unknown OS";
        }
    }
}
