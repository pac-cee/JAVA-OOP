package inheritance;

public class Dog extends Animal {
    private final String breed;
    
    public Dog(String name, String breed) {
        super(name, "Dog");  // Call parent constructor
        this.breed = breed;
    }
    
    public String getBreed() {
        return breed;
    }
    
    // Method overriding (polymorphism)
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
}
