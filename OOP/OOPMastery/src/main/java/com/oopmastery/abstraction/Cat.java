package com.oopmastery.abstraction;

public class Cat extends Animal {
    private String nameMother;
    public Cat(String name, int age, String animalType, String animalColor, String nameMother) {
        super(name, age, animalType, animalColor);
        this.nameMother = nameMother;
    }

    public String getNameMother() {
        return nameMother;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");

    }
    
    @Override
    public String toString() {
        return "Cat{name='" + getName() + "', age=" + getAge() + ", type='" + getAnimalType() + "', color='" + getAnimalColor() + "', motherName='" + nameMother + "'}";
    }
}