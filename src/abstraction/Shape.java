package abstraction;

// Abstract class demonstration
public abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method - must be implemented by child classes
    public abstract double calculateArea();
    
    // Concrete method
    public void displayColor() {
        System.out.println("This shape is " + color);
    }
}
