import java.awt.*;
import javax.swing.*;

public class StockManagementFrame extends JFrame {
    private static final java.util.List<StockItem> stockItems = new java.util.ArrayList<>();
    private static final java.util.Set<String> productNames = new java.util.HashSet<>();
    private final JTextArea reportArea = new JTextArea();

    public StockManagementFrame() {
        setTitle("Stock Management System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header/description
        JLabel header = new JLabel("Advanced Stock Management System - Exercise 1", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        add(header, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        JButton addElectronicsBtn = new JButton("Add Electronics Item");
        JButton addClothingBtn = new JButton("Add Clothing Item");
        JButton addGroceryBtn = new JButton("Add Grocery Item");
        JButton addFurnitureBtn = new JButton("Add Furniture Item");
        JButton addPerishableBtn = new JButton("Add Perishable Item");
        JButton reportBtn = new JButton("Generate Inventory Report");
        buttonPanel.add(addElectronicsBtn);
        buttonPanel.add(addClothingBtn);
        buttonPanel.add(addGroceryBtn);
        buttonPanel.add(addFurnitureBtn);
        buttonPanel.add(addPerishableBtn);
        buttonPanel.add(reportBtn);
        add(buttonPanel, BorderLayout.CENTER);

        // Report area
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setPreferredSize(new Dimension(700, 200));
        add(scrollPane, BorderLayout.SOUTH);

        // Button actions
        addElectronicsBtn.addActionListener(e -> addElectronicsItem());
        addClothingBtn.addActionListener(e -> addClothingItem());
        addGroceryBtn.addActionListener(e -> addGroceryItem());
        addFurnitureBtn.addActionListener(e -> addFurnitureItem());
        addPerishableBtn.addActionListener(e -> addPerishableItem());
        reportBtn.addActionListener(e -> generateInventoryReport());
    }

    private String prompt(String message) {
        return JOptionPane.showInputDialog(this, message);
    }
    private int promptInt(String message) {
        while (true) {
            String input = prompt(message);
            if (input == null) return -1;
            try { return Integer.parseInt(input); } catch (Exception e) { showError("Enter a valid integer."); }
        }
    }
    private double promptDouble(String message) {
        while (true) {
            String input = prompt(message);
            if (input == null) return -1;
            try { return Double.parseDouble(input); } catch (Exception e) { showError("Enter a valid number."); }
        }
    }
    private String promptWord(String message) {
        while (true) {
            String input = prompt(message);
            if (input == null) return null;
            if (input.trim().matches("[a-zA-Z ]+")) return input.trim();
            showError("Enter letters only.");
        }
    }
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addElectronicsItem() {
        String id = prompt("Item ID:");
        if (id == null) return;
        String name = prompt("Item Name:");
        if (name == null) return;
        if (!productNames.add(name)) { showError("Product name must be unique."); return; }
        int qty = promptInt("Quantity In Stock:");
        double price = promptDouble("Price Per Unit:");
        String cat = promptWord("Category:");
        String supplier = promptWord("Supplier:");
        int warranty = promptInt("Warranty (months):");
        double discount = promptDouble("Discount (%):");
        ElectronicsItem item = new ElectronicsItem(id, name, qty, price, cat, supplier, warranty, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            showInfo("Electronics item added.");
        } else {
            productNames.remove(name);
        }
    }
    private void addClothingItem() {
        String id = prompt("Item ID:");
        if (id == null) return;
        String name = prompt("Item Name:");
        if (name == null) return;
        if (!productNames.add(name)) { showError("Product name must be unique."); return; }
        int qty = promptInt("Quantity In Stock:");
        double price = promptDouble("Price Per Unit:");
        String cat = promptWord("Category:");
        String supplier = promptWord("Supplier:");
        String sizesStr = prompt("Sizes (comma-separated):");
        java.util.Set<String> sizes = new java.util.HashSet<>();
        if (sizesStr != null) for (String s : sizesStr.split(",")) sizes.add(s.trim());
        String colorsStr = prompt("Colors (comma-separated):");
        java.util.Set<String> colors = new java.util.HashSet<>();
        if (colorsStr != null) for (String s : colorsStr.split(",")) colors.add(s.trim());
        double discount = promptDouble("Discount (%):");
        ClothingItem item = new ClothingItem(id, name, qty, price, cat, supplier, sizes, colors, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            showInfo("Clothing item added.");
        } else {
            productNames.remove(name);
        }
    }
    private void addGroceryItem() {
        String id = prompt("Item ID:");
        if (id == null) return;
        String name = prompt("Item Name:");
        if (name == null) return;
        if (!productNames.add(name)) { showError("Product name must be unique."); return; }
        int qty = promptInt("Quantity In Stock:");
        double price = promptDouble("Price Per Unit:");
        String cat = promptWord("Category:");
        String supplier = promptWord("Supplier:");
        java.time.LocalDate exp = null;
        while (exp == null) {
            String expStr = prompt("Expiration Date (yyyy-mm-dd):");
            try { exp = java.time.LocalDate.parse(expStr); } catch (Exception e) { showError("Invalid date format."); }
        }
        double discount = promptDouble("Discount (%):");
        GroceryItem item = new GroceryItem(id, name, qty, price, cat, supplier, exp, discount);
        if (item.validateStock()) {
            stockItems.add(item);
            showInfo("Grocery item added.");
        } else {
            productNames.remove(name);
        }
    }
    private void addFurnitureItem() {
        String id = prompt("Item ID:");
        if (id == null) return;
        String name = prompt("Item Name:");
        if (name == null) return;
        if (!productNames.add(name)) { showError("Product name must be unique."); return; }
        int qty = promptInt("Quantity In Stock:");
        double price = promptDouble("Price Per Unit:");
        String cat = promptWord("Category:");
        String supplier = promptWord("Supplier:");
        double weight = promptDouble("Weight (kg):");
        boolean packed = false;
        while (true) {
            String packedStr = prompt("Well Packed (true/false):");
            if (packedStr == null) return;
            if (packedStr.equalsIgnoreCase("true") || packedStr.equalsIgnoreCase("false")) {
                packed = Boolean.parseBoolean(packedStr);
                break;
            } else {
                showError("Enter 'true' or 'false'.");
            }
        }
        FurnitureItem item = new FurnitureItem(id, name, qty, price, cat, supplier, weight, packed);
        if (item.validateStock()) {
            stockItems.add(item);
            showInfo("Furniture item added.");
        } else {
            productNames.remove(name);
        }
    }
    private void addPerishableItem() {
        String id = prompt("Item ID:");
        if (id == null) return;
        String name = prompt("Item Name:");
        if (name == null) return;
        if (!productNames.add(name)) { showError("Product name must be unique."); return; }
        int qty = promptInt("Quantity In Stock:");
        double price = promptDouble("Price Per Unit:");
        String cat = promptWord("Category:");
        String supplier = promptWord("Supplier:");
        java.time.LocalDate exp = null;
        while (exp == null) {
            String expStr = prompt("Expiration Date (yyyy-mm-dd):");
            try { exp = java.time.LocalDate.parse(expStr); } catch (Exception e) { showError("Invalid date format."); }
        }
        int shelf = promptInt("Shelf Life (days):");
        PerishableItem item = new PerishableItem(id, name, qty, price, cat, supplier, exp, shelf);
        if (item.validateStock()) {
            stockItems.add(item);
            showInfo("Perishable item added.");
        } else {
            productNames.remove(name);
        }
    }
    private void generateInventoryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Inventory Report ---\n");
        for (StockItem item : stockItems) {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream oldOut = System.out;
            System.setOut(ps);
            item.generateStockReport();
            System.out.flush();
            System.setOut(oldOut);
            sb.append(baos.toString());
        }
        reportArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new StockManagementFrame().setVisible(true);
        });
    }
}
