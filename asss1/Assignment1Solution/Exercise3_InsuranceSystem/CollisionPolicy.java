package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class CollisionPolicy extends InsurancePolicy {
    private boolean safeDriver;
    private boolean safetyChecked;

    public CollisionPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, double premiumAmount, LocalDate policyStartDate, LocalDate policyEndDate, boolean safeDriver, boolean safetyChecked) {
        super(policyId, vehicle, policyHolder, coverageAmount, premiumAmount, policyStartDate, policyEndDate);
        this.safeDriver = safeDriver;
        this.safetyChecked = safetyChecked;
    }

    @Override
    public double calculatePremium() {
        double base = 0.015 * coverageAmount;
        if (safeDriver) base *= 0.9;
        if (!safetyChecked) base *= 1.2;
        return base;
    }

    @Override
    public boolean processClaim(Claim claim) {
        if (!claim.validateClaim(coverageAmount)) return false;
        claim.setClaimStatus("Processed");
        System.out.println("Claim processed for Collision Policy.");
        return true;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[CollisionPolicy] Policy ID: " + policyId + ", Safe Driver: " + safeDriver + ", Safety Checked: " + safetyChecked);
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
        if (!safetyChecked) {
            System.out.println("Vehicle must pass safety check before approval.");
            valid = false;
        }
        if (policyStartDate.isAfter(policyEndDate)) {
            System.out.println("Policy start date must be before end date.");
            valid = false;
        }
        return valid;
    }
}
