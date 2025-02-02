package abstraction;

public interface Drawable {
    void draw();  // Abstract method
    default void displayInfo() {  // Default method
        System.out.println("This is a drawable shape");
    }
}
