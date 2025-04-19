package Assignment1Solution.Exercise1_StockManagement;

public class FurnitureItem extends StockItem {
    private final double weight;
    private final boolean wellPacked;

    public FurnitureItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, double weight, boolean wellPacked) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.weight = weight;
        this.wellPacked = wellPacked;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("[FurnitureItem] " + itemName + " | Stock: " + quantityInStock + " | Price: " + pricePerUnit + " | Weight: " + weight + "kg | Well Packed: " + (wellPacked ? "Yes" : "No"));
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
        if (weight <= 0) {
            System.out.println("Weight must be above zero.");
            valid = false;
        }
        if (!wellPacked) {
            System.out.println("Furniture item must be well packed before delivery.");
            valid = false;
        }
        return valid;
    }
}
