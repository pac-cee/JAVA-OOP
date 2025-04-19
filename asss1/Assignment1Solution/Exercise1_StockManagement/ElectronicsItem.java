package Assignment1Solution.Exercise1_StockManagement;

public class ElectronicsItem extends StockItem {
    private final int warrantyPeriodMonths;
    private final double discountPercent;

    public ElectronicsItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, int warrantyPeriodMonths, double discountPercent) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
        this.discountPercent = discountPercent;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit * (1 - discountPercent / 100.0);
    }

    @Override
    public void generateStockReport() {
        System.out.println("[ElectronicsItem] " + itemName + " | Stock: " + quantityInStock + " | Price: " + pricePerUnit + " | Discount: " + discountPercent + "% | Warranty: " + warrantyPeriodMonths + " months");
    }

    @Override
    public boolean validateStock() {
        boolean valid = true;
        if (quantityInStock < 0) {
            System.out.println("Quantity cannot be negative.");
            valid = false;
        }
        if (pricePerUnit <= 0) {
            System.out.println("Price per unit must be above zero.");
            valid = false;
        }
        if (discountPercent < 0 || discountPercent > 50) {
            System.out.println("Discount must be between 0% and 50%.");
            valid = false;
        }
        if (warrantyPeriodMonths < 0 || warrantyPeriodMonths > 36) {
            System.out.println("Warranty period must be between 0 and 36 months.");
            valid = false;
        }
        return valid;
    }
}
