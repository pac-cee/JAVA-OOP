public class ElectronicsItem extends StockItem{
    private int warrantyPeriod; // in months
    

    public ElectronicsItem(int warrantyPeriod, int itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.warrantyPeriod = warrantyPeriod;
    }
    @Override
    public void validateStock() {
        if (getQuantityInStock() < 0) {
            System.out.println("Invalid stock quantity for sale");
        } else{
            System.out.println("Valid stock quantity for sale");
        }
    }
 
    public void discountOnElectronics(double discountPercentage) {
        double discountAmount = (getPricePerUnit() * discountPercentage) / 100;
        double discountedPrice = getPricePerUnit() - discountAmount;
        System.out.println("Discounted price: " + discountedPrice);
    }

}


