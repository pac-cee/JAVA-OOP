# 2. Object-Oriented Programming (OOP)

## Overview
Learn Java OOP principles: classes, objects, encapsulation, inheritance, polymorphism, abstraction, interfaces, and SOLID.

## Topics
- Classes & objects
- Encapsulation, inheritance, polymorphism, abstraction
- Interfaces & abstract classes
- Composition & aggregation
- SOLID principles

## Example: Class & Object
```java
public class Car {
    String brand;
    void drive() { System.out.println(brand + " is driving"); }
    public static void main(String[] args) {
        Car car = new Car();
        car.brand = "Toyota";
        car.drive();
    }
}
```

## Exercise
- Create a `Person` class with name and age fields, and a method to introduce themselves.
- Implement inheritance with an `Employee` class extending `Person`.

Continue to 3_Core_Java_APIs after this.
