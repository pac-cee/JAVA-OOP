public interface Stock {
    // Constants for validation
    List<String> VALID_EXCHANGES = List.of("NYSE", "NASDAQ", "LSE");
    
    // Getter methods with validation
    String getSymbol();  // 3-5 uppercase letters
    double getPrice();   // positive, non-zero
    int getVolume();     // non-negative integer
    String getExchangeName();  // must be in VALID_EXCHANGES
    
    // Abstract methods
    double calculateMarketValue() throws InvalidStockDataException;
    void updatePrice(double percentageChange);
    String getStockType();
}