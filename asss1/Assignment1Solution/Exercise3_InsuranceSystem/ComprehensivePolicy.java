package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class ComprehensivePolicy extends InsurancePolicy {
    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, double premiumAmount, LocalDate policyStartDate, LocalDate policyEndDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, premiumAmount, policyStartDate, policyEndDate);
    }

    @Override
    public double calculatePremium() {
        int age = LocalDate.now().getYear() - vehicle.getVehicleYear();
        double base = 0.02 * coverageAmount;
        if (age < 5) base *= 1.1;
        else if (age > 10) base *= 0.8;
        return base;
    }

    @Override
    public boolean processClaim(Claim claim) {
        if (!claim.validateClaim(coverageAmount)) return false;
        claim.setClaimStatus("Processed");
        System.out.println("Claim processed for Comprehensive Policy.");
        return true;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[ComprehensivePolicy] Policy ID: " + policyId + ", Vehicle: " + vehicle.getVehicleModel() + ", Holder: " + policyHolder.getFullName() + ", Coverage: " + coverageAmount + ", Premium: " + premiumAmount);
    }

    @Override
    public boolean validatePolicy() {
        boolean valid = true;
        if (!vehicle.validateVehicle()) valid = false;
        if (!policyHolder.validatePerson()) valid = false;
        if (coverageAmount <= 0) {
            System.out.println("Coverage amount must be positive.");
            valid = false;
        }
        if (premiumAmount <= 0) {
            System.out.println("Premium amount must be positive.");
            valid = false;
        }
        if (policyStartDate.isAfter(policyEndDate)) {
            System.out.println("Policy start date must be before end date.");
            valid = false;
        }
        return valid;
    }
}
