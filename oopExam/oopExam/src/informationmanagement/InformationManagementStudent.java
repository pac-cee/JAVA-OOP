package informationmanagement;

import abstracts.StudentManagement;
import utils.DateUtils;

public class InformationManagementStudent extends StudentManagement {
    @Override
    public boolean validateAge() {
        int age = DateUtils.getAgeFromDOB(dateOfBirth);
        return age > 18;
    }

    @Override
    public boolean validateMarks() {
        // Marks must be between 50 and 70
        return marks >= 50 && marks <= 70;
    }

    @Override
    public boolean validateCombination() {
        // Combination must be meg
        return combination != null && combination.equalsIgnoreCase("meg");
    }

    @Override
    public double calculateRegistrationFee() {
        double fee = 50000;
        if (isForeignStudent) {
            fee = fee * 0.9;
        }
        return fee;
    }
} 