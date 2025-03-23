package ClassWork.inheritance.stock;

import java.util.ArrayList;
import java.util.List;
import ClassWork.inheritance.stock.Stock;
public class TradingSystem {
    private List<Stock> stocks = new ArrayList<>();
    
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    public void buyShares(Stock stock, int qty) throws InvalidTransactionException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        // Update volume
        int newVolume = stock.getVolume() + qty;
        
        // Update price: 1% increase per 100 shares
        double priceIncrease = Math.floor(qty / 100.0) * 1.0;
        
        if (stock instanceof AbstractStock) {
            AbstractStock abstractStock = (AbstractStock) stock;
            abstractStock.setVolume(newVolume);
            abstractStock.updatePrice(priceIncrease);
        }
    }
    
    public void sellShares(Stock stock, int qty) throws InsufficientSharesException, InvalidTransactionException {
        if (qty <= 0) {
            throw new InvalidTransactionException("Quantity must be positive");
        }
        
        if (stock.getVolume() < qty) {
            throw new InsufficientSharesException("Not enough shares to sell");
        }
        
        int originalVolume = stock.getVolume();
        int newVolume = originalVolume - qty;
        
        // Calculate price impact
        double priceChange = 0;
        if (newVolume < originalVolume * 0.1) {
            // Significant drop if volume falls below 10% of original
            priceChange = -15;  // 15% drop
        } else {
            // Normal price decrease
            priceChange = -Math.floor(qty / 100.0) * 0.5;  // 0.5% decrease per 100 shares
        }
        
        if (stock instanceof AbstractStock) {
            AbstractStock abstractStock = (AbstractStock) stock;
            abstractStock.setVolume(newVolume);
            abstractStock.updatePrice(priceChange);
        }
    }
    
    public void processAllStocks() {
        for (Stock stock : stocks) {
            try {
                System.out.println("Processing " + stock.getSymbol() + " (" + stock.getStockType() + ")");
                System.out.println("Market Value: $" + stock.calculateMarketValue());
            } catch (InvalidStockDataException e) {
                System.err.println("Error processing stock " + stock.getSymbol() + ": " + e.getMessage());
            }
        }
    }
}