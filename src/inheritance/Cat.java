package inheritance;

public class Cat extends Animal {
    private final boolean isIndoor;
    
    public Cat(String name, boolean isIndoor) {
        super(name, "Cat");
        this.isIndoor = isIndoor;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor cat: " + isIndoor);
    }
    
    public void scratch() {
        System.out.println(name + " is scratching!");
    }
}
