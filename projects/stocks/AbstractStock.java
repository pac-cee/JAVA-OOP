public abstract class AbstractStock implements Stock {
    protected String symbol;
    protected double price;
    protected int volume;
    protected String exchangeName;

    public AbstractStock(String symbol, double price, int volume, String exchangeName)
            throws InvalidStockAttributeException {
        // Validate symbol: non-empty string of 3-5 uppercase letters.
        if (symbol == null || !symbol.matches("[A-Z]{3,5}")) {
            throw new InvalidStockAttributeException("Invalid stock symbol: " + symbol);
        }
        // Validate price: positive and non-zero.
        if (price <= 0) {
            throw new InvalidStockAttributeException("Price must be positive and non-zero: " + price);
        }
        // Validate volume: integer ≥ 0.
        if (volume < 0) {
            throw new InvalidStockAttributeException("Volume cannot be negative: " + volume);
        }
        // Validate exchangeName.
        if (!exchangeName.equals("NYSE") && !exchangeName.equals("NASDAQ") && !exchangeName.equals("LSE")) {
            throw new InvalidStockAttributeException("Exchange name must be one of: NYSE, NASDAQ, LSE");
        }
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.exchangeName = exchangeName;
    }

    // calculateMarketValue throws an exception if price or volume is zero.

    @Override
    public double calculateMarketValue() { 
    
        return price * volume;
    }

    /**
     * Base method to update price. It applies a percentage change to the current price,
     * ensuring that the price never becomes negative. (A minimal value is enforced.)
     */
    protected void updatePriceBase(double percentageChange) {
        double newPrice = price * (1 + percentageChange / 100.0);
        if (newPrice < 0) {
            newPrice = 0.01; // Enforce a minimal price if calculation goes negative.
        }
        price = newPrice;
    }

    // Buy shares: updates volume and increases price by 1% per 100 shares.
    
    public void buyShares(int qty) throws InvalidTransactionException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity to buy must be positive.");
        }
        int originalVolume = volume;  
        volume += qty;
        int increasePercent = qty / 100; // 1% increase for each full 100 shares purchased.
        if (increasePercent > 0) {
            updatePrice(increasePercent); // Delegate to the (possibly overridden) updatePrice.
        }
        System.out.println(qty + " shares bought. Volume: " + originalVolume + " -> " + volume + ", Price: " + price);
    }

    // Sell shares: ensures enough shares exist; if volume falls below 10% of original, drop price significantly.

    public void sellShares(int qty) throws InvalidTransactionException, InsufficientSharesException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity to sell must be positive.");
        }
        if (qty > volume) {
            throw new InsufficientSharesException("Not enough shares to sell. Available: " + volume);
        }
        int originalVolume = volume;
        volume -= qty;
        // If volume after sale is below 10% of the original volume, drop price significantly (e.g., by 5%).
        if (volume < 0.1 * originalVolume) {
            updatePrice(-5);
            System.out.println("Significant price drop due to low volume after sale.");
        }
        System.out.println(qty + " shares sold. Volume: " + originalVolume + " -> " + volume + ", Price: " + price);
    }

    // Getters for attributes
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
}
