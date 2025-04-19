package Assignment1Solution.Exercise2_OnlineShopping;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<ShoppingItem> items = new ArrayList<>();
    private static final List<Customer> customers = new ArrayList<>();
    private static final List<ShoppingCart> carts = new ArrayList<>();
    private static final List<Payment> payments = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- Advanced Online Shopping System ---");
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:\n1. Add Customer\n2. Add Shopping Item\n3. Create Cart\n4. Add Item to Cart\n5. Checkout\n6. Generate Sales Report\n7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addCustomer(); break;
                case 2: addShoppingItem(); break;
                case 3: createCart(); break;
                case 4: addItemToCart(); break;
                case 5: checkout(); break;
                case 6: generateSalesReport(); break;
                case 7: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting...");
    }

    private static void addCustomer() {
        System.out.print("Customer ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Address: "); String address = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        Customer c = new Customer(id, name, email, address, phone);
        if (c.validateCustomer()) {
            customers.add(c);
            System.out.println("Customer added.");
        }
    }

    private static void addShoppingItem() {
        System.out.println("Select item type:\n1. Electronics\n2. Clothing\n3. Groceries\n4. Books\n5. Accessories");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Description: "); String desc = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        System.out.print("Stock Available: "); int stock = scanner.nextInt();
        scanner.nextLine();
        ShoppingItem item = null;
        switch (type) {
            case 1:
                System.out.print("Warranty (months): "); int warranty = scanner.nextInt();
                System.out.print("Registered (true/false): "); boolean reg = scanner.nextBoolean();
                scanner.nextLine();
                item = new ElectronicsItem(id, name, desc, price, stock, warranty, reg);
                break;
            case 2:
                System.out.print("Sizes (comma-separated): "); Set<String> sizes = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));
                System.out.print("Seasonal Discount (%): "); double disc = scanner.nextDouble();
                scanner.nextLine();
                item = new ClothingItem(id, name, desc, price, stock, sizes, disc);
                break;
            case 3:
                System.out.print("Expiration Date (yyyy-mm-dd): "); LocalDate exp = LocalDate.parse(scanner.nextLine());
                System.out.print("Bulk Discount (%): "); double bulk = scanner.nextDouble();
                scanner.nextLine();
                item = new GroceriesItem(id, name, desc, price, stock, exp, bulk);
                break;
            case 4:
                System.out.print("ISBN: "); String isbn = scanner.nextLine();
                System.out.print("Edition: "); String edition = scanner.nextLine();
                System.out.print("Print Quality: "); String pq = scanner.nextLine();
                item = new BooksItem(id, name, desc, price, stock, isbn, edition, pq);
                break;
            case 5:
                System.out.print("Varieties (comma-separated): "); List<String> varieties = Arrays.asList(scanner.nextLine().split(","));
                item = new AccessoriesItem(id, name, desc, price, stock, varieties);
                break;
            default:
                System.out.println("Invalid item type.");
        }
        if (item != null && item.validateItem()) {
            items.add(item);
            System.out.println("Item added.");
        }
    }

    private static void createCart() {
        System.out.print("Cart ID: "); String cartId = scanner.nextLine();
        System.out.print("Customer ID: "); String custId = scanner.nextLine();
        Customer c = customers.stream().filter(x -> x.getCustomerId().equals(custId)).findFirst().orElse(null);
        if (c == null) {
            System.out.println("Customer not found."); return;
        }
        ShoppingCart cart = new ShoppingCart(cartId, c);
        carts.add(cart);
        System.out.println("Cart created.");
    }

    private static void addItemToCart() {
        System.out.print("Cart ID: "); String cartId = scanner.nextLine();
        ShoppingCart cart = carts.stream().filter(x -> x.getCustomer() != null && x.getCartItems() != null && x.getCartItems().size() >= 0 && x.getCartId().equals(cartId)).findFirst().orElse(null);
        if (cart == null) {
            System.out.println("Cart not found."); return;
        }
        System.out.print("Item ID: "); String itemId = scanner.nextLine();
        ShoppingItem item = items.stream().filter(x -> x.itemId.equals(itemId)).findFirst().orElse(null);
        if (item == null) {
            System.out.println("Item not found."); return;
        }
        System.out.print("Quantity: "); int qty = scanner.nextInt();
        scanner.nextLine();
        if (cart.addItem(item, qty)) {
            System.out.println("Item added to cart.");
        }
    }

    private static void checkout() {
        System.out.print("Cart ID: "); String cartId = scanner.nextLine();
        ShoppingCart cart = carts.stream().filter(x -> x.getCustomer() != null && x.getCartItems() != null && x.getCartItems().size() >= 0 && x.getCartId().equals(cartId)).findFirst().orElse(null);
        if (cart == null) {
            System.out.println("Cart not found."); return;
        }
        double total = cart.getTotalPrice();
        System.out.print("Payment Method (Credit Card/PayPal/Debit Card/Cash): ");
        String method = scanner.nextLine();
        System.out.print("Amount Paid: ");
        double paid = scanner.nextDouble();
        scanner.nextLine();
        Payment payment = new Payment(UUID.randomUUID().toString(), method, paid, LocalDateTime.now());
        if (payment.validatePayment(total)) {
            payments.add(payment);
            System.out.println("Payment successful! Order placed.");
        }
    }

    private static void generateSalesReport() {
        System.out.println("\n--- Sales Report ---");
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Carts: " + carts.size());
        System.out.println("Total Payments: " + payments.size());
        double totalRevenue = payments.stream().mapToDouble(Payment::getAmountPaid).sum();
        System.out.println("Total Revenue: " + totalRevenue);
        Map<String, Long> paymentMethodCounts = new HashMap<>();
        for (Payment p : payments) {
            paymentMethodCounts.put(p.getPaymentMethod(), paymentMethodCounts.getOrDefault(p.getPaymentMethod(), 0L) + 1);
        }
        System.out.println("Payment Breakdown: " + paymentMethodCounts);
        // Add more detailed reporting as needed
    }
}
