# 17. Security Basics

## Overview
Understand the foundations of backend security in Java applications.

## Topics
- Password hashing
- Authentication & authorization
- JWT (JSON Web Tokens)
- Securing REST APIs

## Example: BCrypt Password Hashing
```java
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
String hashed = encoder.encode("password123");
System.out.println(hashed);
```

## Exercise
- Secure a REST API endpoint in Spring Boot.
- Implement JWT authentication for a simple app.

Continue to 18_Project_Practice after this.
