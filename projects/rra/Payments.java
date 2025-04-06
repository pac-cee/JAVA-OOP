package projects.rra;

public class Payments extends Declaration {
    private Taxpayer taxpayer;
    private double paymentAmount;
    
    public Payments(Taxpayer taxpayer, double paymentAmount) {
        this.taxpayer = taxpayer;
        this.paymentAmount = paymentAmount;
    }

    // In Payment, we calculate both taxes and then verify the payment.
    @Override
    public double calculateVatTax() {
        if (taxpayer.getTaxType().equalsIgnoreCase("VAT")) {
            return taxpayer.getTurnoverAmount() * 0.18;
        }
        return 0;
    }

    @Override
    public double calculateIncomeTax() {
        if (taxpayer.getTaxType().equalsIgnoreCase("Income Tax")) {
            return taxpayer.getTurnoverAmount() * 0.30;
        }
        return 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- Payment Declaration -----");
        System.out.println(taxpayer);
        double calculatedTax = 0;
        if (taxpayer.getTaxType().equalsIgnoreCase("VAT")) {
            calculatedTax = calculateVatTax();
        } else if (taxpayer.getTaxType().equalsIgnoreCase("Income Tax")) {
            calculatedTax = calculateIncomeTax();
        }
        System.out.println("Calculated Tax: " + calculatedTax);
        System.out.println("Payment Amount: " + paymentAmount);
        if (Math.abs(calculatedTax - paymentAmount) < 0.001) {
            System.out.println("Payment validated: Payment matches the calculated tax.");
        } else {
            System.out.println("Payment error: Payment does not match the calculated tax.");
        }
    }
}

