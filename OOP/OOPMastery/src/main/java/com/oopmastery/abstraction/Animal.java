package com.oopmastery.abstraction;

public abstract class Animal {
    private final String name;
    private final int age;
    private final String animalType;
    private final String animalColor;
    
    public Animal(String name, int age, String animalType, String animalColor) {
        this.name = name;
        this.age = age;
        this.animalType = animalType;
        this.animalColor = animalColor;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public abstract void makeSound();

    public void animalSleep() {
        System.out.println("The animal is sleeping");
    }
    

}
