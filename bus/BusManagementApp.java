
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BusManagementApp {
    // List to store passenger bookings
    private static List<Passenger> passengerList = new ArrayList<>();

    // Instances of our implementations
    private static Reservation reservation = new Reservation();
    private static Ticketing ticketing = new Ticketing();
    private static BusTracking busTracking = new BusTracking();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exitApp = false;
            
            while (!exitApp) {
                displayMenu();
                int choice = 0;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1 -> bookTicket(scanner);
                    case 2 -> calculateFare(scanner);
                    case 3 -> trackBus(scanner);
                    case 4 -> displayBookings();
                    case 5 -> {
                        System.out.println("Exiting application.");
                        exitApp = true;
                    }
                    default -> System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Bus Passenger Management System =====");
        System.out.println("1. Book Ticket");
        System.out.println("2. Calculate Fare");
        System.out.println("3. Track Bus");
        System.out.println("4. Display Bookings");
        System.out.println("5. Exit");
    }

    private static void bookTicket(Scanner scanner) {
        try {
            System.out.print("Enter Passenger ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // clear newline
            
            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Passenger Age (>= 6): ");
            int age = scanner.nextInt();
            scanner.nextLine(); // clear newline
            
            System.out.print("Enter Ticket Number (integer): ");
            int ticketNumber = scanner.nextInt();
            scanner.nextLine(); // clear newline
            
            System.out.print("Enter Seat Number (1-50): ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine(); // clear newline
            
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            
            System.out.print("Enter Distance (in km): ");
            double distance = scanner.nextDouble();
            scanner.nextLine(); // clear newline
            
            System.out.print("Enter Bus Plate Number: ");
            String plateNumber = scanner.nextLine();

            // Create a new passenger object
            Passenger passenger = new Passenger(id, name, age, ticketNumber, seatNumber, destination, distance, plateNumber);
            // Attempt booking
            boolean booked = reservation.bookTicket(passenger);
            if (booked) {
                // Calculate fare. Check discount eligibility (age >= 60 assumed as discount; you may modify this logic for students)
                boolean discountEligible = age >= 60;
                double fare = ticketing.calculateFare(distance, discountEligible);
                System.out.println("Calculated Fare: " + fare);
                passengerList.add(passenger);
            }
        } catch (InputMismatchException ime) {
            System.out.println("Input error: Please ensure you enter the correct data type.");
            scanner.nextLine(); // clear the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred during booking: " + e.getMessage());
        }
    }

    private static void calculateFare(Scanner scanner) {
        try {
            System.out.print("Enter distance (in km): ");
            double distance = scanner.nextDouble();
            scanner.nextLine(); // clear newline
            System.out.print("Is discount applicable? (yes/no): ");
            String discountInput = scanner.nextLine().trim().toLowerCase();
            boolean isDiscounted = discountInput.equals("yes") || discountInput.equals("y");
            
            double fare = ticketing.calculateFare(distance, isDiscounted);
            System.out.println("Calculated Fare: " + fare);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a numeric value for distance.");
            scanner.nextLine();
        }
    }

    private static void trackBus(Scanner scanner) {
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine();
        busTracking.trackBus(busNumber);
    }

    private static void displayBookings() {
        if (passengerList.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("\n===== Passenger Bookings =====");
            for (Passenger passenger : passengerList) {
                System.out.println(passenger);
                // Calculate fare for display purposes
                boolean discountEligible = passenger.getAge() >= 60;
                double fare = ticketing.calculateFare(passenger.getDistance(), discountEligible);
                System.out.println("Amount to Pay: " + fare);
                System.out.println("------------------------------");
            }
            // Also display booked seats from reservation
            reservation.displayBookedSeats();
        }
    }
}

