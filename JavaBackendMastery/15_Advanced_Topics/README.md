# 15. Advanced Topics

## Overview
Deepen your backend skills with advanced Java topics for robust, maintainable applications.

## Topics
- Exception handling in web apps (ControllerAdvice)
- Validation (Hibernate Validator/JSR-380)
- Logging (SLF4J, Logback, Log4j)
- Configuration management (application.properties/yaml)
- Environment profiles

## Example: Global Exception Handler
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex) {
        return ResponseEntity.status(500).body("Error: " + ex.getMessage());
    }
}
```

## Exercise
- Add validation to a Spring Boot REST API.
- Configure logging using Logback.

Continue to 16_Deployment_DevOps after this.
