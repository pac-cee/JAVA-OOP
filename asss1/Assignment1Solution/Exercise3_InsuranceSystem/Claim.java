package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class Claim {
    private final String claimId;
    private final double claimAmount;
    private final LocalDate claimDate;
    private String claimStatus;

    public Claim(String claimId, double claimAmount, LocalDate claimDate, String claimStatus) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public boolean validateClaim(double coverageLimit) {
        boolean valid = true;
        if (claimAmount <= 0) {
            System.out.println("Claim amount must be positive.");
            valid = false;
        }
        if (claimAmount > coverageLimit) {
            System.out.println("Claim amount exceeds policy coverage limit.");
            valid = false;
        }
        return valid;
    }
    public void setClaimStatus(String status) { this.claimStatus = status; }
    public String getClaimStatus() { return claimStatus; }
    // Getters for other fields can be added as needed
}
