// Demonstrates JPA entity mapping (requires JPA/Spring Data JPA setup)
import javax.persistence.*;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    // Getters and setters omitted for brevity
}
