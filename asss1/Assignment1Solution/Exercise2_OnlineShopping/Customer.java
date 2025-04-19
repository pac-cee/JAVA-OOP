package Assignment1Solution.Exercise2_OnlineShopping;

public class Customer {
    private final String customerId;
    private final String customerName;
    private final String email;
    private final String address;
    private final String phone;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public boolean validateCustomer() {
        boolean valid = true;
        if (customerName == null || customerName.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            valid = false;
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Invalid email format.");
            valid = false;
        }
        if (address == null || address.length() < 5) {
            System.out.println("Address is too short or missing.");
            valid = false;
        }
        if (phone == null || !phone.matches("\\d{10,15}")) {
            System.out.println("Phone number must be 10-15 digits.");
            valid = false;
        }
        return valid;
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    // Getters for other fields can be added as needed
}
