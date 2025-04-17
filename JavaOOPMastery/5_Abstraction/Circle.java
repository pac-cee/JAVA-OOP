public class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("Area: " + c.area()); // Output: Area: 78.5398...
    }
}
