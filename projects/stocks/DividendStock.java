public class DividendStock extends AbstractStock {
    private double dividendYield; // Must be a percentage between 0 and 15.

    public DividendStock(String symbol, double price, int volume, String exchangeName, double dividendYield)
            throws InvalidStockAttributeException {
        super(symbol, price, volume, exchangeName);
        if (dividendYield < 0 || dividendYield > 15) {
            throw new InvalidStockAttributeException("Dividend yield must be between 0 and 15%.");
        }
        this.dividendYield = dividendYield;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    // For dividend stocks, a normal update of the price is applied.
    @Override
    public void updatePrice(double percentageChange) {
        updatePriceBase(percentageChange);
    }

    @Override
    public String getStockType() {
        return "DividendStock";
    }
}