// Demonstrates validation in Spring Boot using Hibernate Validator
// Requires Spring Boot and validation dependencies
import javax.validation.constraints.*;
public class UserDTO {
    @NotBlank
    private String name;
    @Min(18)
    private int age;
    // Getters and setters omitted for brevity
}
