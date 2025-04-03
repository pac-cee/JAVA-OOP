import build.InvalidStockDataException;
import build.Stock;

public abstract class AbstractStock implements Stock {
    private String symbol;
    private double price;
    private int volume;
    private String exchangeName;
    
    public AbstractStock(String symbol, double price, int volume, String exchangeName) {
        validateSymbol(symbol);
        validatePrice(price);
        validateVolume(volume);
        validateExchange(exchangeName);
        
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.exchangeName = exchangeName;
    }
    
    private void validateSymbol(String symbol) {
        if (symbol == null || !symbol.matches("^[A-Z]{3,5}$")) {
            throw new IllegalArgumentException("Symbol must be 3-5 uppercase letters");
        }
    }
    
    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }
    
    private void validateVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Volume must be non-negative");
        }
    }
    
    private void validateExchange(String exchangeName) {
        if (!VALID_EXCHANGES.contains(exchangeName)) {
            throw new IllegalArgumentException("Exchange must be one of: " + VALID_EXCHANGES);
        }
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
    
    @Override
    public double calculateMarketValue() throws InvalidStockDataException {
        if (price <= 0 || volume <= 0) {
            throw new InvalidStockDataException("Cannot calculate market value with zero price or volume");
        }
        return price * volume;
    }
    
    @Override
    public void updatePrice(double percentageChange) {
        double newPrice = price * (1 + percentageChange / 100);
        if (newPrice > 0) {
            price = newPrice;
        }
    }
    
    protected void setVolume(int volume) {
        validateVolume(volume);
        this.volume = volume;
    }
    
    protected void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }
}