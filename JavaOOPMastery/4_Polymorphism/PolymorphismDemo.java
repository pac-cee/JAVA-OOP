// Demonstrates polymorphism with interfaces
interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
}

class Rectangle implements Shape {
    private double width, height;
    public Rectangle(double width, double height) { this.width = width; this.height = height; }
    public double area() { return width * height; }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape s1 = new Circle(3);
        Shape s2 = new Rectangle(4, 5);
        System.out.println("Circle area: " + s1.area());
        System.out.println("Rectangle area: " + s2.area());
    }
}
