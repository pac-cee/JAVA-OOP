// Abstract class ConstructionMaterial
abstract class ConstructionMaterial {
    protected String contractorId;
    protected String contractorName;
    protected double materialQuantity;
    protected double materialBalance;
    
    // Abstract methods
    public abstract boolean receiveMaterial();
    public abstract boolean useMaterial();
    public abstract void estimateCost();
    
    // Constructor
    public ConstructionMaterial(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.materialQuantity = materialQuantity;
        this.materialBalance = materialBalance;
    }
    
    // Getters and Setters
    public String getContractorId() {
        return contractorId;
    }
    
    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }
    
    public String getContractorName() {
        return contractorName;
    }
    
    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }
    
    public double getMaterialQuantity() {
        return materialQuantity;
    }
    
    public void setMaterialQuantity(double materialQuantity) {
        this.materialQuantity = materialQuantity;
    }
    
    public double getMaterialBalance() {
        return materialBalance;
    }
    
    public void setMaterialBalance(double materialBalance) {
        this.materialBalance = materialBalance;
    }
}

// MaterialDelivery class
class MaterialDelivery extends ConstructionMaterial {
    
    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }
    
    @Override
    public boolean receiveMaterial() {
        // Validate material quantity between 1 and 10 tons
        if (materialQuantity >= 1 && materialQuantity <= 10) {
            // Update material balance
            materialBalance += materialQuantity;
            System.out.println("Material delivery accepted. New balance: " + materialBalance + " tons");
            return true;
        } else {
            System.out.println("ERROR: Material delivery rejected. Quantity must be between 1 and 10 tons.");
            return false;
        }
    }
    
    @Override
    public boolean useMaterial() {
        // This method is implemented but not used in MaterialDelivery
        System.out.println("Use material operation not applicable for delivery.");
        return false;
    }
    
    @Override
    public void estimateCost() {
        // This method is implemented but not used in MaterialDelivery
        System.out.println("Cost estimation not applicable for delivery.");
    }
}

// MaterialUsage class
class MaterialUsage extends ConstructionMaterial {
    
    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }
    
    @Override
    public boolean receiveMaterial() {
        // This method is implemented but not used in MaterialUsage
        System.out.println("Receive material operation not applicable for usage.");
        return false;
    }
    
    @Override
    public boolean useMaterial() {
        // Check if after usage, material balance remains ≥ 2 tons
        if (materialBalance - materialQuantity >= 2) {
            materialBalance -= materialQuantity;
            System.out.println("Material used successfully. Remaining balance: " + materialBalance + " tons");
            return true;
        } else {
            System.out.println("ERROR: Insufficient material. Balance must remain at least 2 tons after usage.");
            return false;
        }
    }
    
    @Override
    public void estimateCost() {
        // This method is implemented but not used in MaterialUsage
        System.out.println("Cost estimation not applicable for usage.");
    }
}

// CostEstimation class
class CostEstimation extends ConstructionMaterial {
    
    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }
    
    @Override
    public boolean receiveMaterial() {
        // This method is implemented but not used in CostEstimation
        System.out.println("Receive material operation not applicable for cost estimation.");
        return false;
    }
    
    @Override
    public boolean useMaterial() {
        // This method is implemented but not used in CostEstimation
        System.out.println("Use material operation not applicable for cost estimation.");
        return false;
    }
    
    @Override
    public void estimateCost() {
        double costPerTon;
        double totalCost;
        
        // Determine cost per ton based on quantity
        if (materialQuantity >= 5 && materialQuantity <= 15) {
            costPerTon = 200000;
        } else if (materialQuantity > 15) {
            costPerTon = 180000;
        } else {
            costPerTon = 200000; // Default cost for less than 5 tons
        }
        
        totalCost = materialQuantity * costPerTon;
        
        // Display cost information
        System.out.println("\n=== COST ESTIMATION ===");
        System.out.println("Contractor ID: " + contractorId);
        System.out.println("Contractor Name: " + contractorName);
        System.out.println("Material Quantity Used: " + materialQuantity + " tons");
        System.out.println("Cost per Ton: " + String.format("%,.0f", costPerTon) + " RWF");
        System.out.println("Total Cost: " + String.format("%,.0f", totalCost) + " RWF");
    }
}

// Main class named Constructor as specified in the requirements
public class Constructor {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        try {
            System.out.println("=== REAL CONSTRUCTOR - Site Construction Management System ===");
            
            // Get contractor information
            System.out.print("Enter Contractor ID: ");
            String contractorId = scanner.nextLine();
            
            // Validate contractor ID (assuming it should not be empty)
            if (contractorId.trim().isEmpty()) {
                System.out.println("ERROR: Contractor ID cannot be empty.");
                return;
            }
            
            System.out.print("Enter Contractor Name: ");
            String contractorName = scanner.nextLine();
            
            // Validate contractor name (assuming it should not be empty)
            if (contractorName.trim().isEmpty()) {
                System.out.println("ERROR: Contractor Name cannot be empty.");
                return;
            }
            
            // Get current material balance
            System.out.print("Enter Current Material Balance (tons): ");
            double materialBalance = scanner.nextDouble();
            
            // Validate material balance (assuming it should be non-negative)
            if (materialBalance < 0) {
                System.out.println("ERROR: Material balance cannot be negative.");
                return;
            }
            
            int choice;
            do {
                // Display menu
                System.out.println("\nChoose an operation:");
                System.out.println("1. Receive Material");
                System.out.println("2. Use Material");
                System.out.println("3. Estimate Cost");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        // Material Delivery
                        System.out.print("Enter Material Quantity to Deliver (tons): ");
                        double deliveryQuantity = scanner.nextDouble();
                        
                        MaterialDelivery delivery = new MaterialDelivery(
                            contractorId, contractorName, deliveryQuantity, materialBalance);
                        
                        if (delivery.receiveMaterial()) {
                            materialBalance = delivery.getMaterialBalance(); // Update balance for next operations
                        }
                        break;
                        
                    case 2:
                        // Material Usage
                        System.out.print("Enter Material Quantity to Use (tons): ");
                        double usageQuantity = scanner.nextDouble();
                        
                        MaterialUsage usage = new MaterialUsage(
                            contractorId, contractorName, usageQuantity, materialBalance);
                        
                        if (usage.useMaterial()) {
                            materialBalance = usage.getMaterialBalance(); // Update balance for next operations
                        }
                        break;
                        
                    case 3:
                        // Cost Estimation
                        System.out.print("Enter Material Quantity for Cost Estimation (tons): ");
                        double estimationQuantity = scanner.nextDouble();
                        
                        CostEstimation estimation = new CostEstimation(
                            contractorId, contractorName, estimationQuantity, materialBalance);
                        
                        estimation.estimateCost();
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
