package classwork;
public class ClassExercises {
    public class Person {
        private final String name;
        private final int age;
        
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        public String getName(){ return name; }
        public int getAge(){ return age; }
    }


    public class Dog {
        private String name;
        private String breed;
        
        public Dog(String name, String breed){
            this.name = name;
            this.breed = breed;
        }
        
        public String getName(){ return name; }
        public String getBreed(){ return breed; }
        
        public void setName(String name){ this.name = name; }
        public void setBreed(String breed){ this.breed = breed; }
    }
    public class Rectangle {
        private double width;
        private double height;
        
        public Rectangle(double width, double height){
            this.width = width;
            this.height = height;
        }
        
        public double getArea(){ return width * height; }
        public double getPerimeter(){ return 2 * (width + height); }
        
        public static void main(String[] args) {
            Rectangle rect = new Rectangle(5, 3);
            System.out.println("Area: " + rect.getArea());
            System.out.println("Perimeter: " + rect.getPerimeter());
        }
    }
    public class Circle {
        private double radius;
        
        public Circle(double radius){ this.radius = radius; }
        
        public double getArea(){ return Math.PI * radius * radius; }
        public double getCircumference(){ return 2 * Math.PI * radius; }
        
        public double getRadius(){ return radius; }
        public void setRadius(double radius){ this.radius = radius; }
        
        public static void main(String[] args) {
            Circle circle = new Circle(4);
            System.out.println("Area: " + circle.getArea());
            System.out.println("Circumference: " + circle.getCircumference());
            circle.setRadius(5);
            System.out.println("Updated Radius: " + circle.getRadius());
        }
    }
    import java.util.ArrayList;
    import java.util.List;
    
    public class Book {
        private String title;
        private String author;
        private String isbn;
        
        public Book(String title, String author, String isbn){
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        
        public String toString(){
            return title + " by " + author + " (ISBN: " + isbn + ")";
        }
        
        // Inner class Library manages a collection of books
        public static class Library {
            private List<Book> books = new ArrayList<>();
            
            public void addBook(Book book){ books.add(book); }
            public void removeBook(Book book){ books.remove(book); }
            public void displayBooks(){
                for(Book b : books) {
                    System.out.println(b);
                }
            }
        }
        
        public static void main(String[] args) {
            Library library = new Library();
            Book b1 = new Book("Java Basics", "John Doe", "123456");
            Book b2 = new Book("Advanced Java", "Jane Doe", "654321");
            library.addBook(b1);
            library.addBook(b2);
            library.displayBooks();
            library.removeBook(b1);
            System.out.println("After removal:");
            library.displayBooks();
        }
    }
    public class Employee {
        private String name;
        private String jobTitle;
        private double salary;
        
        public Employee(String name, String jobTitle, double salary){
            this.name = name;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
        
        public double calculateSalary(double bonus){ return salary + bonus; }
        public void updateSalary(double newSalary){ salary = newSalary; }
        
        public String toString(){
            return name + " (" + jobTitle + ") - Salary: " + salary;
        }
        
        public static void main(String[] args) {
            Employee emp = new Employee("Alice", "Developer", 50000);
            System.out.println(emp);
            System.out.println("Salary with bonus: " + emp.calculateSalary(5000));
            emp.updateSalary(55000);
            System.out.println("Updated: " + emp);
        }
    }
    import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private String customerName;
    private double balance;
    
    public Account(String accountNumber, String customerName, double balance){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }
    
    public void deposit(double amount){ balance += amount; }
    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public double getBalance(){ return balance; }
    
    public String toString(){
        return "Account " + accountNumber + " - " + customerName + " : Balance = " + balance;
    }
}

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    
    public void addAccount(Account account){ accounts.add(account); }
    public void removeAccount(Account account){ accounts.remove(account); }
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account acc1 = new Account("001", "Alice", 1000);
        Account acc2 = new Account("002", "Bob", 2000);
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        acc1.deposit(500);
        System.out.println(acc1);
        if(acc2.withdraw(2500)){
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient funds");
        }
        System.out.println(acc2);
    }
}
public class TrafficLight {
    private String color;
    private int duration; // in seconds
    
    public TrafficLight(String color, int duration){
        this.color = color;
        this.duration = duration;
    }
    
    public void changeColor(String newColor){ this.color = newColor; }
    public boolean isRed(){ return "Red".equalsIgnoreCase(color); }
    public boolean isGreen(){ return "Green".equalsIgnoreCase(color); }
    public String getColor(){ return color; }
    
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("Red", 30);
        System.out.println("Current color: " + light.getColor());
        light.changeColor("Green");
        System.out.println("Changed color: " + light.getColor());
        System.out.println("Is red? " + light.isRed());
    }
}
import java.time.LocalDate;
import java.time.Period;

public class EmployeeWithHireDate {
    private String name;
    private double salary;
    private LocalDate hireDate;
    
    public EmployeeWithHireDate(String name, double salary, LocalDate hireDate){
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }
    
    public int getYearsOfService(){
        return Period.between(hireDate, LocalDate.now()).getYears();
    }
    
    public String toString(){
        return name + " - Years of service: " + getYearsOfService();
    }
    
    public static void main(String[] args) {
        EmployeeWithHireDate emp = new EmployeeWithHireDate("Alice", 60000, LocalDate.of(2015, 5, 20));
        System.out.println(emp);
    }
}
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String grade;
    private List<String> courses;
    
    public Student(String name, String grade){
        this.name = name;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }
    
    public void addCourse(String course){ courses.add(course); }
    public void removeCourse(String course){ courses.remove(course); }
    public void displayCourses(){ System.out.println(name + "'s courses: " + courses); }
    
    public static void main(String[] args) {
        Student s = new Student("Bob", "A");
        s.addCourse("Math");
        s.addCourse("Science");
        s.displayCourses();
        s.removeCourse("Math");
        s.displayCourses();
    }
}
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    
    public Library(){ books = new ArrayList<>(); }
    
    public void addBook(Book book){ books.add(book); }
    public void removeBook(Book book){ books.remove(book); }
    public void displayBooks(){
        for(Book b: books) {
            System.out.println(b);
        }
    }
    
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book("Java 101", "John Doe", "111111");
        Book b2 = new Book("Advanced Java", "Jane Doe", "222222");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.displayBooks();
    }
}

public class Airplane {
    private String flightNumber;
    private String destination;
    private String departureTime; // could use LocalTime
    
    public Airplane(String flightNumber, String destination, String departureTime){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }
    
    public void checkStatus(){
        System.out.println("Flight " + flightNumber + " is on time.");
    }
    
    public void delayFlight(int minutes){
        System.out.println("Flight " + flightNumber + " is delayed by " + minutes + " minutes.");
    }
    
    public static void main(String[] args) {
        Airplane plane = new Airplane("AA123", "New York", "10:00 AM");
        plane.checkStatus();
        plane.delayFlight(15);
    }
}
class Product {
    private String name;
    private int quantity;
    
    public Product(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    
    public String getName(){ return name; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }
    
    public String toString(){
        return name + " (Quantity: " + quantity + ")";
    }
}

public class Inventory {
    private java.util.List<Product> products;
    
    public Inventory(){ products = new java.util.ArrayList<>(); }
    
    public void addProduct(Product product){ products.add(product); }
    public void removeProduct(Product product){ products.remove(product); }
    
    public void checkLowInventory(int threshold){
        for(Product p: products){
            if(p.getQuantity() < threshold){
                System.out.println(p.getName() + " is low on inventory.");
            }
        }
    }
    
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Product p1 = new Product("Widget", 10);
        Product p2 = new Product("Gadget", 3);
        inv.addProduct(p1);
        inv.addProduct(p2);
        inv.checkLowInventory(5);
    }
}
import java.util.ArrayList;
import java.util.List;

public class School {
    private List<String> students;
    private List<String> teachers;
    private List<String> classes;
    
    public School(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        classes = new ArrayList<>();
    }
    
    public void addStudent(String student){ students.add(student); }
    public void removeStudent(String student){ students.remove(student); }
    public void addTeacher(String teacher){ teachers.add(teacher); }
    public void removeTeacher(String teacher){ teachers.remove(teacher); }
    public void addClass(String className){ classes.add(className); }
    
    public void displayInfo(){
        System.out.println("Students: " + students);
        System.out.println("Teachers: " + teachers);
        System.out.println("Classes: " + classes);
    }
    
    public static void main(String[] args) {
        School school = new School();
        school.addStudent("Alice");
        school.addTeacher("Mr. Smith");
        school.addClass("Math");
        school.displayInfo();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicLibrary {
    private List<String> songs;
    
    public MusicLibrary(){ songs = new ArrayList<>(); }
    
    public void addSong(String song){ songs.add(song); }
    public void removeSong(String song){ songs.remove(song); }
    
    public void playRandomSong(){
        if(songs.isEmpty()){
            System.out.println("No songs available.");
            return;
        }
        Random rand = new Random();
        int index = rand.nextInt(songs.size());
        System.out.println("Now playing: " + songs.get(index));
    }
    
    public static void main(String[] args) {
        MusicLibrary ml = new MusicLibrary();
        ml.addSong("Song A");
        ml.addSong("Song B");
        ml.playRandomSong();
    }
}
abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rect extends Shape {
    private double width, height;
    public Rect(double width, double height){ this.width = width; this.height = height; }
    public double getArea(){ return width * height; }
    public double getPerimeter(){ return 2 * (width + height); }
}

class Circ extends Shape {
    private double radius;
    public Circ(double radius){ this.radius = radius; }
    public double getArea(){ return Math.PI * radius * radius; }
    public double getPerimeter(){ return 2 * Math.PI * radius; }
}

class Triangle extends Shape {
    private double a, b, c;
    public Triangle(double a, double b, double c){ this.a = a; this.b = b; this.c = c; }
    public double getPerimeter(){ return a + b + c; }
    public double getArea(){
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape rectangle = new Rect(4, 5);
        Shape circle = new Circ(3);
        Shape triangle = new Triangle(3, 4, 5);
        
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());
    }
}
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String director;
    private List<String> actors;
    private List<String> reviews;
    
    public Movie(String title, String director, List<String> actors){
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.reviews = new ArrayList<>();
    }
    
    public void addReview(String review){ reviews.add(review); }
    public List<String> getReviews(){ return reviews; }
    
    public String toString(){ return title + " directed by " + director; }
    
    public static void main(String[] args) {
        List<String> actors = new ArrayList<>();
        actors.add("Actor A");
        actors.add("Actor B");
        Movie movie = new Movie("My Movie", "Director X", actors);
        movie.addReview("Great movie!");
        movie.addReview("Enjoyed it.");
        System.out.println(movie);
        System.out.println("Reviews: " + movie.getReviews());
    }
}
import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;
    private double rating;
    
    public MenuItem(String name, double price, double rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
    
    public double getRating(){ return rating; }
    
    public String toString(){ return name + " ($" + price + "), Rating: " + rating; }
}

public class Restaurant {
    private List<MenuItem> menu;
    
    public Restaurant(){ menu = new ArrayList<>(); }
    
    public void addItem(MenuItem item){ menu.add(item); }
    public void removeItem(MenuItem item){ menu.remove(item); }
    
    public double calculateAverageRating(){
        double sum = 0;
        for(MenuItem item : menu){ sum += item.getRating(); }
        return menu.isEmpty() ? 0 : sum / menu.size();
    }
    
    public void displayMenu(){
        for(MenuItem item : menu){ System.out.println(item); }
    }
    
    public static void main(String[] args) {
        Restaurant res = new Restaurant();
        res.addItem(new MenuItem("Burger", 5.99, 4.2));
        res.addItem(new MenuItem("Pizza", 8.99, 4.5));
        res.displayMenu();
        System.out.println("Average Rating: " + res.calculateAverageRating());
    }
}
import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    public Flight(String flightNumber){ this.flightNumber = flightNumber; }
    public String toString(){ return "Flight: " + flightNumber; }
}

class Hotel {
    private String hotelName;
    public Hotel(String hotelName){ this.hotelName = hotelName; }
    public String toString(){ return "Hotel: " + hotelName; }
}

public class ReservationSystem {
    private List<Flight> flights;
    private List<Hotel> hotels;
    
    public ReservationSystem(){
        flights = new ArrayList<>();
        hotels = new ArrayList<>();
        // Sample data
        flights.add(new Flight("AA101"));
        flights.add(new Flight("BB202"));
        hotels.add(new Hotel("Grand Hotel"));
        hotels.add(new Hotel("Budget Inn"));
    }
    
    public Flight searchFlight(String flightNumber){
        for(Flight f : flights){
            if(f.toString().contains(flightNumber))
                return f;
        }
        return null;
    }
    
    public Hotel searchHotel(String hotelName){
        for(Hotel h : hotels){
            if(h.toString().contains(hotelName))
                return h;
        }
        return null;
    }
    
    public void bookReservation(String type, String identifier){
        System.out.println("Booking " + type + " reservation for " + identifier);
    }
    
    public void cancelReservation(String type, String identifier){
        System.out.println("Cancelling " + type + " reservation for " + identifier);
    }
    
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Flight flight = system.searchFlight("AA101");
        if(flight != null) {
            System.out.println("Found: " + flight);
            system.bookReservation("Flight", "AA101");
        }
        Hotel hotel = system.searchHotel("Grand");
        if(hotel != null) {
            System.out.println("Found: " + hotel);
            system.bookReservation("Hotel", "Grand Hotel");
        }
    }
}
public class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public void deposit(double amount){ balance += amount; }
    public boolean withdraw(double amount){
        if(amount <= balance){ balance -= amount; return true; }
        return false;
    }
    
    public double getBalance(){ return balance; }
    
    public String toString(){
        return "Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate){
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    
    public void applyInterest(){ balance += balance * interestRate; }
    
    public String toString(){ return super.toString() + ", Interest Rate: " + interestRate; }
    
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("001", "Alice", 1000, 0.05);
        System.out.println(sa);
        sa.applyInterest();
        System.out.println("After interest: " + sa);
    }
}
public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    
    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    public void displayDetails(){
        System.out.println(year + " " + make + " " + model);
    }
}

class Car extends Vehicle {
    private double trunkSize;
    
    public Car(String make, String model, int year, double trunkSize){
        super(make, model, year);
        this.trunkSize = trunkSize;
    }
    
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Trunk Size: " + trunkSize);
    }
}

class Truck extends Vehicle {
    private double payloadCapacity;
    
    public Truck(String make, String model, int year, double payloadCapacity){
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }
    
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity);
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020, 15.5);
        Truck truck = new Truck("Ford", "F-150", 2019, 1200);
        car.displayDetails();
        truck.displayDetails();
    }
}
import java.util.ArrayList;
import java.util.List;

public class Customer {
    protected String name;
    protected String email;
    protected List<Double> purchaseHistory;
    
    public Customer(String name, String email){
        this.name = name;
        this.email = email;
        purchaseHistory = new ArrayList<>();
    }
    
    public void addPurchase(double amount){ purchaseHistory.add(amount); }
    public double getTotalExpenditure(){
        double sum = 0;
        for(Double d: purchaseHistory) sum += d;
        return sum;
    }
    
    public String toString(){ return name + " (" + email + ")"; }
}

class LoyalCustomer extends Customer {
    private double discountRate;
    
    public LoyalCustomer(String name, String email, double discountRate){
        super(name, email);
        this.discountRate = discountRate;
    }
    
    public double applyDiscount(double amount){ return amount * (1 - discountRate); }
    
    public static void main(String[] args) {
        LoyalCustomer lc = new LoyalCustomer("Alice", "alice@example.com", 0.1);
        lc.addPurchase(100);
        lc.addPurchase(50);
        System.out.println("Total expenditure: " + lc.getTotalExpenditure());
        System.out.println("Discounted price for $200: " + lc.applyDiscount(200));
    }
}
public class Course {
    protected String courseName;
    protected String instructor;
    protected int credits;
    
    public Course(String courseName, String instructor, int credits){
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }
    
    public void displayDetails(){
        System.out.println(courseName + " by " + instructor + ", Credits: " + credits);
    }
}

class OnlineCourse extends Course {
    private String platform;
    private int duration; // in hours
    
    public OnlineCourse(String courseName, String instructor, int credits, String platform, int duration){
        super(courseName, instructor, credits);
        this.platform = platform;
        this.duration = duration;
    }
    
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Platform: " + platform + ", Duration: " + duration + " hours");
    }
    
    public boolean eligibleForCertificate(){ return duration >= 20; }
    
    public static void main(String[] args) {
        OnlineCourse oc = new OnlineCourse("Java Programming", "Mr. X", 3, "Udemy", 25);
        oc.displayDetails();
        System.out.println("Eligible for certificate: " + oc.eligibleForCertificate());
    }
}
public class ElectronicsProduct {
    protected String productId;
    protected String name;
    protected double price;
    
    public ElectronicsProduct(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public double applyDiscount(double discountPercentage){
        return price - (price * discountPercentage / 100);
    }
    
    public String toString(){
        return name + " (ID: " + productId + ") - Price: $" + price;
    }
}

class WashingMachine extends ElectronicsProduct {
    private int warrantyPeriod; // in months
    
    public WashingMachine(String productId, String name, double price, int warrantyPeriod){
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }
    
    public void extendWarranty(int extraMonths){ warrantyPeriod += extraMonths; }
    
    public String toString(){ return super.toString() + ", Warranty: " + warrantyPeriod + " months"; }
    
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine("WM01", "Super Washer", 300, 12);
        System.out.println(wm);
        wm.extendWarranty(6);
        System.out.println("After extending warranty: " + wm);
    }
}
public class Building {
    protected String address;
    protected int floors;
    protected double totalArea;
    
    public Building(String address, int floors, double totalArea){
        this.address = address;
        this.floors = floors;
        this.totalArea = totalArea;
    }
    
    public double calculateRent(){ return totalArea; } // Base rent calculation
}

class ResidentialBuilding extends Building {
    private int apartments;
    
    public ResidentialBuilding(String address, int floors, double totalArea, int apartments){
        super(address, floors, totalArea);
        this.apartments = apartments;
    }
    
    public double calculateRent(){ return super.calculateRent() / apartments; }
}

class CommercialBuilding extends Building {
    private double officeSpace;
    
    public CommercialBuilding(String address, int floors, double totalArea, double officeSpace){
        super(address, floors, totalArea);
        this.officeSpace = officeSpace;
    }
    
    public double calculateRent(){ return officeSpace * 2; } // Example multiplier
     
    public static void main(String[] args) {
        ResidentialBuilding res = new ResidentialBuilding("123 Main St", 5, 5000, 10);
        CommercialBuilding com = new CommercialBuilding("456 Market St", 8, 10000, 6000);
        System.out.println("Residential rent per apartment: $" + res.calculateRent());
        System.out.println("Commercial building rent: $" + com.calculateRent());
    }
}
public class Event {
    protected String eventName;
    protected String date;
    protected String location;
    
    public Event(String eventName, String date, String location){
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }
    
    public void displayDetails(){
        System.out.println(eventName + " on " + date + " at " + location);
    }
}

class Seminar extends Event {
    private int numberOfSpeakers;
    
    public Seminar(String eventName, String date, String location, int numberOfSpeakers){
        super(eventName, date, location);
        this.numberOfSpeakers = numberOfSpeakers;
    }
    
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Speakers: " + numberOfSpeakers);
    }
}

class MusicalPerformance extends Event {
    private String performerList;
    
    public MusicalPerformance(String eventName, String date, String location, String performerList){
        super(eventName, date, location);
        this.performerList = performerList;
    }
    
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Performers: " + performerList);
    }
    
    public static void main(String[] args) {
        Seminar sem = new Seminar("Tech Seminar", "2025-03-01", "Convention Center", 5);
        MusicalPerformance mp = new MusicalPerformance("Rock Concert", "2025-04-10", "Stadium", "Band A, Band B");
        sem.displayDetails();
        mp.displayDetails();
    }
}
import java.time.LocalDate;

public class CustomerOrder {
    protected String orderId;
    protected String customer;
    protected LocalDate orderDate;
    
    public CustomerOrder(String orderId, String customer, LocalDate orderDate){
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
    }
    
    public String toString(){
        return "Order " + orderId + " for " + customer + " on " + orderDate;
    }
}

class OnlineOrder extends CustomerOrder {
    private String deliveryAddress;
    private String trackingNumber;
    
    public OnlineOrder(String orderId, String customer, LocalDate orderDate, String deliveryAddress, String trackingNumber){
        super(orderId, customer, orderDate);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
    }
    
    public void updateTracking(String newTracking){ trackingNumber = newTracking; }
    
    public int calculateDeliveryTime(){ return 3; } // Dummy calculation: always 3 days
    
    public static void main(String[] args) {
        OnlineOrder order = new OnlineOrder("ORD123", "Alice", LocalDate.now(), "123 Street", "TRACK001");
        System.out.println(order);
        System.out.println("Estimated delivery: " + order.calculateDeliveryTime() + " days");
    }
}
public class Reservation {
    protected String reservationId;
    protected String customerName;
    protected String date;
    
    public Reservation(String reservationId, String customerName, String date){
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.date = date;
    }
    
    public String toString(){
        return "Reservation " + reservationId + " for " + customerName + " on " + date;
    }
}

class ResortReservation extends Reservation {
    private int roomNumber;
    
    public ResortReservation(String reservationId, String customerName, String date, int roomNumber){
        super(reservationId, customerName, date);
        this.roomNumber = roomNumber;
    }
    
    public void modifyReservation(int newRoomNumber){ roomNumber = newRoomNumber; }
    
    public String toString(){ return super.toString() + ", Room: " + roomNumber; }
}

class RailwayReservation extends Reservation {
    private String seatNumber;
    
    public RailwayReservation(String reservationId, String customerName, String date, String seatNumber){
        super(reservationId, customerName, date);
        this.seatNumber = seatNumber;
    }
    
    public void modifyReservation(String newSeatNumber){ seatNumber = newSeatNumber; }
    
    public String toString(){ return super.toString() + ", Seat: " + seatNumber; }
    
    public static void main(String[] args) {
        ResortReservation rr = new ResortReservation("R001", "Bob", "2025-05-01", 101);
        RailwayReservation railRes = new RailwayReservation("R002", "Carol", "2025-05-02", "A1");
        System.out.println(rr);
        System.out.println(railRes);
    }
}
public class Pet {
    protected String name;
    protected String species;
    protected int age;
    
    public Pet(String name, String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }
    
    public int calculateHumanYears(){ return age * 7; }
    
    public String toString(){ return name + " the " + species + ", Age: " + age; }
}

class DogPet extends Pet {
    private String favoriteToy;
    
    public DogPet(String name, int age, String favoriteToy){
        super(name, "Dog", age);
        this.favoriteToy = favoriteToy;
    }
    
    public String toString(){ return super.toString() + ", Favorite Toy: " + favoriteToy; }
}

class BirdPet extends Pet {
    private double wingSpan;
    
    public BirdPet(String name, int age, double wingSpan){
        super(name, "Bird", age);
        this.wingSpan = wingSpan;
    }
    
    public String toString(){ return super.toString() + ", Wing Span: " + wingSpan; }
    
    public static void main(String[] args) {
        DogPet dog = new DogPet("Buddy", 3, "Ball");
        BirdPet bird = new BirdPet("Tweety", 2, 0.5);
        System.out.println(dog);
        System.out.println("Human years: " + dog.calculateHumanYears());
        System.out.println(bird);
        System.out.println("Human years: " + bird.calculateHumanYears());
    }
}
public class GymMembership {
    protected String memberName;
    protected String membershipType;
    protected int duration; // in months
    
    public GymMembership(String memberName, String membershipType, int duration){
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.duration = duration;
    }
    
    public double calculateFees(){
        double baseRate = "Premium".equalsIgnoreCase(membershipType) ? 50 : 30;
        return baseRate * duration;
    }
    
    public String toString(){
        return memberName + " - " + membershipType + " membership for " + duration + " months.";
    }
}

class PremiumMembership extends GymMembership {
    private boolean personalTrainer;
    private boolean spaAccess;
    
    public PremiumMembership(String memberName, int duration, boolean personalTrainer, boolean spaAccess){
        super(memberName, "Premium", duration);
        this.personalTrainer = personalTrainer;
        this.spaAccess = spaAccess;
    }
    
    public double calculateFees(){
        double fees = super.calculateFees();
        if(personalTrainer) fees += 100;
        if(spaAccess) fees += 50;
        return fees;
    }
    
    public boolean checkSpecialOffers(){ return duration > 12; }
    
    public static void main(String[] args) {
        PremiumMembership pm = new PremiumMembership("Alice", 14, true, false);
        System.out.println(pm);
        System.out.println("Total fees: $" + pm.calculateFees());
        System.out.println("Special offers available: " + pm.checkSpecialOffers());
    }
}
    
}
