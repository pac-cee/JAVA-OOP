// ValidationUtils.java
public final class ValidationUtils {
    private ValidationUtils() {}

    // Basic null/empty checks
    public static void requireNonNull(Object o, String paramName) {
        if (o == null) throw new IllegalArgumentException(paramName + " must not be null");
    }
    public static void requireNonEmpty(String s, String paramName) {
        requireNonNull(s, paramName);
        if (s.trim().isEmpty()) throw new IllegalArgumentException(paramName + " must not be empty");
    }

    // Numeric bounds
    public static void requireInRange(int value, int min, int max, String paramName) {
        if (value < min || value > max)
            throw new IllegalArgumentException(
                String.format("%s must be between %d and %d (was %d)", paramName, min, max, value));
    }
    public static void requireInRange(double value, double min, double max, String paramName) {
        if (value < min || value > max)
            throw new IllegalArgumentException(
                String.format("%s must be between %.2f and %.2f (was %.2f)", paramName, min, max, value));
    }
    public static void requirePositive(int value, String paramName) {
        if (value <= 0) throw new IllegalArgumentException(paramName + " must be > 0 (was " + value + ")");
    }
    public static void requireNonNegative(int value, String paramName) {
        if (value < 0) throw new IllegalArgumentException(paramName + " must be >= 0 (was " + value + ")");
    }

    // Percent/discount (0-100 or 0.0-1.0)
    public static void requirePercentage(double pct, String paramName) {
        requireInRange(pct, 0.0, 100.0, paramName);
    }
    public static void requireFraction(double frac, String paramName) {
        requireInRange(frac, 0.0, 1.0, paramName);
    }

    // Pattern matching
    public static void requireMatch(String s, String regex, String paramName) {
        requireNonNull(s, paramName);
        if (!s.matches(regex)) throw new IllegalArgumentException(paramName + " has invalid format");
    }

    // Common formats
    private static final String NAME_REGEX = "^[A-Za-z\\s'-]{1,50}$";
    public static void requireName(String name, String paramName) { requireMatch(name, NAME_REGEX, paramName); }

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static void requireEmail(String email, String paramName) { requireMatch(email.toUpperCase(), EMAIL_REGEX, paramName); }

    private static final String PHONE_REGEX = "^\\+?[0-9\\-\\s]{7,20}$";
    public static void requirePhone(String phone, String paramName) { requireMatch(phone, PHONE_REGEX, paramName); }

    // Length checks
    public static void requireMinLength(String s, int minLen, String paramName) {
        requireNonNull(s, paramName);
        if (s.length() < minLen) throw new IllegalArgumentException(
            String.format("%s must have at least %d characters (was %d)", paramName, minLen, s.length()));
    }
    public static void requireMaxLength(String s, int maxLen, String paramName) {
        requireNonNull(s, paramName);
        if (s.length() > maxLen) throw new IllegalArgumentException(
            String.format("%s must have at most %d characters (was %d)", paramName, maxLen, s.length()));
    }
}

// Usage Snippet Examples:
/*
// Validate age >0:
ValidationUtils.requirePositive(age, "age");

// Validate discount as percent:
ValidationUtils.requirePercentage(discountPercent, "discountPercent");

// Validate discount as fraction (0.0–1.0):
ValidationUtils.requireFraction(discountFraction, "discountFraction");

// Validate name/email/phone:
ValidationUtils.requireName(name, "name");
ValidationUtils.requireEmail(email, "email");
ValidationUtils.requirePhone(phone, "phone");

// Generic range:
ValidationUtils.requireInRange(quantity, 1, 1000, "quantity");

// String length:
ValidationUtils.requireMinLength(password, 8, "password");
ValidationUtils.requireMaxLength(code, 10, "code");
*/

// === Prompt Template for AI Agent ===
// Use this prompt to have an AI generate validation code snippets for any variable and constraints:
/*
I want you to act as a code generation assistant for input validation routines.
When I give you a variable name, type, and a set of constraints, you will produce:
 1. A descriptive summary of the validation requirements.
 2. A code snippet in Java showing how to enforce those constraints using ValidationUtils or plain logic.
 3. Unit-test style examples demonstrating valid and invalid cases.

Respond in the following JSON format:
{
  "description": "...",
  "codeSnippet": "...",
  "testExamples": [
    { "input": ..., "valid": true|false, "errorMessage": "..." }
  ]
}

Supported constraint keywords:
- nonNull, nonEmpty, positive, nonNegative
- min:<value>, max:<value>, range:<min>-<max>
- percentage, fraction
- regex:<pattern>
- lengthMin:<n>, lengthMax:<n>
- email, phone, name

Example user query:
{"variable":"discountRate","type":"double","constraints":["fraction","nonNegative" ]}
*/




-------------------------------------------------------


I understand you'd like a general set of input validation helpers for common variable types (String, int, double, float) that you can easily adapt to your Java OOP projects. I'll create a reusable ValidationUtils class with common validation methods for names, emails, and age/numeric values.

Here's a comprehensive set of validation utilities you can incorporate into your workflow:

```java
package com.validation.utils;

import java.util.regex.Pattern;

/**
 * Utility class providing common validation methods for various data types.
 * Use these methods to validate input in your Java OOP applications.
 */
public class ValidationUtils {
    // Email validation using regex pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    
    // Name validation - letters, spaces, hyphens, apostrophes
    private static final Pattern NAME_PATTERN = 
        Pattern.compile("^[A-Za-z\\s'-]+$");

    /**
     * Validates if a string is not null or empty
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    /**
     * Validates a name string according to specified requirements
     */
    public static boolean isValidName(String name, int minLength, int maxLength) {
        if (!isNotEmpty(name)) {
            return false;
        }
        
        if (name.length() < minLength || name.length() > maxLength) {
            return false;
        }
        
        return NAME_PATTERN.matcher(name).matches();
    }
    
    /**
     * Validates an email address format
     */
    public static boolean isValidEmail(String email) {
        if (!isNotEmpty(email)) {
            return false;
        }
        
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validates an integer within a specified range
     */
    public static boolean isValidIntRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    
    /**
     * Validates a double within a specified range
     */
    public static boolean isValidDoubleRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
    
    /**
     * Validates a float within a specified range
     */
    public static boolean isValidFloatRange(float value, float min, float max) {
        return value >= min && value <= max;
    }
    
    /**
     * Validates if a string can be parsed as an integer
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates if a string can be parsed as a double
     */
    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates if a string can be parsed as a float
     */
    public static boolean isFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates a string against a custom regex pattern
     */
    public static boolean matchesPattern(String value, String regex) {
        if (!isNotEmpty(value)) {
            return false;
        }
        
        return Pattern.compile(regex).matcher(value).matches();
    }
}
```

Now, let's create a test class to demonstrate how to use these validation methods:

```java
package com.validation.test;

import com.validation.utils.ValidationUtils;

public class ValidationTest {
    public static void main(String[] args) {
        // Name validation examples
        System.out.println("--- Name Validation ---");
        System.out.println("'John Doe': " + ValidationUtils.isValidName("John Doe", 3, 50));
        System.out.println("'A': " + ValidationUtils.isValidName("A", 3, 50)); // Too short
        System.out.println("'John123': " + ValidationUtils.isValidName("John123", 3, 50)); // Contains numbers
        System.out.println("'O'Neil-Smith': " + ValidationUtils.isValidName("O'Neil-Smith", 3, 50)); // Valid with special chars
        
        // Email validation examples
        System.out.println("\n--- Email Validation ---");
        System.out.println("'user@example.com': " + ValidationUtils.isValidEmail("user@example.com"));
        System.out.println("'invalid-email': " + ValidationUtils.isValidEmail("invalid-email"));
        System.out.println("'user@domain.co.uk': " + ValidationUtils.isValidEmail("user@domain.co.uk"));
        
        // Integer range validation
        System.out.println("\n--- Integer Range Validation ---");
        System.out.println("25 (18-65): " + ValidationUtils.isValidIntRange(25, 18, 65));
        System.out.println("17 (18-65): " + ValidationUtils.isValidIntRange(17, 18, 65)); // Too young
        System.out.println("70 (18-65): " + ValidationUtils.isValidIntRange(70, 18, 65)); // Too old
        
        // Double validation
        System.out.println("\n--- Double Validation ---");
        System.out.println("'98.6' is double: " + ValidationUtils.isDouble("98.6"));
        System.out.println("'abc' is double: " + ValidationUtils.isDouble("abc"));
        System.out.println("72.5 (0-100): " + ValidationUtils.isValidDoubleRange(72.5, 0, 100));
        
        // Float validation
        System.out.println("\n--- Float Validation ---");
        System.out.println("3.14 (0-10): " + ValidationUtils.isValidFloatRange(3.14f, 0f, 10f));
        System.out.println("-1.5 (0-10): " + ValidationUtils.isValidFloatRange(-1.5f, 0f, 10f)); // Below range
        
        // Custom pattern matching
        System.out.println("\n--- Custom Pattern Matching ---");
        System.out.println("US Phone '555-123-4567': " + 
                ValidationUtils.matchesPattern("555-123-4567", "\\d{3}-\\d{3}-\\d{4}"));
    }
}
```

## How to Use These Helpers in Your Code

### 1. For name validation:
```java
String name = "John Doe";
if (ValidationUtils.isValidName(name, 2, 50)) {
    // Process valid name
} else {
    throw new IllegalArgumentException("Invalid name format");
}
```

### 2. For email validation:
```java
String email = "user@example.com";
if (ValidationUtils.isValidEmail(email)) {
    // Process valid email
} else {
    throw new IllegalArgumentException("Invalid email format");
}
```

### 3. For age validation:
```java
int age = 25;
if (ValidationUtils.isValidIntRange(age, 18, 65)) {
    // Process valid age
} else {
    throw new IllegalArgumentException("Age must be between 18 and 65");
}
```

### 4. For string-to-number conversion with validation:
```java
String input = "42.5";
if (ValidationUtils.isDouble(input)) {
    double value = Double.parseDouble(input);
    // Process the numeric value
} else {
    throw new IllegalArgumentException("Input must be a valid number");
}
```

These utility methods are designed to be easily adaptable to your specific requirements. You can:
- Modify the regex patterns for more specific validation rules
- Add additional validation methods as needed
- Create domain-specific validation methods that use these base methods

Would you like me to expand on any particular validation type or provide additional examples?








package com.validation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Comprehensive validation utility class for OOP applications.
 * Covers validation for Stock Management, Online Shopping, and Insurance scenarios.
 */
public class ValidationUtils {
    // Common patterns
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\+?[0-9]{10,15}$");
    private static final Pattern NAME_PATTERN = 
        Pattern.compile("^[A-Za-z\\s'-]+$");
    private static final Pattern ALPHANUMERIC_PATTERN = 
        Pattern.compile("^[A-Za-z0-9\\s-]+$");
    
    // Common date format
    private static final DateTimeFormatter DATE_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Validates if a string is not null or empty
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    /**
     * Validates that a value falls within a specified range
     */
    public static boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
    
    /**
     * Validates that a value falls within a specified range
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    
    /**
     * Validates if value is positive
     */
    public static boolean isPositive(double value) {
        return value > 0;
    }
    
    /**
     * Validates if value is positive
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }
    
    /**
     * Validates if value is non-negative
     */
    public static boolean isNonNegative(double value) {
        return value >= 0;
    }
    
    /**
     * Validates if value is non-negative
     */
    public static boolean isNonNegative(int value) {
        return value >= 0;
    }
    
    // =================== STOCK MANAGEMENT VALIDATIONS ===================
    
    /**
     * Validates stock item basic properties
     */
    public static Map<String, String> validateStockItem(String itemId, String itemName, 
                                                     int quantity, double price, 
                                                     String category, String supplier) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(itemId)) {
            errors.put("itemId", "Item ID cannot be empty");
        }
        
        if (!isNotEmpty(itemName)) {
            errors.put("itemName", "Item name cannot be empty");
        }
        
        if (!isNonNegative(quantity)) {
            errors.put("quantity", "Quantity cannot be negative");
        }
        
        if (!isPositive(price)) {
            errors.put("price", "Price must be greater than zero");
        }
        
        if (!isNotEmpty(category)) {
            errors.put("category", "Category cannot be empty");
        }
        
        if (!isNotEmpty(supplier)) {
            errors.put("supplier", "Supplier cannot be empty");
        }
        
        return errors;
    }
    
    /**
     * Validates discount percentage
     */
    public static boolean isValidDiscount(double discountPercentage) {
        return isInRange(discountPercentage, 0, 50);
    }
    
    /**
     * Validates warranty period in months
     */
    public static boolean isValidWarrantyPeriod(int warrantyMonths) {
        return isInRange(warrantyMonths, 0, 60); // 0-60 month warranty
    }
    
    /**
     * Validates expiration date for perishable items
     */
    public static boolean isValidExpirationDate(LocalDate expirationDate) {
        return expirationDate != null && !expirationDate.isBefore(LocalDate.now());
    }
    
    /**
     * Validates if item needs to be flagged for discount (near expiration)
     */
    public static boolean shouldApplyExpirationDiscount(LocalDate expirationDate, int daysThreshold) {
        if (expirationDate == null) {
            return false;
        }
        
        LocalDate thresholdDate = LocalDate.now().plusDays(daysThreshold);
        return !expirationDate.isAfter(thresholdDate) && !expirationDate.isBefore(LocalDate.now());
    }
    
    /**
     * Validates product weight for shipping
     */
    public static boolean isValidProductWeight(double weightKg) {
        return isPositive(weightKg) && weightKg <= 1000; // Max 1000kg
    }
    
    /**
     * Validates supplier information
     */
    public static Map<String, String> validateSupplier(String supplierId, String companyName, 
                                                     String contactPerson, String phone, String email) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(supplierId)) {
            errors.put("supplierId", "Supplier ID cannot be empty");
        }
        
        if (!isNotEmpty(companyName)) {
            errors.put("companyName", "Company name cannot be empty");
        }
        
        if (!isNotEmpty(contactPerson)) {
            errors.put("contactPerson", "Contact person cannot be empty");
        }
        
        if (!isValidPhone(phone)) {
            errors.put("phone", "Invalid phone number format");
        }
        
        if (!isValidEmail(email)) {
            errors.put("email", "Invalid email format");
        }
        
        return errors;
    }
    
    /**
     * Validates warehouse capacity
     */
    public static boolean isValidWarehouseCapacity(int capacity, int currentStock) {
        return isPositive(capacity) && currentStock <= capacity;
    }
    
    // =================== ONLINE SHOPPING VALIDATIONS ===================
    
    /**
     * Validates shopping item basic properties
     */
    public static Map<String, String> validateShoppingItem(String itemId, String itemName, 
                                                        String description, double price, int stock) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(itemId)) {
            errors.put("itemId", "Item ID cannot be empty");
        }
        
        if (!isNotEmpty(itemName)) {
            errors.put("itemName", "Item name cannot be empty");
        }
        
        if (!isNotEmpty(description)) {
            errors.put("description", "Description cannot be empty");
        }
        
        if (!isPositive(price)) {
            errors.put("price", "Price must be greater than zero");
        }
        
        if (!isNonNegative(stock)) {
            errors.put("stock", "Stock cannot be negative");
        }
        
        return errors;
    }
    
    /**
     * Validates customer information
     */
    public static Map<String, String> validateCustomer(String customerId, String customerName, 
                                                     String email, String address, String phone) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(customerId)) {
            errors.put("customerId", "Customer ID cannot be empty");
        }
        
        if (!isNotEmpty(customerName)) {
            errors.put("customerName", "Customer name cannot be empty");
        }
        
        if (!isValidEmail(email)) {
            errors.put("email", "Invalid email format");
        }
        
        if (!isNotEmpty(address)) {
            errors.put("address", "Address cannot be empty");
        }
        
        if (!isValidPhone(phone)) {
            errors.put("phone", "Invalid phone number format");
        }
        
        return errors;
    }
    
    /**
     * Validates cart item quantity against available stock
     */
    public static boolean isValidCartItemQuantity(int requestedQuantity, int availableStock) {
        return isPositive(requestedQuantity) && requestedQuantity <= availableStock;
    }
    
    /**
     * Validates payment method
     */
    public static boolean isValidPaymentMethod(String paymentMethod) {
        if (!isNotEmpty(paymentMethod)) {
            return false;
        }
        
        String method = paymentMethod.toLowerCase().trim();
        return method.equals("credit card") || 
               method.equals("debit card") || 
               method.equals("paypal") || 
               method.equals("bank transfer") ||
               method.equals("cash on delivery");
    }
    
    /**
     * Validates payment amount against order total
     */
    public static boolean isValidPaymentAmount(double amountPaid, double orderTotal) {
        // Allow a small tolerance for floating point arithmetic
        double tolerance = 0.01;
        return Math.abs(amountPaid - orderTotal) <= tolerance;
    }
    
    /**
     * Validates ISBN (International Standard Book Number)
     */
    public static boolean isValidISBN(String isbn) {
        if (!isNotEmpty(isbn)) {
            return false;
        }
        
        // Remove hyphens and spaces
        String cleanedISBN = isbn.replaceAll("[-\\s]", "");
        
        // ISBN-10 validation
        if (cleanedISBN.length() == 10) {
            return validateISBN10(cleanedISBN);
        }
        
        // ISBN-13 validation
        if (cleanedISBN.length() == 13) {
            return validateISBN13(cleanedISBN);
        }
        
        return false;
    }
    
    private static boolean validateISBN10(String isbn) {
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));
                sum += (digit * (10 - i));
            }
            
            // Check digit can be 'X' which represents 10
            char lastChar = isbn.charAt(9);
            int checkDigit = (lastChar == 'X' || lastChar == 'x') ? 10 : Character.getNumericValue(lastChar);
            
            sum += checkDigit;
            return sum % 11 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static boolean validateISBN13(String isbn) {
        try {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));
                sum += (i % 2 == 0) ? digit : digit * 3;
            }
            
            int checkDigit = Character.getNumericValue(isbn.charAt(12));
            int remainder = sum % 10;
            int expectedCheckDigit = (remainder == 0) ? 0 : 10 - remainder;
            
            return checkDigit == expectedCheckDigit;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // =================== INSURANCE VALIDATIONS ===================
    
    /**
     * Validates insurance policy basic properties
     */
    public static Map<String, String> validateInsurancePolicy(String policyId, double coverageAmount, 
                                                         double premiumAmount, LocalDate startDate, 
                                                         LocalDate endDate) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(policyId)) {
            errors.put("policyId", "Policy ID cannot be empty");
        }
        
        if (!isPositive(coverageAmount)) {
            errors.put("coverageAmount", "Coverage amount must be greater than zero");
        }
        
        if (!isPositive(premiumAmount)) {
            errors.put("premiumAmount", "Premium amount must be greater than zero");
        }
        
        if (startDate == null) {
            errors.put("startDate", "Start date cannot be null");
        }
        
        if (endDate == null) {
            errors.put("endDate", "End date cannot be null");
        } else if (startDate != null && !endDate.isAfter(startDate)) {
            errors.put("endDate", "End date must be after start date");
        }
        
        return errors;
    }
    
    /**
     * Validates vehicle information
     */
    public static Map<String, String> validateVehicle(String vehicleId, String make, String model, 
                                                   int year, String type) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(vehicleId)) {
            errors.put("vehicleId", "Vehicle ID cannot be empty");
        }
        
        if (!isNotEmpty(make)) {
            errors.put("make", "Vehicle make cannot be empty");
        }
        
        if (!isNotEmpty(model)) {
            errors.put("model", "Vehicle model cannot be empty");
        }
        
        int currentYear = LocalDate.now().getYear();
        if (!isInRange(year, 1900, currentYear + 1)) { // Allow next year's models
            errors.put("year", "Vehicle year must be between 1900 and " + (currentYear + 1));
        }
        
        if (!isNotEmpty(type)) {
            errors.put("type", "Vehicle type cannot be empty");
        }
        
        return errors;
    }
    
    /**
     * Validates person information for policy holder
     */
    public static Map<String, String> validatePerson(String personId, String fullName, 
                                                  LocalDate dob, String email, String phone) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(personId)) {
            errors.put("personId", "Person ID cannot be empty");
        }
        
        if (!isNotEmpty(fullName)) {
            errors.put("fullName", "Full name cannot be empty");
        }
        
        if (dob == null) {
            errors.put("dob", "Date of birth cannot be null");
        } else if (!dob.isBefore(LocalDate.now().minusYears(18))) {
            errors.put("dob", "Person must be at least 18 years old");
        }
        
        if (!isValidEmail(email)) {
            errors.put("email", "Invalid email format");
        }
        
        if (!isValidPhone(phone)) {
            errors.put("phone", "Invalid phone number format");
        }
        
        return errors;
    }
    
    /**
     * Validates insurance claim
     */
    public static Map<String, String> validateClaim(String claimId, double claimAmount, 
                                                 LocalDate claimDate, double coverageLimit) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isNotEmpty(claimId)) {
            errors.put("claimId", "Claim ID cannot be empty");
        }
        
        if (!isPositive(claimAmount)) {
            errors.put("claimAmount", "Claim amount must be greater than zero");
        } else if (claimAmount > coverageLimit) {
            errors.put("claimAmount", "Claim amount exceeds policy coverage limit");
        }
        
        if (claimDate == null) {
            errors.put("claimDate", "Claim date cannot be null");
        } else if (claimDate.isAfter(LocalDate.now())) {
            errors.put("claimDate", "Claim date cannot be in the future");
        }
        
        return errors;
    }
    
    /**
     * Validates if a date string can be parsed
     */
    public static boolean isValidDateFormat(String dateStr) {
        if (!isNotEmpty(dateStr)) {
            return false;
        }
        
        try {
            LocalDate.parse(dateStr, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    /**
     * Parses a date string to LocalDate
     */
    public static LocalDate parseDate(String dateStr) {
        if (!isValidDateFormat(dateStr)) {
            return null;
        }
        
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
    
    // =================== COMMON VALIDATIONS ===================
    
    /**
     * Validates email format
     */
    public static boolean isValidEmail(String email) {
        if (!isNotEmpty(email)) {
            return false;
        }
        
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validates phone number format
     */
    public static boolean isValidPhone(String phone) {
        if (!isNotEmpty(phone)) {
            return false;
        }
        
        return PHONE_PATTERN.matcher(phone).matches();
    }
    
    /**
     * Validates if a string is a valid name
     */
    public static boolean isValidName(String name) {
        if (!isNotEmpty(name)) {
            return false;
        }
        
        return NAME_PATTERN.matcher(name).matches();
    }
    
    /**
     * Validates if a string is alphanumeric
     */
    public static boolean isAlphanumeric(String text) {
        if (!isNotEmpty(text)) {
            return false;
        }
        
        return ALPHANUMERIC_PATTERN.matcher(text).matches();
    }
    
    /**
     * Validates if a string can be parsed as an integer
     */
    public static boolean isInteger(String value) {
        if (!isNotEmpty(value)) {
            return false;
        }
        
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates if a string can be parsed as a double
     */
    public static boolean isDouble(String value) {
        if (!isNotEmpty(value)) {
            return false;
        }
        
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validates if a string is a valid ID format (alphanumeric with optional hyphens)
     */
    public static boolean isValidId(String id) {
        if (!isNotEmpty(id)) {
            return false;
        }
        
        return id.matches("^[A-Za-z0-9-]+$");
    }
}