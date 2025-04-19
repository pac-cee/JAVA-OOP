package Assignment1Solution.Exercise2_OnlineShopping;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesItem extends ShoppingItem {
    private final List<String> varieties;
    private final List<String> reviews;
    private final List<Integer> ratings;

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, List<String> varieties) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.varieties = varieties;
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public void addReview(String review, int rating) {
        reviews.add(review);
        ratings.add(rating);
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
        if (varieties == null || varieties.isEmpty()) {
            System.out.println("At least one variety must be available.");
            valid = false;
        }
        return valid;
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.size();
    }

    // Getters and setters (if needed)
}
