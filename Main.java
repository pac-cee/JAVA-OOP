import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

// Custom exceptions
class InvalidStockDataException extends Exception {
    public InvalidStockDataException(String message) {
        super(message);
    }
}

class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

class InsufficientSharesException extends Exception {
    public InsufficientSharesException(String message) {
        super(message);
    }
}

// Interface for Stock with strict validation
interface Stock {
    // Constants
    List<String> VALID_EXCHANGES = Arrays.asList("NYSE", "NASDAQ", "LSE");
    
    // Getter methods
    String getSymbol();
    double getPrice();
    int getVolume();
    String getExchangeName();
    
    // Abstract methods
    double calculateMarketValue() throws InvalidStockDataException;
    void updatePrice(double percentageChange);
    String getStockType();
    
    // Transaction methods
    void buyShares(int qty) throws InvalidTransactionException;
    void sellShares(int qty) throws InvalidTransactionException, InsufficientSharesException;
}

// Abstract base implementation with validation logic
abstract class AbstractStock implements Stock {
    private String symbol;
    private double price;
    private int volume;
    private String exchangeName;
    private final int initialVolume;
    
    public AbstractStock(String symbol, double price, int volume, String exchangeName) 
            throws InvalidStockDataException {
        validateAndSetSymbol(symbol);
        validateAndSetPrice(price);
        validateAndSetVolume(volume);
        validateAndSetExchange(exchangeName);
        this.initialVolume = volume;
    }
    
    private void validateAndSetSymbol(String symbol) throws InvalidStockDataException {
        if (symbol == null || !Pattern.matches("^[A-Z]{3,5}$", symbol)) {
            throw new InvalidStockDataException("Symbol must be 3-5 uppercase letters");
        }
        this.symbol = symbol;
    }
    
    private void validateAndSetPrice(double price) throws InvalidStockDataException {
        if (price <= 0) {
            throw new InvalidStockDataException("Price must be positive");
        }
        this.price = price;
    }
    
    private void validateAndSetVolume(int volume) throws InvalidStockDataException {
        if (volume < 0) {
            throw new InvalidStockDataException("Volume cannot be negative");
        }
        this.volume = volume;
    }
    
    private void validateAndSetExchange(String exchangeName) throws InvalidStockDataException {
        if (!VALID_EXCHANGES.contains(exchangeName)) {
            throw new InvalidStockDataException("Exchange must be one of: " + String.join(", ", VALID_EXCHANGES));
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
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    @Override
    public String getExchangeName() {
        return exchangeName;
    }
    
    protected void setPrice(double newPrice) throws InvalidStockDataException {
        if (newPrice <= 0) {
            throw new InvalidStockDataException("Price must be positive");
        }
        this.price = newPrice;
    }
    
    protected void setVolume(int newVolume) throws InvalidStockDataException {
        if (newVolume < 0) {
            throw new InvalidStockDataException("Volume cannot be negative");
        }
        this.volume = newVolume;
    }
    
    @Override
    public double calculateMarketValue() throws InvalidStockDataException {
        if (price <= 0 || volume <= 0) {
            throw new InvalidStockDataException("Cannot calculate market value with zero price or volume");
        }
        return price * volume;
    }
    
    @Override
    public void updatePrice(double percentageChange) {
        double changeMultiplier = 1 + (percentageChange / 100);
        double newPrice = price * changeMultiplier;
        
        // Ensure price never becomes negative
        price = Math.max(0.01, newPrice);
    }
    
    @Override
    public void buyShares(int qty) throws InvalidTransactionException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        try {
            // Update volume
            setVolume(volume + qty);
            
            // Increase price by 1% per 100 shares
            double priceIncrease = 1 + ((qty / 100.0) * 0.01);
            setPrice(price * priceIncrease);
        } catch (InvalidStockDataException e) {
            throw new InvalidTransactionException("Transaction failed: " + e.getMessage());
        }
    }
    
    @Override
    public void sellShares(int qty) throws InvalidTransactionException, InsufficientSharesException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        if (qty > volume) {
            throw new InsufficientSharesException("Cannot sell more shares than owned");
        }
        
        try {
            int newVolume = volume - qty;
            setVolume(newVolume);
            
            // If volume drops below 10% of original, price drops significantly
            if (newVolume < initialVolume * 0.1) {
                updatePrice(-15); // Drop price by 15%
            } else {
                // Standard small price decrease on selling
                updatePrice(-1);
            }
        } catch (InvalidStockDataException e) {
            throw new InvalidTransactionException("Transaction failed: " + e.getMessage());
        }
    }
}

// TechStock implementation
class TechStock extends AbstractStock {
    private int innovationIndex;
    
    public TechStock(String symbol, double price, int volume, String exchangeName, int innovationIndex) 
            throws InvalidStockDataException {
        super(symbol, price, volume, exchangeName);
        setInnovationIndex(innovationIndex);
    }
    
    public void setInnovationIndex(int innovationIndex) throws InvalidStockDataException {
        if (innovationIndex < 0 || innovationIndex > 100) {
            throw new InvalidStockDataException("Innovation index must be between 0 and 100");
        }
        this.innovationIndex = innovationIndex;
    }
    
    public int getInnovationIndex() {
        return innovationIndex;
    }
    
    @Override
    public String getStockType() {
        return "Tech Stock";
    }
    
    @Override
    public void updatePrice(double percentageChange) {
        // If innovation index is low, price drops faster
        if (innovationIndex < 30 && percentageChange < 0) {
            // Amplify negative changes by 50%
            percentageChange *= 1.5;
        }
        super.updatePrice(percentageChange);
    }
}

// DividendStock implementation
class DividendStock extends AbstractStock {
    private double dividendYield;
    
    public DividendStock(String symbol, double price, int volume, String exchangeName, double dividendYield) 
            throws InvalidStockDataException {
        super(symbol, price, volume, exchangeName);
        setDividendYield(dividendYield);
    }
    
    public void setDividendYield(double dividendYield) throws InvalidStockDataException {
        if (dividendYield < 0 || dividendYield > 15) {
            throw new InvalidStockDataException("Dividend yield must be between 0 and 15%");
        }
        this.dividendYield = dividendYield;
    }
    
    public double getDividendYield() {
        return dividendYield;
    }
    
    @Override
    public String getStockType() {
        return "Dividend Stock";
    }
    
    @Override
    public double calculateMarketValue() throws InvalidStockDataException {
        // Base market value + dividend premium
        double baseValue = super.calculateMarketValue();
        return baseValue * (1 + (dividendYield / 100));
    }
}

// Trading system to demonstrate polymorphic processing
class StockTradingSystem {
    private List<Stock> stockPortfolio = new ArrayList<>();
    
    public void addStock(Stock stock) {
        stockPortfolio.add(stock);
    }
    
    public List<Stock> getStocks() {
        return stockPortfolio;
    }
    
    public void processAllStocks() {
        for (Stock stock : stockPortfolio) {
            try {
                System.out.println("Processing " + stock.getStockType() + ": " + stock.getSymbol());
                System.out.println("Market Value: $" + stock.calculateMarketValue());
            } catch (InvalidStockDataException e) {
                System.err.println("Error processing stock " + stock.getSymbol() + ": " + e.getMessage());
            }
        }
    }
    
    // Demo usage example
    public static void main(String[] args) {
        StockTradingSystem system = new StockTradingSystem();
        
        try {
            // Create different stock types
            TechStock techStock = new TechStock("AAPL", 180.50, 1000, "NASDAQ", 85);
            DividendStock dividendStock = new DividendStock("JNJ", 145.75, 500, "NYSE", 3.5);
            
            // Add to portfolio
            system.addStock(techStock);
            system.addStock(dividendStock);
            
            // Process stocks polymorphically
            system.processAllStocks();
            
            // Demonstrate transactions
            System.out.println("\nBuying 200 shares of " + techStock.getSymbol());
            techStock.buyShares(200);
            System.out.println("New volume: " + techStock.getVolume() + ", New price: $" + techStock.getPrice());
            
            System.out.println("\nSelling 100 shares of " + dividendStock.getSymbol());
            dividendStock.sellShares(100);
            System.out.println("New volume: " + dividendStock.getVolume() + ", New price: $" + dividendStock.getPrice());
            
            // Try to sell more shares than owned
            System.out.println("\nAttempting to sell 1000 shares of " + dividendStock.getSymbol());
            dividendStock.sellShares(1000);
            
        } catch (InvalidStockDataException e) {
            System.err.println("Stock data error: " + e.getMessage());
        } catch (InvalidTransactionException e) {
            System.err.println("Transaction error: " + e.getMessage());
        } catch (InsufficientSharesException e) {
            System.err.println("Insufficient shares: " + e.getMessage());
        }
    }
}
