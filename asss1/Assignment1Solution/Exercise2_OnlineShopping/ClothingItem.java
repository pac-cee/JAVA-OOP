package Assignment1Solution.Exercise2_OnlineShopping;

import java.util.Set;

public class ClothingItem extends ShoppingItem {
    private final Set<String> availableSizes;
    private final double seasonalDiscount;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, Set<String> availableSizes, double seasonalDiscount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.availableSizes = availableSizes;
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public void updateStock(int quantity) {
        this.stockAvailable += quantity;
    }

    @Override
    public boolean addToCart(Customer customer, int quantity) {
        if (quantity > stockAvailable) {
            System.out.println("Not enough stock for " + itemName);
            return false;
        }
        stockAvailable -= quantity;
        return true;
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + quantity + " x " + itemName + " (" + price + ") for " + customer.getCustomerName());
    }

    @Override
    public boolean validateItem() {
        boolean valid = true;
        if (stockAvailable < 0) {
            System.out.println("Stock cannot be negative.");
            valid = false;
        }
        if (price <= 0) {
            System.out.println("Price must be above zero.");
            valid = false;
        }
        if (seasonalDiscount < 0 || seasonalDiscount > 50) {
            System.out.println("Seasonal discount must be between 0% and 50%.");
            valid = false;
        }
        if (availableSizes == null || availableSizes.isEmpty()) {
            System.out.println("At least one size must be available.");
            valid = false;
        }
        return valid;
    }

    // Getters and setters (if needed)
}
