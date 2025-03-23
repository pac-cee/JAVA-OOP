package ClassWork.inheritance.stock;
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