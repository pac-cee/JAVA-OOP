// Demo for Shape Drawing API project
public class ShapeDrawingDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 5)
        };
        for (Shape s : shapes) {
            s.draw();
        }
    }
}
