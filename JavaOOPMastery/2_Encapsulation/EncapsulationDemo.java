// Demonstrates encapsulation with private fields and public getters/setters
public class EncapsulationDemo {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        EncapsulationDemo demo = new EncapsulationDemo();
        demo.setAge(25);
        System.out.println("Age: " + demo.getAge());
    }
}
