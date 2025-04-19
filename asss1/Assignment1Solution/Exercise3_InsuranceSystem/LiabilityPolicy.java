package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class LiabilityPolicy extends InsurancePolicy {
    private boolean medicalChecked;
    private boolean extendedDisabilityCoverage;

    public LiabilityPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, double premiumAmount, LocalDate policyStartDate, LocalDate policyEndDate, boolean medicalChecked, boolean extendedDisabilityCoverage) {
        super(policyId, vehicle, policyHolder, coverageAmount, premiumAmount, policyStartDate, policyEndDate);
        this.medicalChecked = medicalChecked;
        this.extendedDisabilityCoverage = extendedDisabilityCoverage;
    }

    @Override
    public double calculatePremium() {
        double base = 0.012 * coverageAmount;
        if (extendedDisabilityCoverage) base += 100;
        return base;
    }

    @Override
    public boolean processClaim(Claim claim) {
        if (!claim.validateClaim(coverageAmount)) return false;
        claim.setClaimStatus("Processed");
        System.out.println("Claim processed for Liability Policy.");
        return true;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[LiabilityPolicy] Policy ID: " + policyId + ", Medical Checked: " + medicalChecked + ", Extended Disability: " + extendedDisabilityCoverage);
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
        if (!medicalChecked) {
            System.out.println("Medical checkup required for policyholder.");
            valid = false;
        }
        if (policyStartDate.isAfter(policyEndDate)) {
            System.out.println("Policy start date must be before end date.");
            valid = false;
        }
        return valid;
    }
}
