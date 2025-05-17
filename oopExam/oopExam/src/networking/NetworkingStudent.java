package networking;

import abstracts.StudentManagement;
import utils.DateUtils;

public class NetworkingStudent extends StudentManagement {
    @Override
    public boolean validateAge() {
        int age = DateUtils.getAgeFromDOB(dateOfBirth);
        return age > 18;
    }

    @Override
    public boolean validateCombination() {
        // Combination must be mce
        return combination != null && combination.equalsIgnoreCase("mce");
    }

    @Override
    public boolean validateMarks() {
        // Marks must be above 70
        return marks > 70;
    }

    @Override
    public double calculateRegistrationFee() {
        double fee = 40000;
        if (isForeignStudent) {
            fee = fee * 0.9;
        }
        return fee;
    }
} 