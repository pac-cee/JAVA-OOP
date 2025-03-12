# Polymorphism in Object-Oriented Programming

Polymorphism allows objects of different types to be treated as objects of a common base type. It enables you to perform a single action in different ways and lets you invoke methods of derived classes through base class references.

## Key Concepts

### 1. Types of Polymorphism
- **Compile-time Polymorphism (Static Binding)**
  - Method overloading
  - Operator overloading (not in Java)
  - Resolved during compilation

- **Runtime Polymorphism (Dynamic Binding)**
  - Method overriding
  - Virtual methods
  - Resolved during execution

### 2. Method Overloading
- Same method name, different parameters
- Can vary in:
  - Number of parameters
  - Types of parameters
  - Order of parameters
- Return type alone is not sufficient

### 3. Method Overriding
- Same method signature in parent and child
- Covariant return types
- Access modifiers
- `@Override` annotation
- Virtual method invocation

## Examples in This Package

1. `Calculator` Example (Compile-time Polymorphism)
   - Method overloading
   - Different parameter types
   - Type promotion
   - Optional parameters

2. `MediaPlayer` Hierarchy (Runtime Polymorphism)
   - Base `MediaPlayer` class
   - Specialized players: `AudioPlayer`, `VideoPlayer`, `StreamingPlayer`
   - Method overriding
   - Dynamic dispatch

3. `PaymentProcessor` Example (Interface Polymorphism)
   - `PaymentProcessor` interface
   - Multiple implementations
   - Strategy pattern
   - Plugin architecture

## Best Practices

1. Use meaningful method names that reflect the action
2. Keep overloaded methods consistent in behavior
3. Use `@Override` annotation for all overridden methods
4. Program to interfaces, not implementations
5. Follow Liskov Substitution Principle
6. Use polymorphism to eliminate conditional logic

## Common Pitfalls

1. ❌ Overloading with ambiguous parameter types
2. ❌ Breaking inherited method contracts
3. ❌ Hiding instance methods with static methods
4. ❌ Overuse of instanceof checks
5. ❌ Type checking instead of polymorphism

## Exercises

1. Create a `NotificationService` with multiple message types
2. Implement a `ShapeRenderer` for different output formats
3. Design a `FileProcessor` hierarchy for different file types

## Real-World Applications

1. Collections Framework (List, Set, Map implementations)
2. Event Handling (Event listeners and handlers)
3. Plugin Systems (Loading different implementations)
4. UI Components (Different widget types)
5. Database Drivers (Different database implementations) 