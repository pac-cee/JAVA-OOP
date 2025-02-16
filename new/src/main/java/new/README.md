# Java OOP Learning Project

This project demonstrates core Object-Oriented Programming (OOP) concepts in Java through practical examples. It includes a Docker setup for easy execution and development.

## Project Structure

```
src/
├── Main.java                 # Main demonstration class
├── basics/
│   └── Person.java          # Demonstrates encapsulation
├── inheritance/
│   ├── Animal.java          # Base class for inheritance
│   ├── Dog.java             # Demonstrates inheritance and polymorphism
│   └── Cat.java             # Another example of inheritance and polymorphism
└── abstraction/
    ├── Shape.java           # Abstract class example
    ├── Drawable.java        # Interface example
    ├── Circle.java          # Concrete class implementing Shape and Drawable
    └── Rectangle.java       # Another concrete class example
```

## OOP Concepts Demonstrated

### 1. Encapsulation (`Person.java`)
- Private fields (`name`, `age`)
- Public getters and setters
- Data validation in setters
- Bundling of data and methods

### 2. Inheritance (`Animal.java`, `Dog.java`, `Cat.java`)
- Base class with common properties and methods
- Child classes extending base class
- Method inheritance
- Protected access modifiers

### 3. Polymorphism
- Method overriding (`makeSound()` in Dog and Cat)
- Runtime polymorphism (same method, different behavior)
- Type casting between parent and child classes

### 4. Abstraction (`Shape.java`, `Drawable.java`)
- Abstract class with abstract methods
- Interface definition
- Multiple implementation
- Default interface methods

## Running the Code

### Using Docker (Recommended)
1. Build the Docker image:
   ```bash
   docker build -t java-dev .
   ```

2. Run the container:
   ```bash
   docker run -it --rm -v ${PWD}:/app java-dev
   ```

3. Inside the container, compile and run:
   ```bash
   cd src
   javac Main.java
   java Main
   ```

### Without Docker
Requirements:
- Java JDK 17 or higher
- Any operating system

Steps:
1. Navigate to the src directory:
   ```bash
   cd src
   ```

2. Compile the code:
   ```bash
   javac Main.java
   ```

3. Run the program:
   ```bash
   java Main
   ```

## Expected Output
The program will demonstrate:
1. Person class with encapsulation
2. Animal inheritance hierarchy with Dogs and Cats
3. Shape abstraction with Circles and Rectangles

Each section will show different aspects of OOP through practical examples.

## Code Examples

### Encapsulation Example
```java
Person person = new Person("John", 25);
person.setAge(26);  // Using setter
System.out.println(person.getAge());  // Using getter
```

### Inheritance and Polymorphism Example
```java
Animal dog = new Dog("Buddy", "Golden Retriever");
Animal cat = new Cat("Whiskers", true);
dog.makeSound();  // Outputs: "Woof! Woof!"
cat.makeSound();  // Outputs: "Meow!"
```

### Abstraction Example
```java
Shape circle = new Circle("Red", 5.0);
Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
System.out.println(circle.calculateArea());
System.out.println(rectangle.calculateArea());
```

## Best Practices Demonstrated
1. Proper package organization
2. Clear class hierarchy
3. Meaningful variable and method names
4. Appropriate access modifiers
5. Code documentation
6. Interface segregation
7. Single responsibility principle

## Contributing
Feel free to fork this repository and add more examples or improvements. Some ideas:
- Add more complex inheritance examples
- Implement additional design patterns
- Add unit tests
- Enhance documentation with more examples
