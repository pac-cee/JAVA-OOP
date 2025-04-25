import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

abstract class ShoppingItem {
    protected String itemId;
    protected String itemName;
    protected String itemDescription;
    protected double price;
    protected int stockAvailable;

    public ShoppingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
        this.stockAvailable = stockAvailable;
    }

    public abstract void updateStock(int quantity);
    public abstract boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc);
    public abstract void generateInvoice(Customer customer, int quantity);
    public abstract boolean validateItem();
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getStockAvailable() { return stockAvailable; }
}

class ElectronicsItem extends ShoppingItem {
    private int warrantyMonths;
    private boolean registered;

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyMonths) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyMonths = warrantyMonths;
        this.registered = false;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc) {
        if (validateItem() && quantity <= stockAvailable) {
            cart.addItem(this, quantity);
            System.out.println(quantity + " x " + itemName + " added to cart.");
            return true;
        } else {
            System.out.println("Insufficient stock or invalid item.");
            return false;
        }
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + itemName + " x " + quantity + " | Price: " + price + " | Warranty: " + warrantyMonths + " months");
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && price > 0;
    }

    public void registerProduct() {
        registered = true;
        System.out.println(itemName + " registered for warranty.");
    }
}

class ClothingItem extends ShoppingItem {
    private Map<String, Integer> sizeStock;
    private boolean seasonal;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, Map<String, Integer> sizeStock, boolean seasonal) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.sizeStock = sizeStock;
        this.seasonal = seasonal;
    }

    @Override
    public void updateStock(int quantity) {
        // Not used directly; handled per size
    }

    public boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc) {
        System.out.print("Enter size (S/M/L/XL): ");
        String size = sc.next();
        if (!sizeStock.containsKey(size) || sizeStock.get(size) < quantity) {
            System.out.println("Insufficient stock for size " + size);
            return false;
        }
        double finalPrice = price;
        if (seasonal) {
            finalPrice *= 0.9; // 10% discount
            System.out.println("Seasonal discount applied!");
        }
        cart.addItem(this, quantity, size, finalPrice);
        sizeStock.put(size, sizeStock.get(size) - quantity);
        System.out.println(quantity + " x " + itemName + " (" + size + ") added to cart.");
        return true;
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + itemName + " x " + quantity + " | Price: " + price + (seasonal ? " (Seasonal Discount)" : ""));
    }

    @Override
    public boolean validateItem() {
        return price > 0 && sizeStock.values().stream().anyMatch(v -> v > 0);
    }
}

class GroceriesItem extends ShoppingItem {
    private LocalDate expiryDate;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expiryDate) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expiryDate = expiryDate;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc) {
        if (!validateItem()) {
            System.out.println("Item expired.");
            return false;
        }
        double finalPrice = price;
        if (quantity >= 10) {
            finalPrice *= 0.95; // 5% discount for bulk
            System.out.println("Bulk discount applied!");
        }
        if (quantity <= stockAvailable) {
            cart.addItem(this, quantity, null, finalPrice);
            stockAvailable -= quantity;
            System.out.println(quantity + " x " + itemName + " added to cart.");
            return true;
        } else {
            System.out.println("Insufficient stock.");
            return false;
        }
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + itemName + " x " + quantity + " | Price: " + price + " | Expiry: " + expiryDate);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && price > 0 && expiryDate.isAfter(LocalDate.now());
    }
}

class BooksItem extends ShoppingItem {
    private String isbn;
    private String edition;
    private String printQuality;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition, String printQuality) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
        this.printQuality = printQuality;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc) {
        if (!validateItem() || quantity > stockAvailable) {
            System.out.println("Book not available in requested quantity/edition/quality.");
            return false;
        }
        cart.addItem(this, quantity);
        stockAvailable -= quantity;
        System.out.println(quantity + " x " + itemName + " added to cart.");
        return true;
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + itemName + " x " + quantity + " | Price: " + price + " | ISBN: " + isbn + " | Edition: " + edition + " | Print: " + printQuality);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && price > 0 && edition != null && printQuality != null;
    }
}

class AccessoriesItem extends ShoppingItem {
    private List<String> varieties;
    private List<String> reviews;
    private List<Integer> ratings;

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, List<String> varieties) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.varieties = varieties;
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public boolean addToCart(Customer customer, ShoppingCart cart, int quantity, Scanner sc) {
        System.out.print("Enter variety: " + varieties + ": ");
        String variety = sc.next();
        if (!varieties.contains(variety)) {
            System.out.println("Variety not available.");
            return false;
        }
        if (quantity > stockAvailable) {
            System.out.println("Insufficient stock.");
            return false;
        }
        cart.addItem(this, quantity, variety, price);
        stockAvailable -= quantity;
        System.out.println(quantity + " x " + itemName + " (" + variety + ") added to cart.");
        return true;
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice: " + itemName + " x " + quantity + " | Price: " + price);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && price > 0 && !varieties.isEmpty();
    }

    public void addReview(String review, int rating) {
        reviews.add(review);
        ratings.add(rating);
    }

    public double getAverageRating() {
        return ratings.stream().mapToInt(i -> i).average().orElse(0.0);
    }
}

class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String phone;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public boolean validateDetails() {
        return customerId != null && !customerId.isEmpty() &&
               customerName != null && !customerName.isEmpty() &&
               email != null && email.contains("@") &&
               address != null && address.length() > 5 &&
               phone != null && phone.length() >= 7;
    }

    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}

class ShoppingCart {
    private String cartId;
    private List<CartItem> cartItems;
    private double totalPrice;
    private Customer customer;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
        this.totalPrice = 0;
        this.customer = customer;
    }

    public void addItem(ShoppingItem item, int quantity) {
        addItem(item, quantity, null, item.getPrice());
    }

    public void addItem(ShoppingItem item, int quantity, String option, double price) {
        // Check if item already in cart (same item and option)
        for (CartItem ci : cartItems) {
            if (ci.item == item && Objects.equals(ci.option, option)) {
                if (ci.quantity + quantity > item.getStockAvailable()) {
                    System.out.println("Cannot add more than available stock.");
                    return;
                }
                ci.quantity += quantity;
                totalPrice += price * quantity;
                return;
            }
        }
        if (quantity > item.getStockAvailable()) {
            System.out.println("Cannot add more than available stock.");
            return;
        }
        cartItems.add(new CartItem(item, quantity, option, price));
        totalPrice += price * quantity;
    }

    public void removeItem(ShoppingItem item, String option) {
        cartItems.removeIf(ci -> ci.item == item && Objects.equals(ci.option, option));
    }

    public double getTotalPrice() { return totalPrice; }
    public List<CartItem> getCartItems() { return cartItems; }
    public Customer getCustomer() { return customer; }
}

class CartItem {
    ShoppingItem item;
    int quantity;
    String option; // size, variety, etc.
    double price;
    public CartItem(ShoppingItem item, int quantity, String option, double price) {
        this.item = item;
        this.quantity = quantity;
        this.option = option;
        this.price = price;
    }
}

class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private LocalDate transactionDate;
    private static final Set<String> VALID_METHODS = new HashSet<>(Arrays.asList("CreditCard", "PayPal"));

    public Payment(String paymentId, String paymentMethod, double amountPaid, LocalDate transactionDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
    }

    public boolean validatePayment(double expectedAmount) {
        if (!VALID_METHODS.contains(paymentMethod)) {
            System.out.println("Invalid payment method.");
            return false;
        }
        if (amountPaid != expectedAmount) {
            System.out.println("Amount paid does not match total price.");
            return false;
        }
        return true;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public double getAmountPaid() { return amountPaid; }
}

class SalesReport {
    private double totalRevenue = 0;
    private Map<String, Integer> itemSales = new HashMap<>();
    private Map<String, Integer> paymentBreakdown = new HashMap<>();
    private int totalOrders = 0;
    private List<String> shippingStatus = new ArrayList<>();

    public void recordOrder(ShoppingCart cart, Payment payment) {
        totalOrders++;
        totalRevenue += payment.getAmountPaid();
        for (CartItem ci : cart.getCartItems()) {
            itemSales.put(ci.item.getItemName(), itemSales.getOrDefault(ci.item.getItemName(), 0) + ci.quantity);
        }
        paymentBreakdown.put(payment.getPaymentMethod(), paymentBreakdown.getOrDefault(payment.getPaymentMethod(), 0) + 1);
        shippingStatus.add("Order for " + cart.getCustomer().getCustomerName() + ": Shipped");
    }

    public void generateReport() {
        System.out.println("\n--- Sales Report ---");
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Item Sales:");
        for (String item : itemSales.keySet()) {
            System.out.println("  " + item + ": " + itemSales.get(item));
        }
        System.out.println("Payment Breakdown:");
        for (String method : paymentBreakdown.keySet()) {
            System.out.println("  " + method + ": " + paymentBreakdown.get(method));
        }
        System.out.println("Order Fulfillment:");
        for (String status : shippingStatus) {
            System.out.println("  " + status);
        }
        System.out.println("--------------------\n");
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ShoppingItem> inventory = new ArrayList<>();
        SalesReport report = new SalesReport();

        // Sample Inventory
        inventory.add(new ElectronicsItem("E1", "Smartphone", "Latest 5G phone", 699.99, 20, 24));
        Map<String, Integer> sizeStock = new HashMap<>();
        sizeStock.put("S", 10); sizeStock.put("M", 15); sizeStock.put("L", 8); sizeStock.put("XL", 5);
        inventory.add(new ClothingItem("C1", "T-Shirt", "Cotton T-Shirt", 19.99, 38, sizeStock, true));
        inventory.add(new GroceriesItem("G1", "Rice", "5kg bag", 12.99, 50, LocalDate.now().plusMonths(6)));
        inventory.add(new BooksItem("B1", "Java Programming", "Comprehensive guide", 39.99, 12, "978-1234567890", "2nd", "High"));
        inventory.add(new AccessoriesItem("A1", "Wristband", "Silicone wristband", 4.99, 30, Arrays.asList("Red", "Blue", "Green")));

        // Customer Registration
        System.out.println("Enter your details:");
        System.out.print("Customer ID: ");
        String cid = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        Customer customer = new Customer(cid, name, email, address, phone);
        if (!customer.validateDetails()) {
            System.out.println("Invalid customer details. Exiting.");
            return;
        }

        ShoppingCart cart = new ShoppingCart(UUID.randomUUID().toString(), customer);
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nAvailable Items:");
            for (int i = 0; i < inventory.size(); i++) {
                ShoppingItem item = inventory.get(i);
                System.out.println((i+1) + ". " + item.itemName + " (Stock: " + item.stockAvailable + ") - $" + item.price);
            }
            System.out.print("Select item number to add to cart (0 to checkout): ");
            int choice = sc.nextInt();
            if (choice == 0) break;
            if (choice < 1 || choice > inventory.size()) {
                System.out.println("Invalid selection.");
                continue;
            }
            ShoppingItem selected = inventory.get(choice-1);
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            sc.nextLine(); // consume newline
            if (qty <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }
            selected.addToCart(customer, cart, qty, sc);
        }

        System.out.println("\nYour Cart:");
        for (CartItem ci : cart.getCartItems()) {
            System.out.println(ci.quantity + " x " + ci.item.getItemName() + (ci.option != null ? " (" + ci.option + ")" : "") + " @ $" + ci.price);
        }
        System.out.println("Total Price: $" + cart.getTotalPrice());

        // Payment
        System.out.print("Enter payment method (CreditCard/PayPal): ");
        String payMethod = sc.nextLine();
        System.out.print("Enter amount to pay: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        Payment payment = new Payment(UUID.randomUUID().toString(), payMethod, amt, LocalDate.now());
        if (!payment.validatePayment(cart.getTotalPrice())) {
            System.out.println("Payment failed. Exiting.");
            return;
        }
        System.out.println("Payment successful!");
        report.recordOrder(cart, payment);

        // Generate Invoice
        System.out.println("\n--- Invoice ---");
        System.out.println("Customer: " + customer.getCustomerName());
        for (CartItem ci : cart.getCartItems()) {
            ci.item.generateInvoice(customer, ci.quantity);
        }
        System.out.println("Total Paid: $" + payment.getAmountPaid());
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Shipping to: " + customer.getAddress());
        System.out.println("----------------");

        // Sales Report
        report.generateReport();
        sc.close();
    }
}
