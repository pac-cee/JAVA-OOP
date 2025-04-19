package Assignment1Solution.Exercise2_OnlineShopping;

public class ElectronicsItem extends ShoppingItem {
    private final int warrantyMonths;
    // private final boolean registered; // Not used, so commented out

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyMonths, boolean registered) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyMonths = warrantyMonths;
        // this.registered = registered; // Not used, so commented out
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
        if (warrantyMonths < 0 || warrantyMonths > 36) {
            System.out.println("Warranty period must be between 0 and 36 months.");
            valid = false;
        }
        return valid;
    }

    // Getters and setters (if needed)
}
