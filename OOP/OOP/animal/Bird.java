package OOP.animal;

import OOP.interfaces.Flyable;

/**
 * Bird class representing a bird animal that can fly
 */
public class Bird extends Animal implements Flyable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying high in the sky!");
    }
} 