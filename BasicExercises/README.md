# Java Basic Exercises

This project contains a collection of 30 basic Java exercises organized by functionality. Each exercise demonstrates different programming concepts and practical applications.

## Project Structure

```
src/main/java/exercises/
├── arrays/
│   └── ArrayOperations.java          # Array manipulations
├── finance/
│   └── FinancialCalculator.java      # Financial calculations and pricing
├── formatting/
│   └── StringFormatter.java          # String and date formatting
├── game/
│   └── NumberGuessingGame.java       # Interactive number guessing game
├── geometry/
│   └── ShapeClassifier.java          # Shape-related calculations
├── health/
│   └── HealthCalculator.java         # Health metrics and calculations
├── input/
│   └── UserInputProcessor.java       # Input processing operations
├── numbers/
│   └── NumberOperations.java         # Number manipulation and checks
├── random/
│   └── RandomGenerator.java          # Random number generation
├── restaurant/
│   └── RestaurantSystem.java         # Restaurant menu pricing
├── security/
│   └── SecurityValidator.java         # Security and validation
├── time/
│   └── TimeGreeting.java             # Time-based operations
└── ExerciseDemo.java                 # Main demo class
```

## Exercises List

### Input and Processing
1. Process User Input
   - Assign and process a value based on user input
2. Number Swapping
   - Swap two numbers using arithmetic operations
3. Array Operations
   - Generate and store first 10 prime numbers
4. Random Number Generation
   - Generate numbers between specified ranges

### String and Date Formatting
5. DateTime Formatting
   - Format LocalDateTime into readable strings
6. Name Formatting
   - Format full names as "Last Name, First Name"
7. Word Reversal
   - Reverse words in a sentence
8. URL Generation
   - Generate personalized URLs from usernames
9. Log Message Generation
   - Create timestamped log messages
10. String Encoding
    - Encode strings using ASCII manipulation

### Geometry and Shapes
11. Triangle Type Classification
   - Determines if a triangle is equilateral, isosceles, or scalene
12. Shape Classification
   - Identifies shapes based on number of sides
13. Chess Piece Movement
   - Describes how different chess pieces move

### Numbers and Math
14. Number Properties
   - Checks if a number is positive/negative/zero and even/odd
15. Palindrome Check
   - Verifies if a number reads the same backward as forward
16. Number to Word
   - Converts digits to their word representation
17. Grade Calculator
   - Converts percentages to letter grades with feedback

### Financial Operations
18. Employee Bonus Calculator
   - Calculates bonus based on years of service
19. Electricity Bill Calculator
   - Computes bill based on unit consumption
20. Loan Eligibility Checker
    - Determines loan eligibility based on multiple criteria
21. Currency Converter
    - Converts between different currencies
22. Vehicle Fee Calculator
    - Calculates fees based on vehicle type
23. Customer Discount System
    - Applies discounts based on customer category

### Security and System
24. Password Validator
    - Checks if passwords meet security requirements
25. OS Identifier
    - Identifies the operating system

### Time and Date
26. Time-based Greeting
    - Provides appropriate greetings based on time
27. Zodiac Sign Calculator
    - Determines zodiac sign based on birth date

### Health
28. BMI Calculator
    - Calculates and categorizes Body Mass Index

### Restaurant
29. Menu Price System
    - Retrieves prices for menu items

### Games
30. Number Guessing Game
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
// Process User Input
int processedValue = UserInputProcessor.processNumericInput(scanner);

// Generate Prime Numbers
int[] primes = ArrayOperations.generateFirstNPrimes(10);

// Format DateTime
String formattedDate = StringFormatter.formatDateTime(LocalDateTime.now());

// Generate URL
String url = StringFormatter.generateURL("John Doe");  // Returns "www.johndoe.com"

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
