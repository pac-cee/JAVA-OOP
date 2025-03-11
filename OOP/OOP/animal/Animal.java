package OOP.animal;

/**
 * Abstract base class for all animals
 */
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Abstract method that each animal must implement to make its unique sound
     */
    public abstract void makeSound();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [name=" + name + ", age=" + age + "]";
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
} 