import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solutions {

    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Employee Management System ===");
        EmployeeManagementDemo.demo();

        System.out.println("\n=== Exercise 2: Shape Class Hierarchy ===");
        ShapeHierarchyDemo.demo();

        System.out.println("\n=== Exercise 3: Bank Account System ===");
        BankAccountDemo.demo();

        System.out.println("\n=== Exercise 4: Vehicle Class with Abstract Methods ===");
        VehicleDemo.demo();

        System.out.println("\n=== Exercise 5: Library Management System ===");
        LibraryDemo.demo();

        System.out.println("\n=== Exercise 6: Online Payment System ===");
        OnlinePaymentDemo.demo();

        System.out.println("\n=== Exercise 7: Student Database System ===");
        StudentDatabaseDemo.demo();

        System.out.println("\n=== Exercise 8: Animal Sounds ===");
        AnimalSoundsDemo.demo();

        System.out.println("\n=== Exercise 9: Employee Payroll System ===");
        PayrollSystemDemo.demo();

        System.out.println("\n=== Exercise 10: Shape Drawing Program ===");
        ShapeDrawingDemo.demo();
    }

    // ----------------------------------------------------------------------
    // Exercise 1: Employee Management System
    // ----------------------------------------------------------------------
    static abstract class Employee {
        private String name;
        private int id;
        private double salary;
        private String department;

        public Employee(String name, int id, double salary, String department) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.department = department;
        }

        // Getters and Setters (encapsulation)
        public String getName() { return name; }
        public int getId() { return id; }
        public double getSalary() { return salary; }
        public String getDepartment() { return department; }
        public void setSalary(double salary) { this.salary = salary; }

        // Abstract methods for bonus and info display
        public abstract double calculateBonus();
        public abstract void displayEmployeeInfo();
    }

    static class Manager extends Employee {
        public Manager(String name, int id, double salary, String department) {
            super(name, id, salary, department);
        }

        @Override
        public double calculateBonus() {
            return getSalary() * 0.20;
        }

        @Override
        public void displayEmployeeInfo() {
            System.out.println("Manager Info:");
            System.out.println("Name: " + getName() + ", ID: " + getId());
            System.out.println("Department: " + getDepartment() + ", Salary: $" + getSalary());
            System.out.println("Bonus: $" + calculateBonus());
        }
    }

    static class Developer extends Employee {
        public Developer(String name, int id, double salary, String department) {
            super(name, id, salary, department);
        }

        @Override
        public double calculateBonus() {
            return getSalary() * 0.10;
        }

        @Override
        public void displayEmployeeInfo() {
            System.out.println("Developer Info:");
            System.out.println("Name: " + getName() + ", ID: " + getId());
            System.out.println("Department: " + getDepartment() + ", Salary: $" + getSalary());
            System.out.println("Bonus: $" + calculateBonus());
        }
    }

    static class EmployeeManagementDemo {
        public static void demo() {
            Employee manager = new Manager("Alice", 101, 80000, "Management");
            Employee developer = new Developer("Bob", 102, 60000, "Development");
            manager.displayEmployeeInfo();
            System.out.println();
            developer.displayEmployeeInfo();
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 2: Shape Class Hierarchy
    // ----------------------------------------------------------------------
    static abstract class GeometricShape {
        protected String name;

        public GeometricShape(String name) {
            this.name = name;
        }

        public abstract double area();
        public String getName() { return name; }
    }

    static class Circle extends GeometricShape {
        private double radius;

        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends GeometricShape {
        private double length, width;

        public Rectangle(double length, double width) {
            super("Rectangle");
            this.length = length;
            this.width = width;
        }

        @Override
        public double area() {
            return length * width;
        }
    }

    static class Triangle extends GeometricShape {
        private double base, height;

        public Triangle(double base, double height) {
            super("Triangle");
            this.base = base;
            this.height = height;
        }

        @Override
        public double area() {
            return 0.5 * base * height;
        }
    }

    static class ShapeHierarchyDemo {
        public static void demo() {
            GeometricShape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 7)
            };
            for (GeometricShape shape : shapes) {
                System.out.printf("%s Area: %.2f%n", shape.getName(), shape.area());
            }
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 3: Bank Account System
    // ----------------------------------------------------------------------
    static abstract class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public String getAccountNumber() { return accountNumber; }
        public double getBalance() { return balance; }
        protected void setBalance(double balance) { this.balance = balance; }

        public abstract void deposit(double amount);
        public abstract void withdraw(double amount);
    }

    static class CheckingAccount extends BankAccount {
        private double fee = 2.50; // withdrawal fee

        public CheckingAccount(String accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void deposit(double amount) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited $" + amount + " to Checking Account.");
        }

        @Override
        public void withdraw(double amount) {
            double total = amount + fee;
            if (getBalance() >= total) {
                setBalance(getBalance() - total);
                System.out.println("Withdrew $" + amount + " (Fee: $" + fee + ") from Checking Account.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate = 0.03; // 3%

        public SavingsAccount(String accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void deposit(double amount) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited $" + amount + " to Savings Account.");
        }

        @Override
        public void withdraw(double amount) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrew $" + amount + " from Savings Account.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }

        public void applyInterest() {
            double interest = getBalance() * interestRate;
            setBalance(getBalance() + interest);
            System.out.println("Applied interest: $" + interest);
        }
    }

    static class BankAccountDemo {
        public static void demo() {
            BankAccount checking = new CheckingAccount("CHK1001", 500);
            BankAccount savings = new SavingsAccount("SAV2001", 1000);

            checking.deposit(200);
            checking.withdraw(100);
            System.out.println("Checking Balance: $" + checking.getBalance());

            savings.deposit(300);
            savings.withdraw(150);
            ((SavingsAccount) savings).applyInterest();
            System.out.println("Savings Balance: $" + savings.getBalance());
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 4: Vehicle Class with Abstract Methods
    // ----------------------------------------------------------------------
    static abstract class Vehicle {
        public abstract void startEngine();
        public abstract void stopEngine();
    }

    static class Car extends Vehicle {
        @Override
        public void startEngine() {
            System.out.println("Car engine started.");
        }

        @Override
        public void stopEngine() {
            System.out.println("Car engine stopped.");
        }
    }

    static class Bike extends Vehicle {
        @Override
        public void startEngine() {
            System.out.println("Bike engine started.");
        }

        @Override
        public void stopEngine() {
            System.out.println("Bike engine stopped.");
        }
    }

    static class VehicleDemo {
        public static void demo() {
            Vehicle[] vehicles = { new Car(), new Bike() };
            for (Vehicle v : vehicles) {
                v.startEngine();
                v.stopEngine();
            }
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 5: Library Management System
    // ----------------------------------------------------------------------
    static abstract class Book {
        private String title;
        private String author;
        private String isbn;

        public Book(String title, String author, String isbn) {
            this.title  = title;
            this.author = author;
            this.isbn   = isbn;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }

        public abstract void borrowBook();
    }

    static class PrintedBook extends Book {
        private String dueDate;

        public PrintedBook(String title, String author, String isbn, String dueDate) {
            super(title, author, isbn);
            this.dueDate = dueDate;
        }

        @Override
        public void borrowBook() {
            System.out.println("Printed Book \"" + getTitle() + "\" borrowed. Return by: " + dueDate);
        }
    }

    static class EBook extends Book {
        private String license;

        public EBook(String title, String author, String isbn, String license) {
            super(title, author, isbn);
            this.license = license;
        }

        @Override
        public void borrowBook() {
            System.out.println("EBook \"" + getTitle() + "\" borrowed under license: " + license);
        }
    }

    static class LibraryDemo {
        public static void demo() {
            Book printed = new PrintedBook("1984", "George Orwell", "1234567890", "2025-01-01");
            Book ebook = new EBook("Brave New World", "Aldous Huxley", "0987654321", "Standard License");
            printed.borrowBook();
            ebook.borrowBook();
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 6: Online Payment System
    // ----------------------------------------------------------------------
    interface PaymentMethod {
        void pay(double amount);
        void refund(double amount);
    }

    static abstract class OnlinePayment implements PaymentMethod {
        public abstract String getTransactionId();
    }

    static class CreditCard extends OnlinePayment {
        private String transactionId;

        public CreditCard(String transactionId) {
            this.transactionId = transactionId;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Credit Card payment of $" + amount + " processed.");
        }

        @Override
        public void refund(double amount) {
            System.out.println("Credit Card refund of $" + amount + " processed.");
        }

        @Override
        public String getTransactionId() {
            return transactionId;
        }
    }

    static class PayPal extends OnlinePayment {
        private String transactionId;

        public PayPal(String transactionId) {
            this.transactionId = transactionId;
        }

        @Override
        public void pay(double amount) {
            System.out.println("PayPal payment of $" + amount + " processed.");
        }

        @Override
        public void refund(double amount) {
            System.out.println("PayPal refund of $" + amount + " processed.");
        }

        @Override
        public String getTransactionId() {
            return transactionId;
        }
    }

    static class OnlinePaymentDemo {
        public static void demo() {
            OnlinePayment payment1 = new CreditCard("CC123");
            OnlinePayment payment2 = new PayPal("PP456");

            payment1.pay(100);
            payment1.refund(50);
            System.out.println("Transaction ID: " + payment1.getTransactionId());

            payment2.pay(200);
            payment2.refund(75);
            System.out.println("Transaction ID: " + payment2.getTransactionId());
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 7: Student Database System
    // ----------------------------------------------------------------------
    static abstract class Student {
        private String name;
        private int age;
        private String grade;

        public Student(String name, int age, String grade) {
            this.name  = name;
            this.age   = age;
            this.grade = grade;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getGrade() { return grade; }

        public abstract void displayDetails();
    }

    static class UndergraduateStudent extends Student {
        private List<String> courses;

        public UndergraduateStudent(String name, int age, String grade, List<String> courses) {
            super(name, age, grade);
            this.courses = courses;
        }

        @Override
        public void displayDetails() {
            System.out.println("Undergraduate Student: " + getName());
            System.out.println("Age: " + getAge() + ", Grade: " + getGrade());
            System.out.println("Courses: " + String.join(", ", courses));
        }
    }

    static class GraduateStudent extends Student {
        private String thesisTitle;

        public GraduateStudent(String name, int age, String grade, String thesisTitle) {
            super(name, age, grade);
            this.thesisTitle = thesisTitle;
        }

        @Override
        public void displayDetails() {
            System.out.println("Graduate Student: " + getName());
            System.out.println("Age: " + getAge() + ", Grade: " + getGrade());
            System.out.println("Thesis: " + thesisTitle);
        }
    }

    static class StudentDatabaseDemo {
        public static void demo() {
            Student undergrad = new UndergraduateStudent("Charlie", 20, "B", Arrays.asList("Math", "Physics", "Chemistry"));
            Student grad = new GraduateStudent("Diana", 24, "A", "Machine Learning in Healthcare");
            undergrad.displayDetails();
            System.out.println();
            grad.displayDetails();
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 8: Animal Sounds
    // ----------------------------------------------------------------------
    static abstract class Animal {
        public abstract void makeSound();
    }

    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Dog: Woof Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Cat: Meow!");
        }
    }

    static class Cow extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Cow: Moo!");
        }
    }

    static class AnimalSoundsDemo {
        public static void demo() {
            Animal[] animals = { new Dog(), new Cat(), new Cow() };
            for (Animal a : animals) {
                a.makeSound();
            }
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 9: Employee Payroll System
    // ----------------------------------------------------------------------
    static abstract class PayrollEmployee {
        private String name;
        private double basePay;

        public PayrollEmployee(String name, double basePay) {
            this.name = name;
            this.basePay = basePay;
        }

        public String getName() { return name; }
        public double getBasePay() { return basePay; }

        public abstract double calculatePay();
    }

    static class SalariedEmployee extends PayrollEmployee {
        public SalariedEmployee(String name, double basePay) {
            super(name, basePay);
        }

        @Override
        public double calculatePay() {
            return getBasePay(); // Fixed salary
        }
    }

    static class HourlyEmployee extends PayrollEmployee {
        private int hoursWorked;
        private double hourlyRate;

        public HourlyEmployee(String name, double basePay, int hoursWorked, double hourlyRate) {
            super(name, basePay);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculatePay() {
            return getBasePay() + (hoursWorked * hourlyRate);
        }
    }

    static class PayrollSystemDemo {
        public static void demo() {
            PayrollEmployee emp1 = new SalariedEmployee("Eve", 5000);
            PayrollEmployee emp2 = new HourlyEmployee("Frank", 1000, 40, 20);
            System.out.println(emp1.getName() + "'s Pay: $" + emp1.calculatePay());
            System.out.println(emp2.getName() + "'s Pay: $" + emp2.calculatePay());
        }
    }

    // ----------------------------------------------------------------------
    // Exercise 10: Shape Drawing Program
    // ----------------------------------------------------------------------
    interface Drawable {
        void draw();
    }

    static abstract class DrawableShape implements Drawable {
        protected String color;

        public DrawableShape(String color) {
            this.color = color;
        }

        public String getColor() { return color; }
    }

    static class DrawableCircle extends DrawableShape {
        private double radius;

        public DrawableCircle(double radius, String color) {
            super(color);
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a " + color + " circle with radius " + radius);
        }
    }

    static class DrawableRectangle extends DrawableShape {
        private double length, width;

        public DrawableRectangle(double length, double width, String color) {
            super(color);
            this.length = length;
            this.width = width;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a " + color + " rectangle with length " + length + " and width " + width);
        }
    }

    static class DrawableTriangle extends DrawableShape {
        private double base, height;

        public DrawableTriangle(double base, double height, String color) {
            super(color);
            this.base = base;
            this.height = height;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a " + color + " triangle with base " + base + " and height " + height);
        }
    }

    static class ShapeDrawingDemo {
        public static void demo() {
            Drawable[] shapes = {
                new DrawableCircle(5, "Red"),
                new DrawableRectangle(4, 6, "Blue"),
                new DrawableTriangle(3, 7, "Green")
            };
            for (Drawable shape : shapes) {
                shape.draw();
            }
        }
    }
}
