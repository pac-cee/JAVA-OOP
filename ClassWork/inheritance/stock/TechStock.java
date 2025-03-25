public class TechStock extends AbstractStock {
    private int innovationIndex;  // 0-100
    
    public TechStock(String symbol, double price, int volume, String exchangeName, int innovationIndex) {
        super(symbol, price, volume, exchangeName);
        validateInnovationIndex(innovationIndex);
        this.innovationIndex = innovationIndex;
    }
    
    private void validateInnovationIndex(int index) {
        if (index < 0 || index > 100) {
            throw new IllegalArgumentException("Innovation index must be between 0 and 100");
        }
    }
    
    @Override
    public void updatePrice(double percentageChange) {
        // If innovation index is low, price drops faster
        if (innovationIndex < 30 && percentageChange < 0) {
            percentageChange *= 1.5;  // 50% faster drop
        }
        super.updatePrice(percentageChange);
    }
    
    @Override
    public String getStockType() {
        return "TECH";
    }
    
    public int getInnovationIndex() {
        return innovationIndex;
    }
}

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