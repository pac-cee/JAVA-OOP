package classwork.inheritance.stock;

public class DividendStock extends AbstractStock {
    private double dividendYield;  // 0-15%
    
    public DividendStock(String symbol, double price, int volume, String exchangeName, double dividendYield) {
        super(symbol, price, volume, exchangeName);
        validateDividendYield(dividendYield);
        this.dividendYield = dividendYield;
    }
    
    private void validateDividendYield(double yield) {
        if (yield < 0 || yield > 15) {
            throw new IllegalArgumentException("Dividend yield must be between 0 and 15%");
        }
    }
    
    @Override
    public double calculateMarketValue() throws InvalidStockDataException {
        // Add dividend value to market value
        return super.calculateMarketValue() * (1 + dividendYield / 100);
    }
    
    @Override
    public String getStockType() {
        return "DIVIDEND";
    }
    
    public double getDividendYield() {
        return dividendYield;
    }
}
