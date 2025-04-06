// Interface for Stock with strict validation
public interface Stock {
    /**
     * Gets the stock symbol
     * @return Stock symbol as a string
     * @throws IllegalArgumentException if symbol format is invalid
     */
    String getSymbol();
    
    /**
     * Gets the current price of the stock
     * @return The current price as a double
     */
    double getPrice();
    
    /**
     * Gets the current trading volume
     * @return The volume as an integer
     */
    int getVolume();
    
    /**
     * Gets the exchange where the stock is traded
     * @return The exchange name as a string
     */
    String getExchangeName();
    
    /**
     * Calculates the market value of the stock (price * volume)
     * @return The market value as a double
     * @throws IllegalStateException if price or volume is zero
     */
    double calculateMarketValue() throws IllegalStateException;
    
    /**
     * Updates the stock price by a percentage change
     * @param percentageChange The percentage to adjust the price by (can be positive or negative)
     * @throws IllegalArgumentException if the resulting price would be negative
     */
    void updatePrice(double percentageChange) throws IllegalArgumentException;
    
    /**
     * Returns the specific type of stock
     * @return The stock type as a string
     */
    String getStockType();
}

// Abstract class implementing Stock interface with validation
public abstract class AbstractStock implements Stock {
    private String symbol;
    private double price;
    private int volume;
    private String exchangeName;
    
    // Valid exchange names
    private static final String[] VALID_EXCHANGES = {"NYSE", "NASDAQ", "LSE"};
    
    /**
     * Constructor with validation
     */
    public AbstractStock(String symbol, double price, int volume, String exchangeName) {
        // Validate and set symbol
        if (symbol == null || !symbol.matches("[A-Z]{3,5}")) {
            throw new IllegalArgumentException("Symbol must be 3-5 uppercase letters");
        }
        this.symbol = symbol;
        
        // Validate and set price
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
        
        // Validate and set volume
        if (volume < 0) {
            throw new IllegalArgumentException("Volume must be non-negative");
        }
        this.volume = volume;
        
        // Validate and set exchange name
        boolean validExchange = false;
        for (String exchange : VALID_EXCHANGES) {
            if (exchange.equals(exchangeName)) {
                validExchange = true;
                break;
            }
        }
        if (!validExchange) {
            throw new IllegalArgumentException("Exchange must be one of: NYSE, NASDAQ, LSE");
        }
        this.exchangeName = exchangeName;
    }
    
    @Override
    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    // Protected setter for price to be used by subclasses
    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    // Protected setter for volume to be used by subclasses
    protected void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Volume must be non-negative");
        }
        this.volume = volume;
    }
    
    @Override
    public String getExchangeName() {
        return exchangeName;
    }
    
    @Override
    public double calculateMarketValue() throws IllegalStateException {
        if (price == 0 || volume == 0) {
            throw new IllegalStateException("Cannot calculate market value: price or volume is zero");
        }
        return price * volume;
    }
    
    @Override
    public void updatePrice(double percentageChange) throws IllegalArgumentException {
        double newPrice = price * (1 + percentageChange / 100);
        if (newPrice <= 0) {
            throw new IllegalArgumentException("Price cannot become negative or zero");
        }
        this.price = newPrice;
    }
}

// TechStock subclass with innovation index
public class TechStock extends AbstractStock {
    private int innovationIndex; // Range: 0-100
    
    /**
     * Constructor with validation for TechStock
     */
    public TechStock(String symbol, double price, int volume, String exchangeName, int innovationIndex) {
        super(symbol, price, volume, exchangeName);
        
        // Validate innovation index
        if (innovationIndex < 0 || innovationIndex > 100) {
            throw new IllegalArgumentException("Innovation index must be between 0 and 100");
        }
        this.innovationIndex = innovationIndex;
    }
    
    /**
     * Get the innovation index
     * @return The innovation index as an integer
     */
    public int getInnovationIndex() {
        return innovationIndex;
    }
    
    /**
     * Set the innovation index
     * @param innovationIndex The new innovation index
     * @throws IllegalArgumentException if index is out of range
     */
    public void setInnovationIndex(int innovationIndex) {
        if (innovationIndex < 0 || innovationIndex > 100) {
            throw new IllegalArgumentException("Innovation index must be between 0 and 100");
        }
        this.innovationIndex = innovationIndex;
    }
    
    @Override
    public void updatePrice(double percentageChange) throws IllegalArgumentException {
        // If innovation index is low, price drops faster
        if (innovationIndex < 30 && percentageChange < 0) {
            // Amplify the negative change by 50%
            percentageChange *= 1.5;
        }
        super.updatePrice(percentageChange);
    }
    
    @Override
    public String getStockType() {
        return "Technology Stock";
    }
}

// DividendStock subclass with dividend yield
public class DividendStock extends AbstractStock {
    private double dividendYield; // Range: 0-15%
    
    /**
     * Constructor with validation for DividendStock
     */
    public DividendStock(String symbol, double price, int volume, String exchangeName, double dividendYield) {
        super(symbol, price, volume, exchangeName);
        
        // Validate dividend yield
        if (dividendYield < 0 || dividendYield > 15) {
            throw new IllegalArgumentException("Dividend yield must be between 0 and 15%");
        }
        this.dividendYield = dividendYield;
    }
    
    /**
     * Get the dividend yield
     * @return The dividend yield as a percentage
     */
    public double getDividendYield() {
        return dividendYield;
    }
    
    /**
     * Set the dividend yield
     * @param dividendYield The new dividend yield
     * @throws IllegalArgumentException if yield is out of range
     */
    public void setDividendYield(double dividendYield) {
        if (dividendYield < 0 || dividendYield > 15) {
            throw new IllegalArgumentException("Dividend yield must be between 0 and 15%");
        }
        this.dividendYield = dividendYield;
    }
    
    /**
     * Calculate total return including dividends
     * @return The total return as a percentage
     */
    public double calculateTotalReturn(double priceAppreciation) {
        return priceAppreciation + dividendYield;
    }
    
    @Override
    public String getStockType() {
        return "Dividend Stock";
    }
}

// Custom exception for invalid transactions
public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

// Custom exception for insufficient shares
public class InsufficientSharesException extends RuntimeException {
    public InsufficientSharesException(String message) {
        super(message);
    }
}

// Trading system implementation
public class TradingSystem {
    private List<Stock> stocks;
    
    /**
     * Constructor initializes an empty stock list
     */
    public TradingSystem() {
        this.stocks = new ArrayList<>();
    }
    
    /**
     * Add a stock to the trading system
     * @param stock The stock to add
     */
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    /**
     * Remove a stock from the trading system
     * @param symbol The symbol of the stock to remove
     * @return true if stock was removed, false if not found
     */
    public boolean removeStock(String symbol) {
        return stocks.removeIf(stock -> stock.getSymbol().equals(symbol));
    }
    
    /**
     * Find a stock by its symbol
     * @param symbol The symbol to search for
     * @return The stock if found, null otherwise
     */
    public Stock findStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }
    
    /**
     * Buy shares of a stock
     * @param symbol The symbol of the stock to buy
     * @param quantity The number of shares to buy
     * @throws InvalidTransactionException if quantity is invalid
     */
    public void buyShares(String symbol, int quantity) throws InvalidTransactionException {
        if (quantity <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        Stock stock = findStock(symbol);
        if (stock == null) {
            throw new InvalidTransactionException("Stock not found: " + symbol);
        }
        
        // Need to access protected methods, so we cast to our abstract class
        if (stock instanceof AbstractStock) {
            AbstractStock abstractStock = (AbstractStock) stock;
            
            // Update volume
            int newVolume = stock.getVolume() + quantity;
            abstractStock.setVolume(newVolume);
            
            // Update price - 1% increase per 100 shares
            double percentageChange = quantity / 100.0;
            abstractStock.updatePrice(percentageChange);
        }
    }
    
    /**
     * Sell shares of a stock
     * @param symbol The symbol of the stock to sell
     * @param quantity The number of shares to sell
     * @throws InvalidTransactionException if quantity is invalid
     * @throws InsufficientSharesException if not enough shares to sell
     */
    public void sellShares(String symbol, int quantity) 
            throws InvalidTransactionException, InsufficientSharesException {
        if (quantity <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        Stock stock = findStock(symbol);
        if (stock == null) {
            throw new InvalidTransactionException("Stock not found: " + symbol);
        }
        
        if (stock.getVolume() < quantity) {
            throw new InsufficientSharesException(
                "Not enough shares to sell. Available: " + stock.getVolume() + ", Requested: " + quantity);
        }
        
        // Need to access protected methods, so we cast to our abstract class
        if (stock instanceof AbstractStock) {
            AbstractStock abstractStock = (AbstractStock) stock;
            
            // Original volume for percentage calculation
            int originalVolume = stock.getVolume();
            
            // Update volume
            int newVolume = originalVolume - quantity;
            abstractStock.setVolume(newVolume);
            
            // Check if volume is below 10% of original
            if (newVolume < originalVolume * 0.1) {
                // Significant price drop of 10%
                abstractStock.updatePrice(-10);
            } else {
                // Normal price adjustment - 0.5% decrease per 100 shares
                double percentageChange = -0.5 * (quantity / 100.0);
                abstractStock.updatePrice(percentageChange);
            }
        }
    }
    
    /**
     * Get total market value of all stocks
     * @return The total market value
     */
    public double getTotalMarketValue() {
        double total = 0;
        for (Stock stock : stocks) {
            try {
                total += stock.calculateMarketValue();
            } catch (IllegalStateException e) {
                // Skip stocks with zero price or volume
                System.err.println("Warning: " + e.getMessage() + " for stock " + stock.getSymbol());
            }
        }
        return total;
    }
    
    /**
     * Process all stocks polymorphically
     * @param processor Function to process each stock
     */
    public void processStocks(Consumer<Stock> processor) {
        for (Stock stock : stocks) {
            processor.accept(stock);
        }
    }
}

// Example usage
public class StockTradingDemo {
    public static void main(String[] args) {
        try {
            // Create a trading system
            TradingSystem tradingSystem = new TradingSystem();
            
            // Create different types of stocks
            Stock techStock = new TechStock("AAPL", 180.50, 1000, "NASDAQ", 85);
            Stock dividendStock = new DividendStock("JNJ", 145.75, 500, "NYSE", 3.5);
            
            // Add stocks to the trading system
            tradingSystem.addStock(techStock);
            tradingSystem.addStock(dividendStock);
            
            // Display initial market values
            System.out.println("Initial Market Values:");
            tradingSystem.processStocks(stock -> {
                try {
                    System.out.printf("%s (%s): $%.2f%n", 
                        stock.getSymbol(), 
                        stock.getStockType(), 
                        stock.calculateMarketValue());
                } catch (IllegalStateException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            });
            
            // Buy and sell shares
            tradingSystem.buyShares("AAPL", 200);
            tradingSystem.sellShares("JNJ", 100);
            
            // Display updated market values
            System.out.println("\nUpdated Market Values:");
            tradingSystem.processStocks(stock -> {
                try {
                    System.out.printf("%s (%s): $%.2f%n", 
                        stock.getSymbol(), 
                        stock.getStockType(), 
                        stock.calculateMarketValue());
                } catch (IllegalStateException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            });
            
            // Calculate total portfolio value
            System.out.printf("\nTotal Portfolio Value: $%.2f%n", tradingSystem.getTotalMarketValue());
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}