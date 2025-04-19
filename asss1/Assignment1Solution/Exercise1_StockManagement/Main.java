package Assignment1Solution.Exercise1_StockManagement;

import java.util.*;
import java.time.LocalDate;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<StockItem> stockItems = new ArrayList<>();
    private static final Set<String> productNames = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("--- Advanced Stock Management System ---");
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:\n1. Add Electronics Item\n2. Add Clothing Item\n3. Add Grocery Item\n4. Add Furniture Item\n5. Add Perishable Item\n6. Generate Inventory Report\n7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addElectronicsItem(); break;
                case 2: addClothingItem(); break;
                case 3: addGroceryItem(); break;
                case 4: addFurnitureItem(); break;
                case 5: addPerishableItem(); break;
                case 6: generateInventoryReport(); break;
                case 7: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting...");
    }

    private static void addElectronicsItem() {
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Item Name: "); String name = scanner.nextLine();
        if (!productNames.add(name)) {
            System.out.println("Product name must be unique."); return;
        }
        System.out.print("Quantity In Stock: "); int qty = scanner.nextInt();
        System.out.print("Price Per Unit: "); double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: "); String cat = scanner.nextLine();
        System.out.print("Supplier: "); String supplier = scanner.nextLine();
        System.out.print("Warranty (months): "); int warranty = scanner.nextInt();
        System.out.print("Discount (%): "); double discount = scanner.nextDouble();
        scanner.nextLine();
        ElectronicsItem item = new ElectronicsItem(id, name, qty, price, cat, supplier, warranty, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Electronics item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addClothingItem() {
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Item Name: "); String name = scanner.nextLine();
        if (!productNames.add(name)) {
            System.out.println("Product name must be unique."); return;
        }
        System.out.print("Quantity In Stock: "); int qty = scanner.nextInt();
        System.out.print("Price Per Unit: "); double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: "); String cat = scanner.nextLine();
        System.out.print("Supplier: "); String supplier = scanner.nextLine();
        System.out.print("Sizes (comma-separated): "); Set<String> sizes = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));
        System.out.print("Colors (comma-separated): "); Set<String> colors = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));
        System.out.print("Discount (%): "); double discount = scanner.nextDouble();
        scanner.nextLine();
        ClothingItem item = new ClothingItem(id, name, qty, price, cat, supplier, sizes, colors, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Clothing item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addGroceryItem() {
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Item Name: "); String name = scanner.nextLine();
        if (!productNames.add(name)) {
            System.out.println("Product name must be unique."); return;
        }
        System.out.print("Quantity In Stock: "); int qty = scanner.nextInt();
        System.out.print("Price Per Unit: "); double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: "); String cat = scanner.nextLine();
        System.out.print("Supplier: "); String supplier = scanner.nextLine();
        System.out.print("Expiration Date (yyyy-mm-dd): "); LocalDate exp = LocalDate.parse(scanner.nextLine());
        System.out.print("Discount (%): "); double discount = scanner.nextDouble();
        scanner.nextLine();
        GroceryItem item = new GroceryItem(id, name, qty, price, cat, supplier, exp, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Grocery item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addFurnitureItem() {
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Item Name: "); String name = scanner.nextLine();
        if (!productNames.add(name)) {
            System.out.println("Product name must be unique."); return;
        }
        System.out.print("Quantity In Stock: "); int qty = scanner.nextInt();
        System.out.print("Price Per Unit: "); double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: "); String cat = scanner.nextLine();
        System.out.print("Supplier: "); String supplier = scanner.nextLine();
        System.out.print("Weight (kg): "); double weight = scanner.nextDouble();
        System.out.print("Well Packed (true/false): "); boolean packed = scanner.nextBoolean();
        scanner.nextLine();
        FurnitureItem item = new FurnitureItem(id, name, qty, price, cat, supplier, weight, packed);
        if (item.validateStock()) {
            stockItems.add(item);
            System.out.println("Furniture item added.");
        } else {
            productNames.remove(name);
        }
    }

    private static void addPerishableItem() {
        System.out.print("Item ID: "); String id = scanner.nextLine();
        System.out.print("Item Name: "); String name = scanner.nextLine();
        if (!productNames.add(name)) {
            System.out.println("Product name must be unique."); return;
        }
        System.out.print("Quantity In Stock: "); int qty = scanner.nextInt();
        System.out.print("Price Per Unit: "); double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: "); String cat = scanner.nextLine();
        System.out.print("Supplier: "); String supplier = scanner.nextLine();
        System.out.print("Expiration Date (yyyy-mm-dd): "); LocalDate exp = LocalDate.parse(scanner.nextLine());
        System.out.print("Shelf Life (days): "); int shelf = scanner.nextInt();
        scanner.nextLine();
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
        for (StockItem item : stockItems) {
            item.generateStockReport();
        }
    }
}
