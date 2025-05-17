// Abstract class HotelService
abstract class HotelService {
    protected String guestId;
    protected String guestName;
    protected String roomType;
    protected int stayDays;
    protected String roomStatus;
    
    // Abstract methods
    public abstract boolean bookRoom();
    public abstract boolean checkoutGuest();
    public abstract void generateBill();
    
    // Constructor
    public HotelService(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.stayDays = stayDays;
        this.roomStatus = roomStatus;
    }
    
    // Getters and Setters
    public String getGuestId() {
        return guestId;
    }
    
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }
    
    public String getGuestName() {
        return guestName;
    }
    
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public int getStayDays() {
        return stayDays;
    }
    
    public void setStayDays(int stayDays) {
        this.stayDays = stayDays;
    }
    
    public String getRoomStatus() {
        return roomStatus;
    }
    
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}

// RoomBooking class
class RoomBooking extends HotelService {
    
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }
    
    @Override
    public boolean bookRoom() {
        // Validate stay days (1-30)
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("ERROR: Booking rejected. Stay duration must be between 1 and 30 days.");
            return false;
        }
        
        // Validate room status
        if (!roomStatus.equalsIgnoreCase("AVAILABLE")) {
            System.out.println("ERROR: Room is not available for booking.");
            return false;
        }
        
        // Validate room type
        if (!isValidRoomType()) {
            System.out.println("ERROR: Invalid room type. Must be STANDARD, DELUXE, or SUITE.");
            return false;
        }
        
        // Process booking
        roomStatus = "OCCUPIED";
        System.out.println("\n=== BOOKING CONFIRMATION ===");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " days");
        System.out.println("Room Status: " + roomStatus);
        System.out.println("Booking successful!");
        
        return true;
    }
    
    @Override
    public boolean checkoutGuest() {
        // Not implemented for RoomBooking
        System.out.println("Checkout operation not applicable for booking.");
        return false;
    }
    
    @Override
    public void generateBill() {
        // Not implemented for RoomBooking
        System.out.println("Bill generation not applicable for booking.");
    }
    
    // Helper method to validate room type
    private boolean isValidRoomType() {
        return roomType.equalsIgnoreCase("STANDARD") || 
               roomType.equalsIgnoreCase("DELUXE") || 
               roomType.equalsIgnoreCase("SUITE");
    }
}

// GuestCheckout class
class GuestCheckout extends HotelService {
    
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }
    
    @Override
    public boolean bookRoom() {
        // Not implemented for GuestCheckout
        System.out.println("Booking operation not applicable for checkout.");
        return false;
    }
    
    @Override
    public boolean checkoutGuest() {
        // Validate room status
        if (!roomStatus.equalsIgnoreCase("OCCUPIED")) {
            System.out.println("ERROR: Cannot checkout. Room is already available.");
            return false;
        }
        
        // Process checkout
        roomStatus = "AVAILABLE";
        System.out.println("\n=== CHECKOUT CONFIRMATION ===");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stayed for: " + stayDays + " days");
        System.out.println("Room Status: " + roomStatus);
        System.out.println("Checkout successful!");
        
        return true;
    }
    
    @Override
    public void generateBill() {
        // Not implemented for GuestCheckout
        System.out.println("Bill generation not applicable for checkout.");
    }
}

// Billing class
class Billing extends HotelService {
    
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }
    
    @Override
    public boolean bookRoom() {
        // Not implemented for Billing
        System.out.println("Booking operation not applicable for billing.");
        return false;
    }
    
    @Override
    public boolean checkoutGuest() {
        // Not implemented for Billing
        System.out.println("Checkout operation not applicable for billing.");
        return false;
    }
    
    @Override
    public void generateBill() {
        // Calculate cost based on room type and stay days
        int costPerNight;
        
        // Determine cost per night based on room type
        switch (roomType.toUpperCase()) {
            case "STANDARD":
                costPerNight = 50000;
                break;
            case "DELUXE":
                costPerNight = 80000;
                break;
            case "SUITE":
                costPerNight = 120000;
                break;
            default:
                System.out.println("ERROR: Invalid room type for billing.");
                return;
        }
        
        int totalCost = costPerNight * stayDays;
        
        // Display bill information
        System.out.println("\n=== BILL INFORMATION ===");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " days");
        System.out.println("Cost per Night: " + String.format("%,d", costPerNight) + " RWF");
        System.out.println("Total Cost: " + String.format("%,d", totalCost) + " RWF");
    }
}

// Main class for the Hotel Management System
public class LemigoHotel {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        try {
            System.out.println("=== LEMIGO HOTEL - Hotel Management System ===");
            
            // Get guest information
            System.out.print("Enter Guest ID: ");
            String guestId = scanner.nextLine();
            
            // Validate guest ID (assuming it should not be empty)
            if (guestId.trim().isEmpty()) {
                System.out.println("ERROR: Guest ID cannot be empty.");
                return;
            }
            
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();
            
            // Validate guest name (assuming it should not be empty)
            if (guestName.trim().isEmpty()) {
                System.out.println("ERROR: Guest Name cannot be empty.");
                return;
            }
            
            // Get room type
            System.out.println("Select Room Type:");
            System.out.println("1. STANDARD");
            System.out.println("2. DELUXE");
            System.out.println("3. SUITE");
            System.out.print("Enter choice (1-3): ");
            int roomChoice = scanner.nextInt();
            
            String roomType;
            switch (roomChoice) {
                case 1:
                    roomType = "STANDARD";
                    break;
                case 2:
                    roomType = "DELUXE";
                    break;
                case 3:
                    roomType = "SUITE";
                    break;
                default:
                    System.out.println("ERROR: Invalid room type selection.");
                    return;
            }
            
            // Get stay duration
            System.out.print("Enter Stay Duration (days): ");
            int stayDays = scanner.nextInt();
            
            // Initial room status (assuming new guests are trying to book available rooms)
            String roomStatus = "AVAILABLE";
            
            int choice;
            do {
                // Display menu
                System.out.println("\nChoose an operation:");
                System.out.println("1. Book Room");
                System.out.println("2. Checkout Guest");
                System.out.println("3. Generate Bill");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        // Room Booking
                        RoomBooking booking = new RoomBooking(guestId, guestName, roomType, stayDays, roomStatus);
                        if (booking.bookRoom()) {
                            roomStatus = booking.getRoomStatus(); // Update status for next operations
                        }
                        break;
                        
                    case 2:
                        // Guest Checkout
                        GuestCheckout checkout = new GuestCheckout(guestId, guestName, roomType, stayDays, roomStatus);
                        if (checkout.checkoutGuest()) {
                            roomStatus = checkout.getRoomStatus(); // Update status for next operations
                        }
                        break;
                        
                    case 3:
                        // Billing
                        Billing billing = new Billing(guestId, guestName, roomType, stayDays, roomStatus);
                        billing.generateBill();
                        break;
                        
                    case 0:
                        System.out.println("Exiting the program...");
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
            
        } finally {
            scanner.close();
        }
    }
}
