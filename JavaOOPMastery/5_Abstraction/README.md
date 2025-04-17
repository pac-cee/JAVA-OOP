# Abstraction in Java

## What is Abstraction?
- Hiding complex implementation details and showing only the necessary features.
- Achieved using abstract classes and interfaces.

## Example
```java
public abstract class Shape {
    abstract double area();
}

public class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}
```

## Exercise
- Create an abstract class `Appliance` with an abstract method `turnOn()`, and a subclass `WashingMachine` that implements it.

Continue to 6_Composition_Aggregation after finishing the exercises.
