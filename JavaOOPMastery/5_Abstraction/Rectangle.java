// Rectangle class for Shape Drawing API project
public class Rectangle extends Shape {
    private final double width, height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of width: " + width + " and height: " + height);
    }
}
