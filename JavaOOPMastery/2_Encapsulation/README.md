# Encapsulation in Java

## What is Encapsulation?
- Hiding internal state and requiring all interaction to be performed through methods.
- Use `private` fields and `public` getters/setters.

## Example
```java
public class Student {
    private String name;
    private int age;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

## Exercise
- Add validation in setter: `age` cannot be negative.

Continue to 3_Inheritance after finishing the exercises.
