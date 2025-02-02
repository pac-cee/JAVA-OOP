package inheritance;

// Base class demonstrating inheritance
public class Animal {
    protected String name;
    protected String species;
    
    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecies() {
        return species;
    }
    
    // Method that can be overridden (polymorphism)
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Species: " + species);
    }
}
