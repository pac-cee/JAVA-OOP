# 14. RESTful Web Services & APIs

## Overview
Learn to build and consume REST APIs in Java using Spring Boot.

## Topics
- HTTP basics (methods, status codes, headers)
- Building REST controllers in Spring Boot
- Consuming APIs (RestTemplate, WebClient)
- JSON serialization/deserialization (Jackson/Gson)

## Example: REST Controller
```java
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/greet")
    public String greet() {
        return "Hello from API!";
    }
}
```

## Exercise
- Build a REST API for managing products (CRUD).
- Write a Java client to consume a public REST API and print results.

Continue to 15_Advanced_Topics after this.
