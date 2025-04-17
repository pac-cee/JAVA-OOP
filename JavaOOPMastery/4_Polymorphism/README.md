# Polymorphism in Java

## What is Polymorphism?
- Ability of an object to take many forms. Achieved by method overriding and interfaces.

## Example
```java
public class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

public class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

public class Dog extends Animal {
    void sound() {
        System.out.println("Woof");
    }
}
```

## Exercise
- Create an `Instrument` class and subclasses `Guitar`, `Piano` that override a `play()` method.

Continue to 5_Abstraction after finishing the exercises.
