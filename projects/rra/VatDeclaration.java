package projects.rra;

public class VatDeclaration extends Declaration {
    private Taxpayer taxpayer;
    private static final double PREDEFINED_VAT_RATE = 0.18; // 18%

    public VatDeclaration(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    @Override
    public double calculateVatTax() {
        // Validate tax type and rate.
        if (!taxpayer.getTaxType().equalsIgnoreCase("VAT") ||
            taxpayer.getRate() != PREDEFINED_VAT_RATE) {
            System.out.println("Error: Taxpayer does not qualify for VAT declaration.");
            return 0;
        }
        return taxpayer.getTurnoverAmount() * PREDEFINED_VAT_RATE;
    }

    @Override
    public double calculateIncomeTax() {
        // Not applicable for VAT declaration.
        return 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- VAT Declaration -----");
        System.out.println(taxpayer);
        double vatTax = calculateVatTax();
        System.out.println("Calculated VAT Tax (18%): " + vatTax);
    }
}

