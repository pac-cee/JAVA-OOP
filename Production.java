public class Production {
    private final int existingStock;
    private final int newStock;
    private static final int PRICE_PER_UNIT = 150;
    
    
     Production(int existingStock, int newStock) {
        this.existingStock = existingStock;
        this.newStock = newStock;
    }
    
    
    public int getTotalStock() {
        return existingStock + newStock;
    }
    
    
    public int getTotalValue() {
        return getTotalStock() * PRICE_PER_UNIT;
    }
    
   
    public static void main(String[] args) {
        Production prod = new Production(100, 50); 
        System.out.println("Total Stock: " + prod.getTotalStock());
        System.out.println("Total Value: " + prod.getTotalValue());
    }
}
