public class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof");
    }
    public static void main(String[] args) {
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        a1.sound(); // Output: Meow
        a2.sound(); // Output: Woof
    }
}
