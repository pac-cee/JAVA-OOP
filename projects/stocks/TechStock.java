public class TechStock extends AbstractStock {
    private int innovationIndex; // Must be between 0 and 100.

    public TechStock(String symbol, double price, int volume, String exchangeName, int innovationIndex)
            throws InvalidStockAttributeException {
        super(symbol, price, volume, exchangeName);
        if (innovationIndex < 0 || innovationIndex > 100) {
            throw new InvalidStockAttributeException("Innovation index must be between 0 and 100.");
        }
        this.innovationIndex = innovationIndex;
    }

    public int getInnovationIndex() {
        return innovationIndex;
    }

    // Override updatePrice so that if innovationIndex is below 30 and percentageChange is negative, the drop is faster.
    @Override
    public void updatePrice(double percentageChange) {
        if (percentageChange < 0 && innovationIndex < 30) {
            percentageChange *= 1.5; // Increase the magnitude of the drop.
        }
        updatePriceBase(percentageChange);
    }

    @Override
    public String getStockType() {
        return "TechStock";
    }
}