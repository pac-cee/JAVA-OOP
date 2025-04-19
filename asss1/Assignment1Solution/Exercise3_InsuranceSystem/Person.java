package Assignment1Solution.Exercise3_InsuranceSystem;

import java.time.LocalDate;

public class Person {
    private final String personId;
    private final String fullName;
    private final LocalDate dob;
    private final String email;
    private final String phone;

    public Person(String personId, String fullName, LocalDate dob, String email, String phone) {
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public boolean validatePerson() {
        boolean valid = true;
        if (fullName == null || fullName.isEmpty()) {
            System.out.println("Full name cannot be empty.");
            valid = false;
        }
        if (dob == null || dob.isAfter(LocalDate.now().minusYears(18))) {
            System.out.println("Policyholder must be at least 18 years old.");
            valid = false;
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Invalid email format.");
            valid = false;
        }
        if (phone == null || !phone.matches("\\d{10,15}")) {
            System.out.println("Phone number must be 10-15 digits.");
            valid = false;
        }
        return valid;
    }
    public String getPersonId() { return personId; }
    public String getFullName() { return fullName; }
    // Getters for other fields can be added as needed
}
