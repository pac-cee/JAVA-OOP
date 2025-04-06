import java.util.HashSet;
import java.util.Set;

public class Reservation implements PassengerManagement {
    private static final int MAX_SEATS = 50;
    // To ensure unique seat allocation, we use a Set.
    private Set<Integer> bookedSeats = new HashSet<>();

    @Override
    public boolean bookTicket(Passenger passenger) {
        // Validate age requirement: passengers below 6 are not allowed to travel alone.
        if (passenger.getAge() < 6) {
            System.out.println("Error: Passenger must be at least 6 years old to travel.");
            return false;
        }
        // Check seating capacity
        if (bookedSeats.size() >= MAX_SEATS) {
            System.out.println("Error: Bus is fully booked.");
            return false;
        }
        // Check if seat is already booked
        if (bookedSeats.contains(passenger.getSeatNumber())) {
            System.out.println("Error: Seat " + passenger.getSeatNumber() + " is already taken.");
            return false;
        }
        // If all validations pass, add the seat.
        bookedSeats.add(passenger.getSeatNumber());
        System.out.println("Booking confirmed for passenger " + passenger.getName() + " in seat " + passenger.getSeatNumber());
        return true;
    }

    @Override
    public double calculateFare(double distance, boolean isDiscounted) {
        // Delegated to Ticketing class (see below)
        return 0; // not used here
    }

    @Override
    public void trackBus(String busNumber) {
        // Delegated to BusTracking class (see below)
    }
    
    // Optionally, you can add a method to display booked seats.
    public void displayBookedSeats() {
        System.out.println("Currently booked seats: " + bookedSeats);
    }
}

