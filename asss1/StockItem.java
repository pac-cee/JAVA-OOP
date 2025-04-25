public abstract class StockItem {
   private int itemId; 

   private String itemName; 

   private int quantityInStock; 

   private double pricePerUnit; 

   private String category; // e.g., "Electronics", "Clothing", "Groceries"

   private String supplier; 


   public abstract void updateStock(int quantity);

   public abstract double calculateStockValue();

   public abstract void generateStockReport();

   public abstract void validateStock();

    public StockItem(int itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier) {
     this.itemId = itemId;
     this.itemName = itemName;
     this.quantityInStock = quantityInStock;
     this.pricePerUnit = pricePerUnit;
     this.category = category;
     this.supplier = supplier;
    }
   public void setItemId(int itemId) {
    this.itemId = itemId;
   }
   public void setItemName(String itemName) {
    this.itemName = itemName;
   }
   public void setQuantityInStock(int quantityInStock) {        
    this.quantityInStock = quantityInStock;
   }
   public void setPricePerUnit(double pricePerUnit) {
    this.pricePerUnit = pricePerUnit;
   }    
   public void setCategory(String category) {
    this.category = category;   
   }
   public void setSupplier(String supplier) {
    this.supplier = supplier;
   }
   public int getItemId() {
    return itemId;
   }
    public String getItemName() {
     return itemName;
    }
    public int getQuantityInStock() {
     return quantityInStock;
    }
    public double getPricePerUnit() {
     return pricePerUnit;
    }
    public String getCategory() {
     return category;
    }
    public String getSupplier() {
     return supplier;
    }
}