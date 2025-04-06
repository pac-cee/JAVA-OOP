import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Stock> portfolio = new ArrayList<>();
            // Pre-populate with sample stocks.
            try {
                portfolio.add(new TechStock("AAPL", 150.0, 1000, "NASDAQ", 25));
                portfolio.add(new DividendStock("MSFT", 200.0, 800, "NASDAQ", 5.0));
            } catch (InvalidStockAttributeException e) {
                System.out.println("Error creating initial stocks: " + e.getMessage());
            }
            boolean exit = false;
            while (!exit) {
                System.out.println("\n----- Stock Trading System Menu -----");
                System.out.println("1. Display Portfolio");
                System.out.println("2. Create a new Stock");
                System.out.println("3. Buy Shares");
                System.out.println("4. Sell Shares");
                System.out.println("5. Calculate Market Value");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = -1;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }
                
                switch (choice) {
                    case 1 -> displayPortfolio(portfolio);
                    case 2 -> createNewStock(portfolio, scanner);
                    case 3 -> tradeShares(portfolio, scanner, true);
                    case 4 -> tradeShares(portfolio, scanner, false);
                    case 5 -> calculateMarketValue(portfolio, scanner);
                    case 6 -> {
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please select from the menu options.");
                }
            }
        }
            }

    // Display all stocks in the portfolio.
    private static void displayPortfolio(List<Stock> portfolio) {
        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\n--- Portfolio ---");
        for (int i = 0; i < portfolio.size(); i++) {
            Stock s = portfolio.get(i);
            System.out.println((i + 1) + ". " + s.getStockType() + " - Symbol: " + s.getSymbol()
                    + ", Price: " + s.getPrice() + ", Volume: " + s.getVolume() + ", Exchange: " + s.getExchangeName());
        }
    }

    // Create a new stock based on user input.
    private static void createNewStock(List<Stock> portfolio, Scanner scanner) {
        try {
            System.out.println("\nEnter stock type (1 for TechStock, 2 for DividendStock): ");
            int type = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter symbol (3-5 uppercase letters): ");
            String symbol = scanner.nextLine().trim();
            System.out.print("Enter price (positive decimal): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter volume (non-negative integer): ");
            int volume = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter exchange name (NYSE, NASDAQ, LSE): ");
            String exchange = scanner.nextLine().trim().toUpperCase();

            switch (type) {
                case 1 -> {
                    System.out.print("Enter innovation index (0-100): ");
                    int innovationIndex = Integer.parseInt(scanner.nextLine());
                    Stock newTechStock = new TechStock(symbol, price, volume, exchange, innovationIndex);
                    portfolio.add(newTechStock);
                    System.out.println("TechStock added successfully.");
                }
                case 2 -> {
                    System.out.print("Enter dividend yield (0-15%): ");
                    double dividendYield = Double.parseDouble(scanner.nextLine());
                    Stock newDividendStock = new DividendStock(symbol, price, volume, exchange, dividendYield);
                    portfolio.add(newDividendStock);
                    System.out.println("DividendStock added successfully.");
                }
                default -> System.out.println("Invalid stock type selected.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Please try again.");
        } catch (InvalidStockAttributeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Buy or Sell shares for a selected stock.
    private static void tradeShares(List<Stock> portfolio, Scanner scanner, boolean buy) {
        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is empty. Please add stocks first.");
            return;
        }
        displayPortfolio(portfolio);
        System.out.print("\nSelect the stock number: ");
        int index = -1;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= portfolio.size()) {
                System.out.println("Invalid stock selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = 0;
        try {
            qty = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity.");
            return;
        }
        Stock selectedStock = portfolio.get(index);
        try {
            if (buy) {
                selectedStock.buyShares(qty);
            } else {
                selectedStock.sellShares(qty);
            }
        } catch (InvalidTransactionException | InsufficientSharesException e) {
            System.out.println("Transaction error: " + e.getMessage());
        }
    }

    // Calculate and display market value for a selected stock.
    private static void calculateMarketValue(List<Stock> portfolio, Scanner scanner) {
        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        displayPortfolio(portfolio);
        System.out.print("\nSelect the stock number to calculate market value: ");
        int index = -1;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= portfolio.size()) {
                System.out.println("Invalid stock selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }
        Stock selectedStock = portfolio.get(index);
        try {
            double marketValue = selectedStock.calculateMarketValue();
            System.out.println("Market Value of " + selectedStock.getSymbol() + ": " + marketValue);
        } catch (Exception e) {
            System.out.println("Error calculating market value: " + e.getMessage());
        }
    }
}