public class BusTracking implements PassengerManagement {
    @Override
    public boolean bookTicket(Passenger passenger) {
        // This class does not handle booking.
        return false;
    }

    @Override
    public double calculateFare(double distance, boolean isDiscounted) {
        // This class does not handle fare calculation.
        return 0;
    }

    @Override
    public void trackBus(String busNumber) {
        // For demonstration, we simulate bus tracking.
        System.out.println("Tracking bus " + busNumber + "...");
        System.out.println("Bus " + busNumber + " is currently en route. Estimated arrival time: 15 minutes.");
    }
}

