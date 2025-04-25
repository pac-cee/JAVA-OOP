import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static final String[] CATEGORIES = {"Electronics", "Clothing", "Groceries", "Furniture", "Perishable"};

private static String chooseCategory() {
    while (true) {
        System.out.println("Select a category:");
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.printf("%d. %s\n", i + 1, CATEGORIES[i]);
        }
        System.out.print("Enter category number: ");
        String input = scanner.nextLine().trim();
        try {
            int idx = Integer.parseInt(input) - 1;
            if (idx >= 0 && idx < CATEGORIES.length) {
                return CATEGORIES[idx];
            }
        } catch (NumberFormatException ignored) {}
        System.out.println("Invalid selection. Please choose a valid category by number.");
    }
}

private static String getWordInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter letters only.");
            } else if (input.matches("[a-zA-Z ]+")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter letters only.");
            }
        }
    }

    private static String getLineInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

    private static String getIdInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("ID cannot be empty. Please enter a valid alphanumeric ID.");
            } else if (input.matches("[a-zA-Z0-9-_]+")) {
                return input;
            } else {
                System.out.println("Invalid ID. Please enter only letters, numbers, hyphens, or underscores.");
            }
        }
    }

    private static String getUniqueNameInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name (letters and spaces only).");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Please enter letters and spaces only.");
            } else if (!productNames.add(input)) {
                System.out.println("Product name must be unique. Please enter a different name.");
            } else {
                return input;
            }
        }
    }
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<StockItem> stockItems = new ArrayList<>();
    private static final Set<String> productNames = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("--- Advanced Stock Management System ---");
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:\n1. Add Electronics Item\n2. Add Clothing Item\n3. Add Grocery Item\n4. Add Furniture Item\n5. Add Perishable Item\n6. Generate Inventory Report\n7. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput("");
            switch (choice) {
                case 1 -> addElectronicsItem();
                case 2 -> addClothingItem();
                case 3 -> addGroceryItem();
                case 4 -> addFurnitureItem();
                case 5 -> addPerishableItem();
                case 6 -> generateInventoryReport();
                case 7 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting...");
    }

    private static void addElectronicsItem() {
    String id = getIdInput("Item ID: ");
    String name = getUniqueNameInput("Item Name: ");
    int qty = getIntInput("Quantity In Stock: ");
    double price;
    while (true) {
        price = getDoubleInput("Price Per Unit: ");
        if (price > 0) break;
        System.out.println("Price per unit must be above zero.");
    }
    String cat = chooseCategory();
    String supplier = getWordInput("Supplier: ");
    int warranty;
    while (true) {
        warranty = getIntInput("Warranty (months, 0-60): ");
        if (warranty >= 0 && warranty <= 60) break;
        System.out.println("Warranty must be between 0 and 60 months.");
    }
    double discount;
    while (true) {
        discount = getDoubleInput("Discount (%): ");
        if (discount >= 0 && discount <= 50) break;
        System.out.println("Discount must be between 0% and 50%.");
    }
    ElectronicsItem item = new ElectronicsItem(id, name, qty, price, cat, supplier, warranty, discount);
    if (item.validateStock()) {
        stockItems.add(item);
        System.out.println("Electronics item added.");
    } else {
        productNames.remove(name);
    }
}
        String id = getIdInput("Item ID: ");
        String name = getUniqueNameInput("Item Name: ");
        int qty = getIntInput("Quantity In Stock: ");
        double price = getDoubleInput("Price Per Unit: ");
        String cat = getWordInput("Category: ");
        String supplier = getWordInput("Supplier: ");
        int warranty = getIntInput("Warranty (months): ");
        double discount = getDoubleInput("Discount (%): ");
        ElectronicsItem item = new ElectronicsItem(id, name, qty, price, cat, supplier, warranty, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Electronics item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addClothingItem() {
    String id = getIdInput("Item ID: ");
    String name = getUniqueNameInput("Item Name: ");
    int qty = getIntInput("Quantity In Stock: ");
    double price;
    while (true) {
        price = getDoubleInput("Price Per Unit: ");
        if (price > 0) break;
        System.out.println("Price per unit must be above zero.");
    }
    String cat = chooseCategory();
    String supplier = getWordInput("Supplier: ");
    Set<String> sizes = new HashSet<>(Arrays.asList(getLineInput("Sizes (comma-separated): ").split(",")));
    Set<String> colors = new HashSet<>(Arrays.asList(getLineInput("Colors (comma-separated): ").split(",")));
    double discount;
    while (true) {
        discount = getDoubleInput("Discount (%): ");
        if (discount >= 0 && discount <= 50) break;
        System.out.println("Discount must be between 0% and 50%.");
    }
    ClothingItem item = new ClothingItem(id, name, qty, price, cat, supplier, sizes, colors, discount);
    if (item.validateStock()) {
        stockItems.add(item);
        System.out.println("Clothing item added.");
    } else {
        productNames.remove(name);
    }
}
        String id = getIdInput("Item ID: ");
        String name = getUniqueNameInput("Item Name: ");
        int qty = getIntInput("Quantity In Stock: ");
        double price = getDoubleInput("Price Per Unit: ");
        String cat = getWordInput("Category: ");
        String supplier = getWordInput("Supplier: ");
        Set<String> sizes = new HashSet<>(Arrays.asList(getLineInput("Sizes (comma-separated): ").split(",")));
        Set<String> colors = new HashSet<>(Arrays.asList(getLineInput("Colors (comma-separated): ").split(",")));
        double discount = getDoubleInput("Discount (%): ");
        ClothingItem item = new ClothingItem(id, name, qty, price, cat, supplier, sizes, colors, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Clothing item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addGroceryItem() {
    String id = getIdInput("Item ID: ");
    String name = getUniqueNameInput("Item Name: ");
    int qty = getIntInput("Quantity In Stock: ");
    double price;
    while (true) {
        price = getDoubleInput("Price Per Unit: ");
        if (price > 0) break;
        System.out.println("Price per unit must be above zero.");
    }
    String cat = chooseCategory();
    String supplier = getWordInput("Supplier: ");
    LocalDate exp = null;
    while (true) {
        String expInput = getLineInput("Expiration Date (yyyy-mm-dd): ");
        try {
            exp = LocalDate.parse(expInput);
            break;
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
        }
    }
    double discount;
    while (true) {
        discount = getDoubleInput("Discount (%): ");
        if (discount >= 0 && discount <= 50) break;
        System.out.println("Discount must be between 0% and 50%.");
    }
    GroceryItem item = new GroceryItem(id, name, qty, price, cat, supplier, exp, discount);
    if (item.validateStock()) {
        stockItems.add(item);
        System.out.println("Grocery item added.");
    } else {
        productNames.remove(name);
    }
}
        String id = getIdInput("Item ID: ");
        String name = getUniqueNameInput("Item Name: ");
        int qty = getIntInput("Quantity In Stock: ");
        double price = getDoubleInput("Price Per Unit: ");
        String cat = getWordInput("Category: ");
        String supplier = getWordInput("Supplier: ");
        LocalDate exp = null;
        while (true) {
            String expInput = getLineInput("Expiration Date (yyyy-mm-dd): ");
            try {
                exp = LocalDate.parse(expInput);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            }
        }
        double discount = getDoubleInput("Discount (%): ");
        GroceryItem item = new GroceryItem(id, name, qty, price, cat, supplier, exp, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Grocery item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addFurnitureItem() {
    String id = getIdInput("Item ID: ");
    String name = getUniqueNameInput("Item Name: ");
    int qty = getIntInput("Quantity In Stock: ");
    double price;
    while (true) {
        price = getDoubleInput("Price Per Unit: ");
        if (price > 0) break;
        System.out.println("Price per unit must be above zero.");
    }
    String cat = chooseCategory();
    String supplier = getWordInput("Supplier: ");
    double weight = getDoubleInput("Weight (kg): ");
    boolean packed = false;
    while (true) {
        String packedInput = getLineInput("Well Packed (true/false): ").toLowerCase();
        if (packedInput.equals("true") || packedInput.equals("false")) {
            packed = Boolean.parseBoolean(packedInput);
            break;
        } else {
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }
    FurnitureItem item = new FurnitureItem(id, name, qty, price, cat, supplier, weight, packed);
    if (item.validateStock()) {
        stockItems.add(item);
        System.out.println("Furniture item added.");
    } else {
        productNames.remove(name);
    }
}
        String id = getIdInput("Item ID: ");
        String name = getUniqueNameInput("Item Name: ");
        int qty = getIntInput("Quantity In Stock: ");
        double price = getDoubleInput("Price Per Unit: ");
        String cat = getWordInput("Category: ");
        String supplier = getWordInput("Supplier: ");
        double weight = getDoubleInput("Weight (kg): ");
        boolean packed = false;
        while (true) {
            String packedInput = getLineInput("Well Packed (true/false): ").toLowerCase();
            if (packedInput.equals("true") || packedInput.equals("false")) {
                packed = Boolean.parseBoolean(packedInput);
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
        FurnitureItem item = new FurnitureItem(id, name, qty, price, cat, supplier, weight, packed);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Furniture item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addPerishableItem() {
    String id = getIdInput("Item ID: ");
    String name = getUniqueNameInput("Item Name: ");
    int qty = getIntInput("Quantity In Stock: ");
    double price;
    while (true) {
        price = getDoubleInput("Price Per Unit: ");
        if (price > 0) break;
        System.out.println("Price per unit must be above zero.");
    }
    String cat = chooseCategory();
    String supplier = getWordInput("Supplier: ");
    LocalDate exp = null;
    while (true) {
        String expInput = getLineInput("Expiration Date (yyyy-mm-dd): ");
        try {
            exp = LocalDate.parse(expInput);
            break;
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
        }
    }
    int shelf;
    while (true) {
        shelf = getIntInput("Shelf Life (days, 1-14): ");
        if (shelf > 0 && shelf <= 14) break;
        System.out.println("Shelf life for perishable items must be short (1-14 days).\n");
    }
    PerishableItem item = new PerishableItem(id, name, qty, price, cat, supplier, exp, shelf);
    if (item.validateStock()) {
        stockItems.add(item);
        System.out.println("Perishable item added.");
    } else {
        productNames.remove(name);
    }
}
        String id = getIdInput("Item ID: ");
        String name = getUniqueNameInput("Item Name: ");
        int qty = getIntInput("Quantity In Stock: ");
        double price = getDoubleInput("Price Per Unit: ");
        String cat = getWordInput("Category: ");
        String supplier = getWordInput("Supplier: ");
        LocalDate exp = null;
        while (true) {
            String expInput = getLineInput("Expiration Date (yyyy-mm-dd): ");
            try {
                exp = LocalDate.parse(expInput);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            }
        }
        int shelf = getIntInput("Shelf Life (days): ");
        PerishableItem item = new PerishableItem(id, name, qty, price, cat, supplier, exp, shelf);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Perishable item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void generateInventoryReport() {
    System.out.println("\n--- Inventory Report ---");
    double totalValue = 0;
    for (StockItem item : stockItems) {
        item.generateStockReport();
        totalValue += item.calculateStockValue();
    }
    System.out.println("\nTotal Inventory Value: " + totalValue);
    System.out.println("\n--- Expired or Nearly Expired Items ---");
    for (StockItem item : stockItems) {
        // Only for GroceryItem and PerishableItem
        if (item instanceof GroceryItem) {
            GroceryItem g = (GroceryItem) item;
            if (!g.validateStock()) {
                System.out.println("[EXPIRED/NEAR EXPIRY] " + g.itemName);
            }
        } else if (item instanceof PerishableItem) {
            PerishableItem p = (PerishableItem) item;
            if (!p.validateStock()) {
                System.out.println("[EXPIRED/NEAR EXPIRY] " + p.itemName);
            }
        }
    }
    System.out.println("\n--- Discounts and Sales Performance ---");
    for (StockItem item : stockItems) {
        if (item instanceof ClothingItem) {
            System.out.println(item.itemName + " | Discounted Stock Value: " + ((ClothingItem)item).calculateStockValue());
        } else if (item instanceof GroceryItem) {
            System.out.println(item.itemName + " | Discounted Stock Value: " + ((GroceryItem)item).calculateStockValue());
        } else if (item instanceof ElectronicsItem) {
            System.out.println(item.itemName + " | Discounted Stock Value: " + ((ElectronicsItem)item).calculateStockValue());
        }
    }
}
        System.out.println("\n--- Inventory Report ---");
        for (StockItem item : stockItems) {
            item.generateStockReport();
        }
    }
}
