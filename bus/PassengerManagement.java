public interface PassengerManagement {
    /**
     * Books a ticket for the given passenger.
     * Validates seat availability and input details.
     * @param passenger Passenger details to book.
     * @return true if booking is successful, false otherwise.
     */
    boolean bookTicket(Passenger passenger);

    /**
     * Calculates the fare based on the distance.
     * @param distance distance to travel in km.
     * @param isDiscounted true if discount is applicable.
     * @return calculated fare.
     */
    double calculateFare(double distance, boolean isDiscounted);

    /**
     * Tracks the bus based on its number.
     * @param busNumber the bus number.
     */
    void trackBus(String busNumber);
}

