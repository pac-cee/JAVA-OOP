package foreign;

import abstracts.StudentManagement;
import utils.DateUtils;

public class ForeignStudent extends StudentManagement {
    @Override
    public boolean validateAge() {
        int age = DateUtils.getAgeFromDOB(dateOfBirth);
        return age > 18;
    }

    @Override
    public boolean validateMarks() {
        // No specific marks rule, just must be between 0 and 100
        return marks >= 0 && marks <= 100;
    }

    @Override
    public boolean validateCombination() {
        // No combination validation required for foreign students
        return true;
    }

    @Override
    public double calculateRegistrationFee() {
        // No specific department, so let's assume a base fee (e.g., 50000) with 10% discount
        double fee = 50000;
        if (isForeignStudent) {
            fee = fee * 0.9;
        }
        return fee;
    }
} 