package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class RoadsideAssistancePolicy extends InsurancePolicy {
    private boolean isCommercial;
    private boolean registrationVerified;
    private boolean inspectionVerified;

    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, double premiumAmount, LocalDate policyStartDate, LocalDate policyEndDate, boolean isCommercial, boolean registrationVerified, boolean inspectionVerified) {
        super(policyId, vehicle, policyHolder, coverageAmount, premiumAmount, policyStartDate, policyEndDate);
        this.isCommercial = isCommercial;
        this.registrationVerified = registrationVerified;
        this.inspectionVerified = inspectionVerified;
    }

    @Override
    public double calculatePremium() {
        double base = 0.008 * coverageAmount;
        if (isCommercial) base *= 1.2;
        if (!registrationVerified || !inspectionVerified) base *= 1.5;
        return base;
    }

    @Override
    public boolean processClaim(Claim claim) {
        if (!claim.validateClaim(coverageAmount)) return false;
        claim.setClaimStatus("Processed");
        System.out.println("Claim processed for Roadside Assistance Policy.");
        return true;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[RoadsideAssistancePolicy] Policy ID: " + policyId + ", Commercial: " + isCommercial + ", Registration Verified: " + registrationVerified + ", Inspection Verified: " + inspectionVerified);
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
        if (!registrationVerified || !inspectionVerified) {
            System.out.println("Vehicle registration and inspection must be verified.");
            valid = false;
        }
        if (policyStartDate.isAfter(policyEndDate)) {
            System.out.println("Policy start date must be before end date.");
            valid = false;
        }
        return valid;
    }
}
