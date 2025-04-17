# 12. Java Backend Frameworks

## Overview
Learn how to build backend applications using the Spring Framework and Spring Boot.

## Topics
- Spring Core, Spring Boot
- Dependency Injection (DI), Inversion of Control (IoC)
- Creating REST APIs with Spring MVC
- Data access with Spring Data JPA/Hibernate
- Spring Security basics

## Example: Spring Boot REST Controller
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

## Exercise
- Create a Spring Boot project with a REST endpoint.
- Connect your app to a database using Spring Data JPA.

Continue to 13_Databases after this.
