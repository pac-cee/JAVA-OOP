package exercises.finance;

public class FinancialCalculator {
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService > 10) {
            return salary * 0.15;
        } else if (yearsOfService >= 5) {
            return salary * 0.10;
        } else {
            return salary * 0.05;
        }
    }

    public static double calculateElectricityBill(int units) {
        double bill = 0;
        if (units <= 100) {
            bill = units * 0.50;
        } else if (units <= 300) {
            bill = (100 * 0.50) + ((units - 100) * 0.75);
        } else {
            bill = (100 * 0.50) + (200 * 0.75) + ((units - 300) * 1.20);
        }
        return bill;
    }

    public static boolean isEligibleForLoan(double income, int creditScore, int existingLoans) {
        return income >= 30000 && creditScore >= 700 && existingLoans < 2;
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Example conversion rates (in real application, these would be fetched from an API)
        double usdToEur = 0.85;
        double usdToGbp = 0.73;
        double usdToInr = 73.5;

        // First convert to USD if not already
        double usdAmount = amount;
        switch (fromCurrency.toUpperCase()) {
            case "EUR": usdAmount = amount / usdToEur; break;
            case "GBP": usdAmount = amount / usdToGbp; break;
            case "INR": usdAmount = amount / usdToInr; break;
        }

        // Then convert USD to target currency
        switch (toCurrency.toUpperCase()) {
            case "EUR": return usdAmount * usdToEur;
            case "GBP": return usdAmount * usdToGbp;
            case "INR": return usdAmount * usdToInr;
            default: return usdAmount; // USD
        }
    }

    public static double calculateDiscount(double amount, String customerType) {
        switch (customerType.toUpperCase()) {
            case "VIP": return amount * 0.20;        // 20% discount
            case "PREMIUM": return amount * 0.15;    // 15% discount
            case "REGULAR": return amount * 0.10;    // 10% discount
            default: return 0;
        }
    }

    public static double getVehicleFee(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car": return 5.00;
            case "truck": return 10.00;
            case "motorcycle": return 3.00;
            case "bus": return 15.00;
            default: return 0.00;
        }
    }
}
