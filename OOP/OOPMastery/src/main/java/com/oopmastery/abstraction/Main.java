package com.oopmastery.abstraction;

public class Main {
    public static void main(String[] args) {
       
        Animal dog = new Dog("Buddy", 5, "Dog", "Brown");
        Animal cat = new Cat("Kitty", 3, "Cat", "White", "Whiskers");   
        
        System.out.println(dog.getName() + " is a " + dog.getAnimalColor() + " " + dog.getAnimalType() + " and is " + dog.getAge() + " years old.");
        System.out.println(cat.getName() + " is a " + cat.getAnimalColor() + " " + cat.getAnimalType() + " and is " + cat.getAge() + " years old.");
        
        System.out.println(dog);
        dog.makeSound();
        
        System.out.println(cat);
        cat.makeSound();
        

        System.out.println("The mother of " + cat.getName() + " is " + ((Cat) cat).getNameMother() + ".");
    }
}
