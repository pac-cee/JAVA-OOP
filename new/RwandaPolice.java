// Abstract class TrafficRecord
abstract class TrafficRecord {
    protected String driverId;
    protected String driverName;
    protected String vehiclePlate;
    protected String violationType;
    protected double fineAmount;
    protected String paymentStatus;
    
    // Abstract methods
    public abstract boolean recordViolation();
    public abstract boolean assessFine();
    public abstract boolean processPayment();
    
    // Constructor
    public TrafficRecord(String driverId, String driverName, String vehiclePlate, String violationType, 
                         double fineAmount, String paymentStatus) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }
    
    // Getters and Setters
    public String getDriverId() {
        return driverId;
    }
    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
    
    public String getViolationType() {
        return violationType;
    }
    
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }
    
    public double getFineAmount() {
        return fineAmount;
    }
    
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    // Helper method to validate driver ID (16 digits)
    protected boolean validateDriverId() {
        return driverId != null && driverId.matches("\\d{16}");
    }
    
    // Helper method to validate vehicle plate (format RAB123D)
    protected boolean validateVehiclePlate() {
        return vehiclePlate != null && vehiclePlate.matches("[A-Z]{3}\\d{3}[A-Z]");
    }
    
    // Helper method to validate violation type
    protected boolean validateViolationType() {
        String[] validTypes = {"SPEEDING", "RED_LIGHT", "NO_HELMET", "DUI"};
        for (String type : validTypes) {
            if (type.equalsIgnoreCase(violationType)) {
                return true;
            }
        }
        return false;
    }
}

// ViolationEntry class
class ViolationEntry extends TrafficRecord {
    
    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType, 
                         double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }
    
    @Override
    public boolean recordViolation() {
        // Validate driver ID
        if (!validateDriverId()) {
            System.out.println("ERROR: Invalid driver ID. Must be exactly 16 digits.");
            return false;
        }
        
        // Validate vehicle plate
        if (!validateVehiclePlate()) {
            System.out.println("ERROR: Invalid vehicle plate. Must follow format (e.g., RAB123D).");
            return false;
        }
        
        // Validate violation type
        if (!validateViolationType()) {
            System.out.println("ERROR: Invalid violation type. Must be one of: SPEEDING, RED_LIGHT, NO_HELMET, DUI.");
            return false;
        }
        
        // Set payment status to UNPAID
        paymentStatus = "UNPAID";
        
        // Display confirmation
        System.out.println("\n=== VIOLATION RECORDED ===");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Payment Status: " + paymentStatus);
        
        return true;
    }
    
    @Override
    public boolean assessFine() {
        // Not implemented for ViolationEntry
        System.out.println("Fine assessment not applicable for violation entry.");
        return false;
    }
    
    @Override
    public boolean processPayment() {
        // Not implemented for ViolationEntry
        System.out.println("Payment processing not applicable for violation entry.");
        return false;
    }
}

// FineAssessment class
class FineAssessment extends TrafficRecord {
    
    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType, 
                         double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }
    
    @Override
    public boolean recordViolation() {
        // Not implemented for FineAssessment
        System.out.println("Violation recording not applicable for fine assessment.");
        return false;
    }
    
    @Override
    public boolean assessFine() {
        // Validate violation type
        if (!validateViolationType()) {
            System.out.println("ERROR: Invalid violation type. Cannot assess fine.");
            return false;
        }
        
        // Determine fine amount based on violation type
        switch (violationType.toUpperCase()) {
            case "SPEEDING":
                fineAmount = 50000;
                break;
            case "RED_LIGHT":
                fineAmount = 80000;
                break;
            case "NO_HELMET":
                fineAmount = 30000;
                break;
            case "DUI":
                fineAmount = 150000;
                break;
            default:
                System.out.println("ERROR: Unrecognized violation type.");
                return false;
        }
        
        // Display fine information
        System.out.println("\n=== FINE ASSESSMENT ===");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Fine Amount: " + String.format("%,.0f", fineAmount) + " RWF");
        System.out.println("Payment Status: " + paymentStatus);
        
        return true;
    }
    
    @Override
    public boolean processPayment() {
        // Not implemented for FineAssessment
        System.out.println("Payment processing not applicable for fine assessment.");
        return false;
    }
}

// FinePayment class
class FinePayment extends TrafficRecord {
    
    public FinePayment(String driverId, String driverName, String vehiclePlate, String violationType, 
                         double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }
    
    @Override
    public boolean recordViolation() {
        // Not implemented for FinePayment
        System.out.println("Violation recording not applicable for payment processing.");
        return false;
    }
    
    @Override
    public boolean assessFine() {
        // Not implemented for FinePayment
        System.out.println("Fine assessment not applicable for payment processing.");
        return false;
    }
    
    @Override
    public boolean processPayment() {
        // Check if fine is already paid
        if (paymentStatus.equalsIgnoreCase("PAID")) {
            System.out.println("ERROR: This fine has already been paid.");
            return false;
        }
        
        // Process payment
        paymentStatus = "PAID";
        
        // Display receipt
        System.out.println("\n=== PAYMENT RECEIPT ===");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Amount Paid: " + String.format("%,.0f", fineAmount) + " RWF");
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Payment successful!");
        
        return true;
    }
}

// Main class for the Traffic Fine Management System
public class RwandaPolice {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        try {
            System.out.println("=== RWANDA NATIONAL POLICE - Traffic Fine Management System ===");
            
            // Get driver information
            System.out.print("Enter Driver ID (16 digits): ");
            String driverId = scanner.nextLine();
            
            System.out
