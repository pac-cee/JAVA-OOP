package exercises.finance;

public class FinancialCalculator {
    private static final double UNIT_RATE_1 = 0.50;  // First 100 units
    private static final double UNIT_RATE_2 = 0.75;  // Next 200 units
    private static final double UNIT_RATE_3 = 1.20;  // Above 300 units

    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService < 5) {
            return salary * 0.05;
        } else if (yearsOfService <= 10) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    public static double calculateElectricityBill(int units) {
        double bill = 0;
        if (units <= 100) {
            bill = units * UNIT_RATE_1;
        } else if (units <= 300) {
            bill = (100 * UNIT_RATE_1) + ((units - 100) * UNIT_RATE_2);
        } else {
            bill = (100 * UNIT_RATE_1) + (200 * UNIT_RATE_2) + ((units - 300) * UNIT_RATE_3);
        }
        return bill;
    }

    public static boolean isEligibleForLoan(double income, int creditScore, int existingLoans) {
        return income >= 30000 && creditScore >= 700 && existingLoans < 2;
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Example conversion rates (in real application, these would come from an API)
        double[][] rates = {
            //USD   EUR    GBP    INR
            {1.0,   0.85,  0.75,  82.0},  // USD
            {1.18,  1.0,   0.88,  96.5},  // EUR
            {1.33,  1.13,  1.0,   109.3}, // GBP
            {0.012, 0.010, 0.009, 1.0}    // INR
        };
        
        int fromIndex = getCurrencyIndex(fromCurrency);
        int toIndex = getCurrencyIndex(toCurrency);
        
        if (fromIndex == -1 || toIndex == -1) {
            throw new IllegalArgumentException("Unsupported currency");
        }
        
        return amount * rates[fromIndex][toIndex];
    }

    private static int getCurrencyIndex(String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> 0;
            case "EUR" -> 1;
            case "GBP" -> 2;
            case "INR" -> 3;
            default -> -1;
        };
    }

    public static double calculateDiscount(double amount, String customerType) {
        return amount * switch (customerType.toUpperCase()) {
            case "REGULAR" -> 0.05;  // 5% discount
            case "PREMIUM" -> 0.10;  // 10% discount
            case "VIP" -> 0.15;     // 15% discount
            default -> 0.0;         // No discount
        };
    }

    public static double getVehicleFee(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "car" -> 50.0;
            case "truck" -> 100.0;
            case "motorcycle" -> 25.0;
            case "bus" -> 75.0;
            default -> throw new IllegalArgumentException("Unknown vehicle type");
        };
    }
}
