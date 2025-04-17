// Minimal Spring Boot REST controller
// To run this, you need Spring Boot dependencies in your Maven/Gradle project
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootHelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloController.class, args);
    }
}
