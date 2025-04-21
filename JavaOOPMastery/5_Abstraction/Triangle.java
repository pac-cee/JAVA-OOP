// Triangle class for Shape Drawing API project
public class Triangle extends Shape {
    private final double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with base: " + base + " and height: " + height);
    }
}
