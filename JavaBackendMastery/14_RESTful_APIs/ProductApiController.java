// Minimal Spring Boot REST API for products
// Requires Spring Boot dependencies in your Maven/Gradle project
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/products")
public class ProductApiController {
    // In-memory product store
    private final List<String> products = new ArrayList<>(Arrays.asList("Laptop", "Phone"));

    @GetMapping
    public List<String> getAll() {
        return products;
    }
    @PostMapping
    public void add(@RequestBody String name) {
        products.add(name);
    }
    @DeleteMapping("/{name}")
    public void remove(@PathVariable String name) {
        products.remove(name);
    }
}
