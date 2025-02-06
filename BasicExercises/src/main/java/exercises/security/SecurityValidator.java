package exercises.security;

public class SecurityValidator {
    public static boolean isPasswordValid(String password) {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        
        if (password.length() < 8) return false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
        }
        
        return hasUpperCase && hasNumber && hasSpecial;
    }

    public static String identifyOS(String osName) {
        osName = osName.toLowerCase();
        if (osName.contains("windows")) return "Windows";
        if (osName.contains("mac") || osName.contains("darwin")) return "macOS";
        if (osName.contains("linux") || osName.contains("unix")) return "Linux";
        return "Unknown OS";
    }
}
