// Demonstrates password hashing with BCrypt (Spring Security)
// Requires org.springframework.security:spring-security-crypto dependency
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCryptDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "mySecret123";
        String hashed = encoder.encode(rawPassword);
        System.out.println("Hashed password: " + hashed);
        // Verify
        boolean matches = encoder.matches("mySecret123", hashed);
        System.out.println("Password matches: " + matches);
    }
}
