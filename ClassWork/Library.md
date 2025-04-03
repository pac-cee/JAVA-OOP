# Advanced Library Management System

## Project Overview

This Java-based Library Management System is a sophisticated demonstration of Object-Oriented Programming (OOP) principles, showcasing advanced software design techniques and Java programming concepts.

## Table of Contents

1. [Project Structure](#project-structure)
2. [OOP Principles Demonstrated](#oop-principles-demonstrated)
3. [Class Breakdown](#class-breakdown)
4. [Key Features](#key-features)
5. [Design Patterns and Advanced Concepts](#design-patterns-and-advanced-concepts)
6. [How to Run](#how-to-run)
7. [Usage Instructions](#usage-instructions)

## Project Structure

The project is organized into several key classes that interact to create a comprehensive library management system:

- `LibraryResource` (Abstract Base Class)
- `Book` (Concrete Resource)
- `AcademicJournal` (Concrete Resource)
- `LibraryUser`
- `Loan`
- `LibraryManagementSystem` (Main Application)

## OOP Principles Demonstrated

### 1. Abstraction

The `LibraryResource` abstract class provides a blueprint for library resources:

```java
abstract class LibraryResource {
    // Common attributes and abstract methods
    public abstract void displayDetails();
    public abstract double calculateReplacement();
}
```

- Defines a common interface for different types of resources
- Forces child classes to implement specific behaviors

### 2. Inheritance

`Book` and `AcademicJournal` inherit from `LibraryResource`:

```java
class Book extends LibraryResource {
    // Inherits core functionality
    // Implements specific methods
}
```

- Reuses common code from the parent class
- Provides type-specific implementations

### 3. Polymorphism

Methods like `displayDetails()` and `calculateReplacement()` behave differently for each resource type:

```java
// Different implementations for Book and AcademicJournal
@Override
public void displayDetails() {
    // Unique implementation for each resource type
}
```

### 4. Encapsulation

Private fields with controlled access:

```java
private String uniqueId;
private String title;

// Controlled access through getters
public String getUniqueId() { return uniqueId; }
```

## Class Breakdown

### LibraryResource (Abstract Base Class)

- Represents a generic library resource
- Contains core attributes like `uniqueId`, `title`, `availableCopies`
- Defines abstract methods for resource-specific behaviors

### Book Class

- Extends `LibraryResource`
- Additional attributes: `author`, `publishedYear`, `genre`
- Uses an enum for `Genre` classification
- Implements complex replacement cost calculation

### AcademicJournal Class

- Another extension of `LibraryResource`
- Contains `publisher`, `issn`, `researchField`
- Uses an enum for `ResearchField`
- Provides unique implementation of resource methods

### LibraryUser Class

- Manages user information and loan capabilities
- Implements borrowing restrictions
- Tracks active loans

### Loan Class

- Represents a book loan with advanced tracking
- Calculates loan duration and overdue status
- Uses `LocalDate` for precise date management

## Key Features

1. **Resource Management**

   - Add new books and academic journals
   - List and search resources
   - Track available copies
2. **User Management**

   - Create and manage library users
   - Enforce borrowing limits
   - Track user loans
3. **Advanced Loan Tracking**

   - Overdue detection
   - Loan period management
   - Complex replacement cost calculations

## Design Patterns and Advanced Concepts

### Enum Usage

```java
public enum Genre {
    FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY
}
```

- Type-safe categorization
- Prevents invalid genre assignments

### Stream API

```java
public boolean canBorrow() {
    return activeLoans.size() < MAX_LOANS && 
           activeLoans.stream().noneMatch(Loan::isOverdue);
}
```

- Functional programming approaches
- Concise collection processing

### Exception Handling

```java
public void addLoan(Loan loan) {
    if (canBorrow()) {
        activeLoans.add(loan);
    } else {
        throw new IllegalStateException("Cannot borrow more resources");
    }
}
```

- Robust error management
- Prevents invalid system states

## How to Run

1. Ensure you have Java JDK 11 or higher installed
2. Compile the project:
   ```
   javac LibraryManagementSystem.java
   ```
3. Run the application:
   ```
   java LibraryManagementSystem
   ```

## Usage Instructions

1. Main Menu Options:

   - Manage Resources
   - Manage Users
   - Loan Management
   - Exit
2. Resource Management:

   - Add new books or journals
   - List existing resources
   - Search resources by title

## Potential Improvements

1. Persistent storage (database integration)
2. More advanced search functionality
3. User authentication
4. Advanced reporting features

## Learning Objectives

This project demonstrates:

- Advanced Java OOP concepts
- Software design principles
- Complex system interaction
- User interface design
- Error handling and validation

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

[Your License Here - e.g., MIT License]

---

**Note**: This is an educational project designed to showcase Object-Oriented Programming principles in Java.
