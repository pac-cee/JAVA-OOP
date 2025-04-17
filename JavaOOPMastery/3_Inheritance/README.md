# Inheritance in Java

## What is Inheritance?
- Mechanism where one class acquires properties (fields and methods) of another.

## Example
```java
public class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

public class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

## Exercise
- Create a `Teacher` class that extends `Person` and adds a `teach()` method.

Continue to 4_Polymorphism after finishing the exercises.
