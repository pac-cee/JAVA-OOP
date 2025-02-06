# Java Basic Exercises

This project contains a collection of 20 basic Java exercises organized by functionality. Each exercise demonstrates different programming concepts and practical applications.

## Project Structure

```
src/main/java/exercises/
├── finance/
│   └── FinancialCalculator.java      # Financial calculations and pricing
├── game/
│   └── NumberGuessingGame.java       # Interactive number guessing game
├── geometry/
│   └── ShapeClassifier.java          # Shape-related calculations
├── health/
│   └── HealthCalculator.java         # Health metrics and calculations
├── numbers/
│   └── NumberOperations.java         # Number manipulation and checks
├── restaurant/
│   └── RestaurantSystem.java         # Restaurant menu pricing
├── security/
│   └── SecurityValidator.java         # Security and validation
├── time/
│   └── TimeGreeting.java             # Time-based operations
└── ExerciseDemo.java                 # Main demo class
```

## Exercises List

### Geometry and Shapes
1. Triangle Type Classification
   - Determines if a triangle is equilateral, isosceles, or scalene
2. Shape Classification
   - Identifies shapes based on number of sides
3. Chess Piece Movement
   - Describes how different chess pieces move

### Numbers and Math
4. Number Properties
   - Checks if a number is positive/negative/zero and even/odd
5. Palindrome Check
   - Verifies if a number reads the same backward as forward
6. Number to Word
   - Converts digits to their word representation
7. Grade Calculator
   - Converts percentages to letter grades with feedback

### Financial Operations
8. Employee Bonus Calculator
   - Calculates bonus based on years of service
9. Electricity Bill Calculator
   - Computes bill based on unit consumption
10. Loan Eligibility Checker
    - Determines loan eligibility based on multiple criteria
11. Currency Converter
    - Converts between different currencies
12. Vehicle Fee Calculator
    - Calculates fees based on vehicle type
13. Customer Discount System
    - Applies discounts based on customer category

### Security and System
14. Password Validator
    - Checks if passwords meet security requirements
15. OS Identifier
    - Identifies the operating system

### Time and Date
16. Time-based Greeting
    - Provides appropriate greetings based on time
17. Zodiac Sign Calculator
    - Determines zodiac sign based on birth date

### Health
18. BMI Calculator
    - Calculates and categorizes Body Mass Index

### Restaurant
19. Menu Price System
    - Retrieves prices for menu items

### Games
20. Number Guessing Game
    - Interactive game against the computer

## How to Run

1. Make sure you have Java JDK installed (version 8 or higher)
2. Navigate to the project root directory
3. Compile the project:
   ```bash
   javac src/main/java/exercises/*/*.java src/main/java/exercises/ExerciseDemo.java
   ```
4. Run the demo:
   ```bash
   java -cp src/main/java exercises.ExerciseDemo
   ```

## Exercise Details

### Example Usage

```java
// Triangle Classification
String triangleType = ShapeClassifier.determineTriangleType(3, 3, 3);  // Returns "Equilateral"

// Number Properties
String numberInfo = NumberOperations.checkNumber(-4);  // Returns "The number is negative and even"

// BMI Calculation
String bmiCategory = HealthCalculator.calculateBMI(70, 1.75);  // Returns "Normal"

// Password Validation
boolean isValid = SecurityValidator.isPasswordValid("Pass123!");  // Returns true
```

## Contributing

Feel free to add more exercises or improve existing ones. When contributing:
1. Follow the existing package structure
2. Add appropriate documentation
3. Include example usage in the demo class

## License

This project is open source and available for educational purposes.
