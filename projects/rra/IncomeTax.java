package projects.rra;

public class IncomeTax extends Declaration {
    private Taxpayer taxpayer;
    private static final double PREDEFINED_INCOME_TAX_RATE = 0.30; // 30%

    public IncomeTax(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    @Override
    public double calculateVatTax() {
        // Not applicable for Income Tax declaration.
        return 0;
    }

    @Override
    public double calculateIncomeTax() {
        // Validate tax type and rate.
        if (!taxpayer.getTaxType().equalsIgnoreCase("Income Tax") ||
            taxpayer.getRate() != PREDEFINED_INCOME_TAX_RATE) {
            System.out.println("Error: Taxpayer does not qualify for Income Tax declaration.");
            return 0;
        }
        return taxpayer.getTurnoverAmount() * PREDEFINED_INCOME_TAX_RATE;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- Income Tax Declaration -----");
        System.out.println(taxpayer);
        double incomeTax = calculateIncomeTax();
        System.out.println("Calculated Income Tax (30%): " + incomeTax);
    }
}

