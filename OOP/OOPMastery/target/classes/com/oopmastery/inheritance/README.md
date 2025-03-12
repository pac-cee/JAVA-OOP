# Inheritance in Object-Oriented Programming

Inheritance is a mechanism that allows a class to inherit properties and methods from another class. It supports code reuse and establishes a relationship between parent and child classes.

## Key Concepts

### 1. Types of Inheritance
- Single Inheritance (Java)
- Multiple Inheritance (through interfaces)
- Multilevel Inheritance
- Hierarchical Inheritance

### 2. Important Keywords
- `extends`: Used to inherit from a class
- `super`: Used to call parent class methods/constructors
- `final`: Prevents inheritance
- `abstract`: Creates abstract classes that can't be instantiated
- `@Override`: Indicates method overriding

### 3. Access Modifiers in Inheritance
- `public`: Accessible everywhere
- `protected`: Accessible in same package and subclasses
- `private`: Not inherited
- Default (package-private): Accessible only in same package

## Examples in This Package

1. `Shape` Hierarchy
   - Abstract `Shape` class
   - Concrete shapes: `Circle`, `Rectangle`, `Triangle`
   - Method overriding
   - Constructor chaining
   - Abstract methods

2. `Employee` Hierarchy
   - Base `Employee` class
   - Specialized types: `Manager`, `Developer`, `Intern`
   - Inheritance of fields and methods
   - Super keyword usage
   - Protected members

3. `Vehicle` Hierarchy with Interfaces
   - Abstract `Vehicle` class
   - `ElectricVehicle` and `FuelVehicle` classes
   - Multiple inheritance through interfaces
   - Default methods in interfaces

## Best Practices

1. Use inheritance only for "is-a" relationships
2. Favor composition over inheritance when possible
3. Keep inheritance hierarchies shallow
4. Design for inheritance or prohibit it (make class final)
5. Don't break the Liskov Substitution Principle
6. Override hashCode() when overriding equals()

## Common Pitfalls

1. ❌ Deep inheritance hierarchies
2. ❌ Breaking encapsulation in parent classes
3. ❌ Overusing inheritance instead of composition
4. ❌ Forgetting to call super() in constructors
5. ❌ Accessing private members of parent class

## Exercises

1. Create a `BankAccount` hierarchy with different account types
2. Implement a `Document` hierarchy (Letter, Report, Book)
3. Design a game character system with inheritance

## Real-World Applications

1. GUI frameworks (Button extends Component)
2. Exception hierarchies (IOException extends Exception)
3. Collections framework (ArrayList extends AbstractList)
4. File systems (Directory extends File) 