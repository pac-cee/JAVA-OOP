package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class ThirdPartyPolicy extends InsurancePolicy {
    private double engineCapacity;
    private boolean extraCoverage;

    public ThirdPartyPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, double premiumAmount, LocalDate policyStartDate, LocalDate policyEndDate, double engineCapacity, boolean extraCoverage) {
        super(policyId, vehicle, policyHolder, coverageAmount, premiumAmount, policyStartDate, policyEndDate);
        this.engineCapacity = engineCapacity;
        this.extraCoverage = extraCoverage;
    }

    @Override
    public double calculatePremium() {
        double base = 0.01 * coverageAmount + (engineCapacity > 2000 ? 100 : 50);
        if (extraCoverage) base += 75;
        return base;
    }

    @Override
    public boolean processClaim(Claim claim) {
        if (!claim.validateClaim(coverageAmount)) return false;
        claim.setClaimStatus("Processed");
        System.out.println("Claim processed for Third Party Policy.");
        return true;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[ThirdPartyPolicy] Policy ID: " + policyId + ", Engine: " + engineCapacity + ", Extra: " + extraCoverage);
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
