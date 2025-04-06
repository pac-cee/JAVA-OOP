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