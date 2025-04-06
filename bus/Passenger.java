public class Passenger {
    private int id;
    private String name;
    private int age;
    private int ticketNumber;
    private int seatNumber;
    private String destination;
    private double distance;
    private String plateNumber;

    public Passenger(int id, String name, int age, int ticketNumber, int seatNumber, String destination, double distance, String plateNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.destination = destination;
        this.distance = distance;
        this.plateNumber = plateNumber;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getTicketNumber() {
        return ticketNumber;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public String getDestination() {
        return destination;
    }
    public double getDistance() {
        return distance;
    }
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + id +
               "\nName: " + name +
               "\nAge: " + age +
               "\nTicket Number: " + ticketNumber +
               "\nSeat Number: " + seatNumber +
               "\nDestination: " + destination +
               "\nDistance: " + distance + " km" +
               "\nBus Plate Number: " + plateNumber;
    }
}
