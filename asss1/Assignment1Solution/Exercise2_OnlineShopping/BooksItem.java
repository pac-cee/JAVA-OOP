package Assignment1Solution.Exercise2_OnlineShopping;

public class BooksItem extends ShoppingItem {
    private final String isbn;
    private final String edition;
    private final String printQuality;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition, String printQuality) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
        this.printQuality = printQuality;
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
        if (isbn == null || isbn.isEmpty()) {
            System.out.println("ISBN must be provided.");
            valid = false;
        }
        if (edition == null || edition.isEmpty()) {
            System.out.println("Edition must be provided.");
            valid = false;
        }
        if (printQuality == null || printQuality.isEmpty()) {
            System.out.println("Print quality must be specified.");
            valid = false;
        }
        return valid;
    }

    // Getters and setters (if needed)
}
