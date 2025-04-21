public class Circle extends Shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}
