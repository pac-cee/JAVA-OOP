# Encapsulation in Object-Oriented Programming

Encapsulation is one of the fundamental principles of OOP that bundles data and the methods that operate on that data within a single unit or object, restricting direct access to some of an object's components.

## Key Concepts

### 1. Data Hiding
- Private fields to hide internal state
- Public methods to access and modify state
- Protection from unauthorized access

### 2. Access Modifiers
- `private`: Accessible only within the class
- `protected`: Accessible within the package and by subclasses
- `public`: Accessible from anywhere
- Default (package-private): Accessible within the package

### 3. Immutability
- Creating objects whose state cannot be changed after construction
- Thread safety and security benefits
- Examples in Java: String, Integer, LocalDate

## Examples in This Package

1. `BankAccount.java`
   - Basic encapsulation with private fields and public methods
   - Validation in setters
   - Immutable account number

2. `ImmutablePerson.java`
   - Complete immutability example
   - Deep copy in constructor
   - Defensive copying in getters

3. `Student.java`
   - Different access modifiers
   - Method encapsulation
   - Validation logic

## Best Practices

1. Always make fields private unless there's a good reason not to
2. Provide getters and setters only when necessary
3. Validate data in setters
4. Use immutable objects when possible
5. Implement defensive copying for mutable object references

## Common Pitfalls

1. ❌ Public fields
2. ❌ Returning references to mutable objects
3. ❌ Not validating input in setters
4. ❌ Breaking encapsulation with getters/setters without proper thought

## Exercises

1. Create a `Library` class that encapsulates a collection of books
2. Implement an immutable `Money` class
3. Design a `UserProfile` class with proper validation

## Real-World Applications

1. Financial systems (BankAccount)
2. User management systems (UserProfile)
3. Configuration objects (Settings)
4. Value objects (Money, Point) 