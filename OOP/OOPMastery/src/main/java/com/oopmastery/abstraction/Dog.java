package com.oopmastery.abstraction;

public class Dog extends Animal {
    public Dog(String name, int age, String animalType, String animalColor) {
        super(name, age, animalType, animalColor);
    }


    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "', age=" + getAge() + ", type='" + getAnimalType() + "', color='" + getAnimalColor() + "'}";
    }
}