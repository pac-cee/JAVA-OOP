package Assignment1Solution.Exercise2_OnlineShopping;

import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private final LocalDate expirationDate;
    private final double bulkDiscount;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate, double bulkDiscount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
        this.bulkDiscount = bulkDiscount;
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
        if (bulkDiscount < 0 || bulkDiscount > 50) {
            System.out.println("Bulk discount must be between 0% and 50%.");
            valid = false;
        }
        if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("Product is expired!");
            valid = false;
        }
        return valid;
    }

    // Getters and setters (if needed)
}
