public class Ticketing implements PassengerManagement {
    private static final double RATE_PER_KM = 200_000; // 200k per km

    @Override
    public boolean bookTicket(Passenger passenger) {
        // This class does not handle booking.
        return false;
    }

    @Override
    public double calculateFare(double distance, boolean isDiscounted) {
        double fare = distance * RATE_PER_KM;
        if (isDiscounted) {
            fare *= 0.8; // apply 20% discount
        }
        return fare;
    }

    @Override
    public void trackBus(String busNumber) {
        // Delegated to BusTracking class (see below)
    }
}

