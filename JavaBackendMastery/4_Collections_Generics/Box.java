// A generic class that can hold any type of object
public class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println("Boxed value: " + intBox.get());
    }
}
