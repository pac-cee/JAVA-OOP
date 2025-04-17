// Expanded Spring Boot REST API for products with CRUD, validation, and comments
// Requires Spring Boot dependencies in your Maven/Gradle project
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;
@RestController
@RequestMapping("/api/products")
public class ProductApiController {
    // In-memory product store
    private final List<String> products = new ArrayList<>(Arrays.asList("Laptop", "Phone"));

    // GET all products
    @GetMapping
    public List<String> getAll() {
        return products;
    }

    // GET a product by index
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        if (id < 0 || id >= products.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.ok(products.get(id));
    }

    // POST a new product
    @PostMapping
    public ResponseEntity<String> add(@RequestBody String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Product name cannot be empty");
        }
        products.add(name);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added");
    }

    // PUT update product by index
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody String name) {
        if (id < 0 || id >= products.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Product name cannot be empty");
        }
        products.set(id, name);
        return ResponseEntity.ok("Product updated");
    }

    // DELETE a product by index
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable int id) {
        if (id < 0 || id >= products.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        products.remove(id);
        return ResponseEntity.ok("Product deleted");
    }
}
