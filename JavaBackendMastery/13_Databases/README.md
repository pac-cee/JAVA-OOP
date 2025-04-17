# 13. Databases

## Overview
Work with relational databases in Java: SQL basics, JDBC, and ORM (Hibernate/JPA).

## Topics
- SQL basics (CRUD, joins, transactions)
- JDBC for database connectivity
- ORM concepts (Hibernate/JPA)
- Connecting Java to MySQL/PostgreSQL

## Example: JDBC Connection
```java
import java.sql.*;
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mydb", "user", "password");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM students");
```

## Exercise
- Write a Java program to insert and retrieve data from a database using JDBC.
- Use JPA annotations to map a Java class to a database table.

Continue to 14_RESTful_APIs after this.
