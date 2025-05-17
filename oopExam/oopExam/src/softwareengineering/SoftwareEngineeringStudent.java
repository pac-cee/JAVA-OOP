package softwareengineering;

import abstracts.StudentManagement;
import utils.DateUtils;

public class SoftwareEngineeringStudent extends StudentManagement {
    @Override
    public boolean validateAge() {
        // Age must be above 18
        int age = DateUtils.getAgeFromDOB(dateOfBirth);
        return age > 18;
    }

    @Override
    public boolean validateMarks() {
        // Marks must be above 80
        return marks > 80;
    }

    @Override
    public boolean validateCombination() {
        // Combination must be mpc or mpg
        return combination != null && (combination.equalsIgnoreCase("mpc") || combination.equalsIgnoreCase("mpg"));
    }

    @Override
    public double calculateRegistrationFee() {
        double fee = 30000;
        if (isForeignStudent) {
            fee = fee * 0.9; // 10% discount
        }
        return fee;
    }
} 