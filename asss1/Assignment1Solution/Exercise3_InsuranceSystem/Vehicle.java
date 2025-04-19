package Assignment1Solution.Exercise3_InsuranceSystem;

public class Vehicle {
    private final String vehicleId;
    private final String vehicleMake;
    private final String vehicleModel;
    private final int vehicleYear;
    private final String vehicleType;

    public Vehicle(String vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleType = vehicleType;
    }

    public boolean validateVehicle() {
        boolean valid = true;
        if (vehicleMake == null || vehicleMake.isEmpty()) {
            System.out.println("Vehicle make cannot be empty.");
            valid = false;
        }
        if (vehicleModel == null || vehicleModel.isEmpty()) {
            System.out.println("Vehicle model cannot be empty.");
            valid = false;
        }
        if (vehicleYear < 1980 || vehicleYear > java.time.LocalDate.now().getYear()) {
            System.out.println("Vehicle year must be between 1980 and current year.");
            valid = false;
        }
        if (vehicleType == null || vehicleType.isEmpty()) {
            System.out.println("Vehicle type cannot be empty.");
            valid = false;
        }
        return valid;
    }
    public String getVehicleId() { return vehicleId; }
    public int getVehicleYear() { return vehicleYear; }
    public String getVehicleModel() { return vehicleModel; }
    // Getters for other fields can be added as needed
}
