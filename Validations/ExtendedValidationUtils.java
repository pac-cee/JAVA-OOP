package Validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Extended validation utility class with comprehensive error messages
 */
public class ExtendedValidationUtils {
    // Regular expression patterns
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern URL_PATTERN = Pattern.compile("^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?$");
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|6(?:011|5[0-9][0-9])[0-9]{12})$");
    private static final Pattern ZIP_CODE_PATTERN = Pattern.compile("^\\d{5}(-\\d{4})?$");
    private static final Pattern IPV4_PATTERN = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
        "^(?=.*[A-Z])" +      // at least one uppercase letter
        "(?=.*[a-z])" +       // at least one lowercase letter
        "(?=.*\\d)" +         // at least one digit
        "(?=.*[@$!%*?&])" +   // at least one special character
        "[A-Za-z\\d@$!%*?&]" + // allowed characters
        "{8,}$"               // minimum 8 characters
    );

    // Additional regex patterns
    private static final Pattern SOCIAL_SECURITY_PATTERN = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");
    private static final Pattern IBAN_PATTERN = Pattern.compile("^[A-Z]{2}\\d{2}[A-Z0-9]{4}\\d{7}([A-Z0-9]?){0,16}$");
    private static final Pattern MAC_ADDRESS_PATTERN = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
    private static final Pattern DOMAIN_NAME_PATTERN = Pattern.compile("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$");
    private static final Pattern BITCOIN_ADDRESS_PATTERN = Pattern.compile("^[13][a-km-zA-HJ-NP-Z1-9]{25,34}$");
    private static final Pattern LICENSE_PLATE_PATTERN = Pattern.compile("^[A-Z]{2}\\s?\\d{3}\\s?[A-Z]{2}$");
    private static final Pattern PASSWORD_COMPLEXITY_PATTERN = Pattern.compile(
        "^(?=.*[0-9])"           // at least one digit
        + "(?=.*[a-z])"         // at least one lowercase
        + "(?=.*[A-Z])"         // at least one uppercase
        + "(?=.*[@#$%^&+=!])"   // at least one special character
        + "(?=\\S+$)"           // no whitespace
        + ".{8,}$"              // at least 8 characters
    );

    // Additional regex patterns for new validations
    private static final Pattern SWIFT_CODE_PATTERN = Pattern.compile("^[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?$");
    private static final Pattern SCIENTIFIC_NOTATION_PATTERN = Pattern.compile("^[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?$");
    private static final Pattern DNA_SEQUENCE_PATTERN = Pattern.compile("^[ATCG]+$");
    private static final Pattern PROTEIN_SEQUENCE_PATTERN = Pattern.compile("^[ACDEFGHIKLMNPQRSTVWY]+$");
    private static final Pattern UPC_PATTERN = Pattern.compile("^\\d{12}$");
    private static final Pattern EAN_PATTERN = Pattern.compile("^\\d{13}$");
    private static final Pattern BLOOD_TYPE_PATTERN = Pattern.compile("^(A|B|AB|O)[+-]$");

    // Additional regex patterns
    private static final Pattern API_KEY_PATTERN = Pattern.compile("^[A-Za-z0-9_-]{32,64}$");
    private static final Pattern HASH_PATTERN = Pattern.compile("^[A-Fa-f0-9]{32,128}$");
    private static final Pattern BASE64_PATTERN = Pattern.compile("^[A-Za-z0-9+/]*={0,2}$");
    private static final Pattern XML_TAG_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9_-]*$");
    private static final Pattern TIMEZONE_PATTERN = Pattern.compile("^[A-Za-z_]+/[A-Za-z_]+(/[A-Za-z_]+)?$");

    // Additional patterns for new validations
    private static final Pattern MIME_TYPE_PATTERN = Pattern.compile("^[a-zA-Z0-9]+/[a-zA-Z0-9.-+]+$");
    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    private static final Pattern SEMVER_PATTERN = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$");

    // Error messages
    private static final String REQUIRED_FIELD_ERROR = "This field is required";
    private static final String INVALID_LENGTH_ERROR = "Length must be between %d and %d characters";
    private static final String INVALID_RANGE_ERROR = "Value must be between %d and %d";
    private static final String INVALID_EMAIL_ERROR = "Invalid email address format";
    private static final String INVALID_PASSWORD_ERROR = "Password must contain at least 8 characters including uppercase, lowercase, number and special character";
    private static final String INVALID_URL_ERROR = "Invalid URL format";
    private static final String INVALID_CREDIT_CARD_ERROR = "Invalid credit card number";
    private static final String INVALID_ZIP_ERROR = "Invalid ZIP code format";
    private static final String INVALID_IP_ERROR = "Invalid IPv4 address";
    private static final String INVALID_COLOR_ERROR = "Invalid hex color code";
    private static final String INVALID_DATE_ERROR = "Invalid date format or date is not valid";
    private static final String FUTURE_DATE_ERROR = "Date cannot be in the future";
    private static final String PAST_DATE_ERROR = "Date cannot be in the past";

    /**
     * Validates text input with length constraints
     */
    public static Map<String, String> validateText(String fieldName, String value, int minLength, int maxLength) {
        Map<String, String> errors = new HashMap<>();
        
        if (value == null || value.trim().isEmpty()) {
            errors.put(fieldName, REQUIRED_FIELD_ERROR);
            return errors;
        }

        int length = value.trim().length();
        if (length < minLength || length > maxLength) {
            errors.put(fieldName, String.format(INVALID_LENGTH_ERROR, minLength, maxLength));
        }

        return errors;
    }

    /**
     * Validates username format and constraints
     */
    public static Map<String, String> validateUsername(String username) {
        Map<String, String> errors = new HashMap<>();
        
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!USERNAME_PATTERN.matcher(username).matches()) {
            errors.put("username", "Username must be 3-20 characters long and contain only letters, numbers, underscores, or hyphens");
        }

        return errors;
    }

    /**
     * Validates password strength and format
     */
    public static Map<String, String> validatePassword(String password) {
        Map<String, String> errors = new HashMap<>();
        
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!STRONG_PASSWORD_PATTERN.matcher(password).matches()) {
            errors.put("password", INVALID_PASSWORD_ERROR);
        }

        return errors;
    }

    /**
     * Validates a password with advanced complexity requirements
     */
    public static Map<String, String> validatePasswordComplexity(String password, int minLength, int maxLength) {
        Map<String, String> errors = new HashMap<>();
        
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "Password cannot be empty");
            return errors;
        }

        if (password.length() < minLength || password.length() > maxLength) {
            errors.put("password", String.format("Password must be between %d and %d characters", minLength, maxLength));
        }

        if (!password.matches(".*[A-Z].*")) {
            errors.put("uppercase", "Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            errors.put("lowercase", "Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*\\d.*")) {
            errors.put("digit", "Password must contain at least one digit");
        }

        if (!password.matches(".*[@#$%^&+=!].*")) {
            errors.put("special", "Password must contain at least one special character (@#$%^&+=!)");
        }

        if (password.contains(" ")) {
            errors.put("whitespace", "Password cannot contain whitespace");
        }

        return errors;
    }

    /**
     * Validates email format
     */
    public static Map<String, String> validateEmail(String email) {
        Map<String, String> errors = new HashMap<>();
        
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            errors.put("email", INVALID_EMAIL_ERROR);
        }

        return errors;
    }

    /**
     * Validates URL format
     */
    public static Map<String, String> validateURL(String url) {
        Map<String, String> errors = new HashMap<>();
        
        if (url == null || url.trim().isEmpty()) {
            errors.put("url", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!URL_PATTERN.matcher(url).matches()) {
            errors.put("url", INVALID_URL_ERROR);
        }

        return errors;
    }

    /**
     * Validates credit card number format and checksum
     */
    public static Map<String, String> validateCreditCard(String cardNumber) {
        Map<String, String> errors = new HashMap<>();
        
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            errors.put("creditCard", REQUIRED_FIELD_ERROR);
            return errors;
        }

        String cleaned = cardNumber.replaceAll("\\s+|-", "");
        if (!CREDIT_CARD_PATTERN.matcher(cleaned).matches() || !isValidLuhn(cleaned)) {
            errors.put("creditCard", INVALID_CREDIT_CARD_ERROR);
        }

        return errors;
    }

    /**
     * Validates numeric range
     */
    public static Map<String, String> validateNumericRange(String fieldName, int value, int min, int max) {
        Map<String, String> errors = new HashMap<>();
        
        if (value < min || value > max) {
            errors.put(fieldName, String.format(INVALID_RANGE_ERROR, min, max));
        }

        return errors;
    }

    /**
     * Validates date format and range
     */
    public static Map<String, String> validateDate(String fieldName, LocalDate date, LocalDate minDate, LocalDate maxDate) {
        Map<String, String> errors = new HashMap<>();
        
        if (date == null) {
            errors.put(fieldName, INVALID_DATE_ERROR);
            return errors;
        }

        if (minDate != null && date.isBefore(minDate)) {
            errors.put(fieldName, "Date cannot be before " + minDate.toString());
        }

        if (maxDate != null && date.isAfter(maxDate)) {
            errors.put(fieldName, "Date cannot be after " + maxDate.toString());
        }

        return errors;
    }

    /**
     * Validates file size
     */
    public static Map<String, String> validateFileSize(String fieldName, long sizeInBytes, long maxSizeInBytes) {
        Map<String, String> errors = new HashMap<>();
        
        if (sizeInBytes > maxSizeInBytes) {
            errors.put(fieldName, String.format("File size exceeds maximum allowed size of %d bytes", maxSizeInBytes));
        }

        return errors;
    }

    /**
     * Validates file size with unit conversion
     */
    public static Map<String, String> validateFileSize(long sizeInBytes, String maxSizeWithUnit) {
        Map<String, String> errors = new HashMap<>();

        try {
            long maxBytes = convertToBytes(maxSizeWithUnit);
            if (sizeInBytes > maxBytes) {
                errors.put("fileSize", String.format("File size exceeds maximum allowed size of %s", maxSizeWithUnit));
            }
        } catch (IllegalArgumentException e) {
            errors.put("maxSize", "Invalid maximum size format");
        }

        return errors;
    }

    /**
     * Converts size with unit (KB, MB, GB) to bytes
     */
    private static long convertToBytes(String sizeWithUnit) {
        String size = sizeWithUnit.replaceAll("\\s+", "").toUpperCase();
        long multiplier = 1;

        if (size.endsWith("KB")) {
            multiplier = 1024L;
            size = size.substring(0, size.length() - 2);
        } else if (size.endsWith("MB")) {
            multiplier = 1024L * 1024L;
            size = size.substring(0, size.length() - 2);
        } else if (size.endsWith("GB")) {
            multiplier = 1024L * 1024L * 1024L;
            size = size.substring(0, size.length() - 2);
        }

        try {
            return Long.parseLong(size) * multiplier;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid size format");
        }
    }

    /**
     * Validates file extension
     */
    public static Map<String, String> validateFileExtension(String fieldName, String fileName, String[] allowedExtensions) {
        Map<String, String> errors = new HashMap<>();
        
        if (fileName == null || fileName.trim().isEmpty()) {
            errors.put(fieldName, REQUIRED_FIELD_ERROR);
            return errors;
        }

        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        boolean valid = false;
        for (String allowedExt : allowedExtensions) {
            if (extension.equals(allowedExt.toLowerCase())) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            errors.put(fieldName, "Invalid file extension. Allowed extensions: " + String.join(", ", allowedExtensions));
        }

        return errors;
    }

    /**
     * Validates phone number format
     */
    public static Map<String, String> validatePhoneNumber(String phone) {
        Map<String, String> errors = new HashMap<>();
        
        if (phone == null || phone.trim().isEmpty()) {
            errors.put("phone", REQUIRED_FIELD_ERROR);
            return errors;
        }

        String cleaned = phone.replaceAll("[\\s()-]", "");
        if (!cleaned.matches("^\\+?[0-9]{10,15}$")) {
            errors.put("phone", "Invalid phone number format");
        }

        return errors;
    }

    /**
     * Validates ZIP code format
     */
    public static Map<String, String> validateZipCode(String zipCode) {
        Map<String, String> errors = new HashMap<>();
        
        if (zipCode == null || zipCode.trim().isEmpty()) {
            errors.put("zipCode", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!ZIP_CODE_PATTERN.matcher(zipCode).matches()) {
            errors.put("zipCode", INVALID_ZIP_ERROR);
        }

        return errors;
    }

    /**
     * Validates IPv4 address format
     */
    public static Map<String, String> validateIPv4(String ip) {
        Map<String, String> errors = new HashMap<>();
        
        if (ip == null || ip.trim().isEmpty()) {
            errors.put("ip", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!IPV4_PATTERN.matcher(ip).matches()) {
            errors.put("ip", INVALID_IP_ERROR);
        }

        return errors;
    }

    /**
     * Validates hex color code format
     */
    public static Map<String, String> validateHexColor(String color) {
        Map<String, String> errors = new HashMap<>();
        
        if (color == null || color.trim().isEmpty()) {
            errors.put("color", REQUIRED_FIELD_ERROR);
            return errors;
        }

        if (!HEX_COLOR_PATTERN.matcher(color).matches()) {
            errors.put("color", INVALID_COLOR_ERROR);
        }

        return errors;
    }

    /**
     * Validates currency amount
     */
    public static Map<String, String> validateCurrencyAmount(String fieldName, double amount, double minAmount, double maxAmount) {
        Map<String, String> errors = new HashMap<>();
        
        if (amount < minAmount || amount > maxAmount) {
            errors.put(fieldName, String.format("Amount must be between %.2f and %.2f", minAmount, maxAmount));
        }

        return errors;
    }

    /**
     * Helper method to implement Luhn algorithm for credit card validation
     */
    private static boolean isValidLuhn(String number) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }

    /**
     * Validates age
     */
    public static Map<String, String> validateAge(int age, int minAge, int maxAge) {
        Map<String, String> errors = new HashMap<>();
        
        if (age < minAge || age > maxAge) {
            errors.put("age", String.format("Age must be between %d and %d years", minAge, maxAge));
        }

        return errors;
    }

    /**
     * Validates percentage value
     */
    public static Map<String, String> validatePercentage(String fieldName, double percentage) {
        Map<String, String> errors = new HashMap<>();
        
        if (percentage < 0 || percentage > 100) {
            errors.put(fieldName, "Percentage must be between 0 and 100");
        }

        return errors;
    }

    /**
     * Validates coordinates (latitude and longitude)
     */
    public static Map<String, String> validateCoordinates(double latitude, double longitude) {
        Map<String, String> errors = new HashMap<>();
        
        if (latitude < -90 || latitude > 90) {
            errors.put("latitude", "Latitude must be between -90 and 90 degrees");
        }
        
        if (longitude < -180 || longitude > 180) {
            errors.put("longitude", "Longitude must be between -180 and 180 degrees");
        }

        return errors;
    }

    /**
     * Validates geographic coordinates
     */
    public static Map<String, String> validateGeoCoordinates(double latitude, double longitude, double elevation) {
        Map<String, String> errors = new HashMap<>();

        if (latitude < -90 || latitude > 90) {
            errors.put("latitude", "Latitude must be between -90 and 90 degrees");
        }

        if (longitude < -180 || longitude > 180) {
            errors.put("longitude", "Longitude must be between -180 and 180 degrees");
        }

        if (elevation < -432 || elevation > 8848) { // Dead Sea to Mount Everest
            errors.put("elevation", "Elevation must be between -432m (Dead Sea) and 8848m (Mount Everest)");
        }

        return errors;
    }

    /**
     * Validates time format (HH:mm)
     */
    public static Map<String, String> validateTime(String time) {
        Map<String, String> errors = new HashMap<>();
        
        if (time == null || time.trim().isEmpty()) {
            errors.put("time", REQUIRED_FIELD_ERROR);
            return errors;
        }

        try {
            DateTimeFormatter.ofPattern("HH:mm").parse(time);
        } catch (DateTimeParseException e) {
            errors.put("time", "Invalid time format. Use HH:mm (24-hour format)");
        }

        return errors;
    }

    /**
     * Validates that a date is within a business hours range
     */
    public static boolean isWithinBusinessHours(LocalDateTime dateTime, int startHour, int endHour) {
        int hour = dateTime.getHour();
        return hour >= startHour && hour < endHour;
    }

    /**
     * Validates version number format (e.g., 1.2.3)
     */
    public static boolean isValidVersionNumber(String version) {
        if (version == null) return false;
        return version.matches("^\\d+(\\.\\d+)*$");
    }

    /**
     * Validates document number format with checksum
     */
    public static boolean isValidDocumentNumber(String docNumber) {
        if (docNumber == null || docNumber.length() != 10) return false;

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(docNumber.charAt(i)) * (10 - i);
            }

            int checksum = (11 - (sum % 11)) % 11;
            int lastDigit = Character.getNumericValue(docNumber.charAt(9));

            return checksum == lastDigit;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates color code in different formats (HEX, RGB, RGBA)
     */
    public static boolean isValidColorCode(String color) {
        if (color == null) return false;

        // HEX format
        if (color.startsWith("#")) {
            return color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
        }

        // RGB format
        if (color.startsWith("rgb")) {
            return color.matches("^rgb\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)$");
        }

        // RGBA format
        if (color.startsWith("rgba")) {
            return color.matches("^rgba\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3}),\\s*([01]\\.?\\d*)\\)$");
        }

        return false;
    }

    /**
     * Validates time range
     */
    public static Map<String, String> validateTimeRange(LocalDateTime startTime, LocalDateTime endTime, int maxDurationHours) {
        Map<String, String> errors = new HashMap<>();

        if (startTime == null) {
            errors.put("startTime", "Start time cannot be null");
            return errors;
        }

        if (endTime == null) {
            errors.put("endTime", "End time cannot be null");
            return errors;
        }

        if (!endTime.isAfter(startTime)) {
            errors.put("timeRange", "End time must be after start time");
        }

        long durationHours = java.time.Duration.between(startTime, endTime).toHours();
        if (durationHours > maxDurationHours) {
            errors.put("duration", String.format("Duration cannot exceed %d hours", maxDurationHours));
        }

        return errors;
    }

    /**
     * Validates JSON Web Token (JWT) format
     */
    public static boolean isValidJWT(String token) {
        if (token == null) return false;
        
        String[] parts = token.split("\\.");
        if (parts.length != 3) return false;

        // Validate each part is Base64 encoded
        for (String part : parts) {
            if (!part.matches("^[A-Za-z0-9-_]*$")) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates medical record number format
     */
    public static boolean isValidMedicalRecordNumber(String mrn) {
        if (mrn == null || mrn.length() != 8) return false;

        // Format: 2 letters followed by 6 digits
        return mrn.matches("^[A-Z]{2}\\d{6}$");
    }

    /**
     * Validates image dimensions
     */
    public static Map<String, String> validateImageDimensions(int width, int height, int maxWidth, int maxHeight, int minWidth, int minHeight) {
        Map<String, String> errors = new HashMap<>();

        if (width < minWidth || width > maxWidth) {
            errors.put("width", String.format("Width must be between %d and %d pixels", minWidth, maxWidth));
        }

        if (height < minHeight || height > maxHeight) {
            errors.put("height", String.format("Height must be between %d and %d pixels", minHeight, maxHeight));
        }

        // Check aspect ratio if needed
        double aspectRatio = (double) width / height;
        if (aspectRatio < 0.5 || aspectRatio > 2.0) {
            errors.put("aspectRatio", "Image aspect ratio must be between 0.5 and 2.0");
        }

        return errors;
    }

    /**
     * Validates Social Security Number (SSN) format
     */
    public static boolean isValidSSN(String ssn) {
        return ssn != null && SOCIAL_SECURITY_PATTERN.matcher(ssn).matches();
    }

    /**
     * Validates International Bank Account Number (IBAN)
     */
    public static boolean isValidIBAN(String iban) {
        return iban != null && IBAN_PATTERN.matcher(iban).matches();
    }

    /**
     * Validates MAC address format
     */
    public static boolean isValidMACAddress(String macAddress) {
        return macAddress != null && MAC_ADDRESS_PATTERN.matcher(macAddress).matches();
    }

    /**
     * Validates domain name format
     */
    public static boolean isValidDomainName(String domain) {
        return domain != null && DOMAIN_NAME_PATTERN.matcher(domain).matches();
    }

    /**
     * Validates Bitcoin address format
     */
    public static boolean isValidBitcoinAddress(String address) {
        return address != null && BITCOIN_ADDRESS_PATTERN.matcher(address).matches();
    }

    /**
     * Validates vehicle license plate format
     */
    public static boolean isValidLicensePlate(String plate) {
        return plate != null && LICENSE_PLATE_PATTERN.matcher(plate).matches();
    }

    /**
     * Validates a list of URLs
     */
    public static Map<String, String> validateURLList(List<String> urls) {
        Map<String, String> errors = new HashMap<>();
        
        if (urls == null || urls.isEmpty()) {
            errors.put("urls", "URL list cannot be empty");
            return errors;
        }

        for (int i = 0; i < urls.size(); i++) {
            try {
                new URL(urls.get(i));
            } catch (MalformedURLException e) {
                errors.put("url_" + i, "Invalid URL format: " + urls.get(i));
            }
        }

        return errors;
    }

    /**
     * Validates SWIFT/BIC code format
     */
    public static boolean isValidSWIFTCode(String swiftCode) {
        return swiftCode != null && SWIFT_CODE_PATTERN.matcher(swiftCode).matches();
    }

    /**
     * Validates scientific notation format
     */
    public static boolean isValidScientificNotation(String number) {
        return number != null && SCIENTIFIC_NOTATION_PATTERN.matcher(number).matches();
    }

    /**
     * Validates DNA sequence
     */
    public static boolean isValidDNASequence(String sequence) {
        return sequence != null && DNA_SEQUENCE_PATTERN.matcher(sequence).matches();
    }

    /**
     * Validates protein sequence
     */
    public static boolean isValidProteinSequence(String sequence) {
        return sequence != null && PROTEIN_SEQUENCE_PATTERN.matcher(sequence).matches();
    }

    /**
     * Validates UPC (Universal Product Code)
     */
    public static boolean isValidUPC(String upc) {
        if (upc == null || !UPC_PATTERN.matcher(upc).matches()) {
            return false;
        }
        return validateCheckDigit(upc, 12);
    }

    /**
     * Validates EAN (European Article Number)
     */
    public static boolean isValidEAN(String ean) {
        if (ean == null || !EAN_PATTERN.matcher(ean).matches()) {
            return false;
        }
        return validateCheckDigit(ean, 13);
    }

    /**
     * Helper method for UPC/EAN check digit validation
     */
    private static boolean validateCheckDigit(String code, int length) {
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit == Character.getNumericValue(code.charAt(length - 1));
    }

    /**
     * Validates blood type format
     */
    public static boolean isValidBloodType(String bloodType) {
        return bloodType != null && BLOOD_TYPE_PATTERN.matcher(bloodType).matches();
    }

    /**
     * Validates monetary amount with currency
     */
    public static Map<String, String> validateMonetaryAmount(BigDecimal amount, String currency, BigDecimal minAmount, BigDecimal maxAmount) {
        Map<String, String> errors = new HashMap<>();
        
        if (amount == null) {
            errors.put("amount", "Amount cannot be null");
            return errors;
        }

        if (currency == null || currency.trim().isEmpty()) {
            errors.put("currency", "Currency code cannot be empty");
        } else if (!currency.matches("^[A-Z]{3}$")) {
            errors.put("currency", "Invalid currency code format (must be 3 uppercase letters)");
        }

        if (minAmount != null && amount.compareTo(minAmount) < 0) {
            errors.put("amount", String.format("Amount must be at least %s %s", minAmount.toString(), currency));
        }

        if (maxAmount != null && amount.compareTo(maxAmount) > 0) {
            errors.put("amount", String.format("Amount cannot exceed %s %s", maxAmount.toString(), currency));
        }

        // Validate decimal places based on currency
        int scale = amount.scale();
        if (scale > 2 && !currency.equals("BTC") && !currency.equals("ETH")) {
            errors.put("amount", "Invalid number of decimal places for currency " + currency);
        }

        return errors;
    }

    /**
     * Validates product dimensions and weight for shipping
     */
    public static Map<String, String> validateProductDimensions(double length, double width, double height, double weight) {
        Map<String, String> errors = new HashMap<>();
        
        // Standard shipping constraints
        final double MAX_LENGTH = 274.0; // 9 feet in cm
        final double MAX_GIRTH = 330.0; // 11 feet in cm
        final double MAX_WEIGHT = 68.0; // 150 pounds in kg

        if (length <= 0 || width <= 0 || height <= 0) {
            errors.put("dimensions", "All dimensions must be greater than zero");
        }

        if (length > MAX_LENGTH) {
            errors.put("length", String.format("Length cannot exceed %.2f cm", MAX_LENGTH));
        }

        double girth = 2 * (width + height);
        if (girth > MAX_GIRTH) {
            errors.put("girth", String.format("Package girth (2 × (width + height)) cannot exceed %.2f cm", MAX_GIRTH));
        }

        if (weight <= 0) {
            errors.put("weight", "Weight must be greater than zero");
        } else if (weight > MAX_WEIGHT) {
            errors.put("weight", String.format("Weight cannot exceed %.2f kg", MAX_WEIGHT));
        }

        return errors;
    }

    /**
     * Validates statistical significance (p-value)
     */
    public static Map<String, String> validatePValue(double pValue) {
        Map<String, String> errors = new HashMap<>();
        
        if (pValue < 0 || pValue > 1) {
            errors.put("pValue", "P-value must be between 0 and 1");
        }

        return errors;
    }

    /**
     * Validates confidence interval
     */
    public static Map<String, String> validateConfidenceInterval(double lowerBound, double upperBound, double confidenceLevel) {
        Map<String, String> errors = new HashMap<>();
        
        if (confidenceLevel <= 0 || confidenceLevel >= 100) {
            errors.put("confidenceLevel", "Confidence level must be between 0 and 100");
        }

        if (lowerBound >= upperBound) {
            errors.put("interval", "Lower bound must be less than upper bound");
        }

        return errors;
    }

    /**
     * Validates medical measurements (vital signs)
     */
    public static Map<String, String> validateVitalSigns(double temperature, int heartRate, int bloodPressureSystolic, 
                                                        int bloodPressureDiastolic, int respiratoryRate) {
        Map<String, String> errors = new HashMap<>();
        
        // Temperature (in Celsius)
        if (temperature < 35 || temperature > 42) {
            errors.put("temperature", "Temperature must be between 35°C and 42°C");
        }

        // Heart rate (beats per minute)
        if (heartRate < 40 || heartRate > 200) {
            errors.put("heartRate", "Heart rate must be between 40 and 200 bpm");
        }

        // Blood pressure
        if (bloodPressureSystolic < 70 || bloodPressureSystolic > 200) {
            errors.put("bloodPressureSystolic", "Systolic pressure must be between 70 and 200 mmHg");
        }
        if (bloodPressureDiastolic < 40 || bloodPressureDiastolic > 130) {
            errors.put("bloodPressureDiastolic", "Diastolic pressure must be between 40 and 130 mmHg");
        }
        if (bloodPressureSystolic <= bloodPressureDiastolic) {
            errors.put("bloodPressure", "Systolic pressure must be greater than diastolic pressure");
        }

        // Respiratory rate (breaths per minute)
        if (respiratoryRate < 8 || respiratoryRate > 40) {
            errors.put("respiratoryRate", "Respiratory rate must be between 8 and 40 breaths per minute");
        }

        return errors;
    }

    /**
     * Validates research sample size
     */
    public static Map<String, String> validateSampleSize(int sampleSize, int populationSize, double confidenceLevel, double marginOfError) {
        Map<String, String> errors = new HashMap<>();
        
        if (sampleSize <= 0) {
            errors.put("sampleSize", "Sample size must be greater than zero");
        }

        if (populationSize > 0 && sampleSize > populationSize) {
            errors.put("sampleSize", "Sample size cannot be larger than population size");
        }

        if (confidenceLevel <= 0 || confidenceLevel >= 100) {
            errors.put("confidenceLevel", "Confidence level must be between 0 and 100");
        }

        if (marginOfError <= 0 || marginOfError >= 100) {
            errors.put("marginOfError", "Margin of error must be between 0 and 100");
        }

        return errors;
    }

    /**
     * Validates exchange rate
     */
    public static Map<String, String> validateExchangeRate(String fromCurrency, String toCurrency, BigDecimal rate) {
        Map<String, String> errors = new HashMap<>();
        
        if (!fromCurrency.matches("^[A-Z]{3}$")) {
            errors.put("fromCurrency", "Invalid source currency code");
        }

        if (!toCurrency.matches("^[A-Z]{3}$")) {
            errors.put("toCurrency", "Invalid target currency code");
        }

        if (rate == null || rate.compareTo(BigDecimal.ZERO) <= 0) {
            errors.put("rate", "Exchange rate must be greater than zero");
        }

        if (fromCurrency.equals(toCurrency)) {
            errors.put("currency", "Source and target currencies cannot be the same");
        }

        return errors;
    }

    /**
     * Validates API key format
     */
    public static Map<String, String> validateAPIKey(String apiKey) {
        Map<String, String> errors = new HashMap<>();
        
        if (apiKey == null || apiKey.trim().isEmpty()) {
            errors.put("apiKey", "API key cannot be empty");
            return errors;
        }

        if (!API_KEY_PATTERN.matcher(apiKey).matches()) {
            errors.put("apiKey", "Invalid API key format");
        }

        return errors;
    }

    /**
     * Validates hash value format (MD5, SHA-1, SHA-256, etc.)
     */
    public static Map<String, String> validateHashValue(String hash, String algorithm) {
        Map<String, String> errors = new HashMap<>();
        
        if (hash == null || hash.trim().isEmpty()) {
            errors.put("hash", "Hash value cannot be empty");
            return errors;
        }

        int expectedLength;
        switch (algorithm.toUpperCase()) {
            case "MD5":
                expectedLength = 32;
                break;
            case "SHA1":
                expectedLength = 40;
                break;
            case "SHA256":
                expectedLength = 64;
                break;
            case "SHA512":
                expectedLength = 128;
                break;
            default:
                errors.put("algorithm", "Unsupported hash algorithm");
                return errors;
        }

        if (hash.length() != expectedLength || !HASH_PATTERN.matcher(hash).matches()) {
            errors.put("hash", "Invalid " + algorithm + " hash format");
        }

        return errors;
    }

    /**
     * Validates Base64 encoded string
     */
    public static boolean isValidBase64(String base64) {
        return base64 != null && BASE64_PATTERN.matcher(base64).matches();
    }

    /**
     * Validates XML tag name
     */
    public static boolean isValidXMLTagName(String tagName) {
        return tagName != null && XML_TAG_PATTERN.matcher(tagName).matches();
    }

    /**
     * Validates timezone format
     */
    public static boolean isValidTimezone(String timezone) {
        return timezone != null && TIMEZONE_PATTERN.matcher(timezone).matches();
    }

    /**
     * Validates authentication token expiry
     */
    public static Map<String, String> validateTokenExpiry(LocalDateTime expiryTime, int minMinutes, int maxDays) {
        Map<String, String> errors = new HashMap<>();
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime minExpiry = now.plusMinutes(minMinutes);
        LocalDateTime maxExpiry = now.plusDays(maxDays);

        if (expiryTime.isBefore(minExpiry)) {
            errors.put("expiry", String.format("Token expiry must be at least %d minutes from now", minMinutes));
        }

        if (expiryTime.isAfter(maxExpiry)) {
            errors.put("expiry", String.format("Token expiry cannot exceed %d days from now", maxDays));
        }

        return errors;
    }

    /**
     * Validates session timeout duration
     */
    public static Map<String, String> validateSessionTimeout(int timeoutMinutes) {
        Map<String, String> errors = new HashMap<>();
        
        if (timeoutMinutes < 5) {
            errors.put("timeout", "Session timeout must be at least 5 minutes");
        }

        if (timeoutMinutes > 1440) { // 24 hours
            errors.put("timeout", "Session timeout cannot exceed 24 hours");
        }

        return errors;
    }

    /**
     * Validates rate limit configuration
     */
    public static Map<String, String> validateRateLimit(int maxRequests, int timeWindowSeconds) {
        Map<String, String> errors = new HashMap<>();
        
        if (maxRequests <= 0) {
            errors.put("maxRequests", "Maximum requests must be greater than zero");
        }

        if (timeWindowSeconds < 1 || timeWindowSeconds > 86400) { // 24 hours
            errors.put("timeWindow", "Time window must be between 1 second and 24 hours");
        }

        return errors;
    }

    /**
     * Validates data retention period
     */
    public static Map<String, String> validateDataRetention(int retentionDays, String dataType) {
        Map<String, String> errors = new HashMap<>();
        
        // Different retention requirements for different data types
        switch (dataType.toLowerCase()) {
            case "logs":
                if (retentionDays < 30 || retentionDays > 365) {
                    errors.put("retention", "Log retention must be between 30 and 365 days");
                }
                break;
            case "user_data":
                if (retentionDays < 1 || retentionDays > 730) { // 2 years
                    errors.put("retention", "User data retention must be between 1 and 730 days");
                }
                break;
            case "backups":
                if (retentionDays < 7 || retentionDays > 1825) { // 5 years
                    errors.put("retention", "Backup retention must be between 7 and 1825 days");
                }
                break;
            default:
                errors.put("dataType", "Unknown data type for retention policy");
        }

        return errors;
    }

    /**
     * Validates encryption key strength
     */
    public static Map<String, String> validateEncryptionKey(int keyLength, String algorithm) {
        Map<String, String> errors = new HashMap<>();
        
        switch (algorithm.toUpperCase()) {
            case "AES":
                if (keyLength != 128 && keyLength != 192 && keyLength != 256) {
                    errors.put("keyLength", "AES key length must be 128, 192, or 256 bits");
                }
                break;
            case "RSA":
                if (keyLength < 2048 || keyLength > 4096) {
                    errors.put("keyLength", "RSA key length must be between 2048 and 4096 bits");
                }
                break;
            default:
                errors.put("algorithm", "Unsupported encryption algorithm");
        }

        return errors;
    }

    /**
     * Validates digital certificate attributes
     */
    public static Map<String, String> validateCertificateAttributes(String commonName, LocalDate validFrom, 
                                                                   LocalDate validTo, String signatureAlgorithm) {
        Map<String, String> errors = new HashMap<>();
        
        if (!isValidDomainName(commonName) && !commonName.matches("^[A-Za-z0-9\\s,.-]+$")) {
            errors.put("commonName", "Invalid certificate common name");
        }

        LocalDate now = LocalDate.now();
        if (validFrom.isAfter(validTo)) {
            errors.put("validity", "Certificate start date must be before end date");
        }

        if (validTo.isBefore(now.plusMonths(1))) {
            errors.put("validTo", "Certificate must be valid for at least 1 month");
        }

        if (validTo.isAfter(now.plusYears(2))) {
            errors.put("validTo", "Certificate validity cannot exceed 2 years");
        }

        Set<String> validAlgorithms = new HashSet<>(Arrays.asList(
            "SHA256WITHRSA", "SHA384WITHRSA", "SHA512WITHRSA",
            "SHA256WITHECDSA", "SHA384WITHECDSA", "SHA512WITHECDSA"
        ));
        
        if (!validAlgorithms.contains(signatureAlgorithm.toUpperCase())) {
            errors.put("algorithm", "Invalid or weak signature algorithm");
        }

        return errors;
    }

    /**
     * Validates MIME type format
     */
    public static boolean isValidMimeType(String mimeType) {
        return mimeType != null && MIME_TYPE_PATTERN.matcher(mimeType).matches();
    }

    /**
     * Validates UUID format
     */
    public static boolean isValidUUID(String uuid) {
        return uuid != null && UUID_PATTERN.matcher(uuid).matches();
    }

    /**
     * Validates semantic version (SemVer)
     */
    public static boolean isValidSemVer(String version) {
        return version != null && SEMVER_PATTERN.matcher(version).matches();
    }

    /**
     * Validates video properties
     */
    public static Map<String, String> validateVideoProperties(
            int width, int height, double duration, long bitrate, String codec) {
        Map<String, String> errors = new HashMap<>();
        
        // Resolution validation
        if (width < 144 || width > 7680) { // From lowest mobile to 8K
            errors.put("width", "Video width must be between 144 and 7680 pixels");
        }
        if (height < 144 || height > 4320) {
            errors.put("height", "Video height must be between 144 and 4320 pixels");
        }

        // Duration validation (in seconds)
        if (duration <= 0 || duration > 14400) { // Max 4 hours
            errors.put("duration", "Video duration must be between 0 and 14400 seconds");
        }

        // Bitrate validation (in bits per second)
        if (bitrate < 100000 || bitrate > 800000000) { // 100Kbps to 800Mbps
            errors.put("bitrate", "Video bitrate must be between 100Kbps and 800Mbps");
        }

        // Codec validation
        Set<String> supportedCodecs = new HashSet<>(Arrays.asList(
            "H.264", "H.265", "VP8", "VP9", "AV1"
        ));
        if (!supportedCodecs.contains(codec)) {
            errors.put("codec", "Unsupported video codec");
        }

        return errors;
    }

    /**
     * Validates audio properties
     */
    public static Map<String, String> validateAudioProperties(
            int sampleRate, int bitDepth, int channels, String format) {
        Map<String, String> errors = new HashMap<>();
        
        // Sample rate validation (in Hz)
        Set<Integer> validSampleRates = new HashSet<>(Arrays.asList(
            8000, 11025, 16000, 22050, 32000, 44100, 48000, 88200, 96000, 192000
        ));
        if (!validSampleRates.contains(sampleRate)) {
            errors.put("sampleRate", "Invalid sample rate");
        }

        // Bit depth validation
        Set<Integer> validBitDepths = new HashSet<>(Arrays.asList(8, 16, 24, 32));
        if (!validBitDepths.contains(bitDepth)) {
            errors.put("bitDepth", "Invalid bit depth");
        }

        // Channel validation
        if (channels < 1 || channels > 8) {
            errors.put("channels", "Number of channels must be between 1 and 8");
        }

        // Format validation
        Set<String> validFormats = new HashSet<>(Arrays.asList(
            "WAV", "MP3", "AAC", "FLAC", "OGG", "OPUS"
        ));
        if (!validFormats.contains(format.toUpperCase())) {
            errors.put("format", "Unsupported audio format");
        }

        return errors;
    }

    /**
     * Validates access control configuration
     */
    public static Map<String, String> validateAccessControl(
            List<String> permissions, String resourceType, String accessLevel) {
        Map<String, String> errors = new HashMap<>();
        
        if (permissions == null || permissions.isEmpty()) {
            errors.put("permissions", "At least one permission must be specified");
            return errors;
        }

        // Validate each permission format
        Set<String> validPermissions = new HashSet<>(Arrays.asList(
            "READ", "WRITE", "DELETE", "EXECUTE", "ADMIN"
        ));
        for (String permission : permissions) {
            if (!validPermissions.contains(permission.toUpperCase())) {
                errors.put("permission", "Invalid permission: " + permission);
            }
        }

        // Validate resource type
        Set<String> validResourceTypes = new HashSet<>(Arrays.asList(
            "FILE", "DIRECTORY", "DATABASE", "API", "SERVICE"
        ));
        if (!validResourceTypes.contains(resourceType.toUpperCase())) {
            errors.put("resourceType", "Invalid resource type");
        }

        // Validate access level
        Set<String> validAccessLevels = new HashSet<>(Arrays.asList(
            "PUBLIC", "PRIVATE", "PROTECTED", "INTERNAL"
        ));
        if (!validAccessLevels.contains(accessLevel.toUpperCase())) {
            errors.put("accessLevel", "Invalid access level");
        }

        return errors;
    }

    /**
     * Validates database connection configuration
     */
    public static Map<String, String> validateDatabaseConfig(
            String host, int port, String database, String username, 
            String password, String dbType, int maxConnections) {
        Map<String, String> errors = new HashMap<>();
        
        // Host validation
        if (!isValidDomainName(host) && !IPV4_PATTERN.matcher(host).matches()) {
            errors.put("host", "Invalid database host");
        }

        // Port validation
        if (port < 1 || port > 65535) {
            errors.put("port", "Port must be between 1 and 65535");
        }

        // Database name validation
        if (!database.matches("^[a-zA-Z0-9_-]{1,64}$")) {
            errors.put("database", "Invalid database name");
        }

        // Username validation
        if (!username.matches("^[a-zA-Z0-9_-]{1,32}$")) {
            errors.put("username", "Invalid username format");
        }

        // Password strength validation
        if (password.length() < 8 || !PASSWORD_COMPLEXITY_PATTERN.matcher(password).matches()) {
            errors.put("password", "Password does not meet security requirements");
        }

        // Database type validation
        Set<String> validDbTypes = new HashSet<>(Arrays.asList(
            "MYSQL", "POSTGRESQL", "MONGODB", "ORACLE", "SQLSERVER"
        ));
        if (!validDbTypes.contains(dbType.toUpperCase())) {
            errors.put("dbType", "Unsupported database type");
        }

        // Connection pool validation
        if (maxConnections < 1 || maxConnections > 1000) {
            errors.put("maxConnections", "Maximum connections must be between 1 and 1000");
        }

        return errors;
    }

    /**
     * Validates cache configuration
     */
    public static Map<String, String> validateCacheConfig(
            String cacheType, int maxSize, int expirationSeconds, 
            String evictionPolicy) {
        Map<String, String> errors = new HashMap<>();
        
        // Cache type validation
        Set<String> validCacheTypes = new HashSet<>(Arrays.asList(
            "MEMORY", "REDIS", "MEMCACHED", "HAZELCAST"
        ));
        if (!validCacheTypes.contains(cacheType.toUpperCase())) {
            errors.put("cacheType", "Unsupported cache type");
        }

        // Cache size validation
        if (maxSize < 1 || maxSize > 1000000) {
            errors.put("maxSize", "Cache size must be between 1 and 1,000,000 entries");
        }

        // Expiration time validation
        if (expirationSeconds < 0 || expirationSeconds > 2592000) { // Max 30 days
            errors.put("expiration", "Expiration time must be between 0 and 2,592,000 seconds");
        }

        // Eviction policy validation
        Set<String> validPolicies = new HashSet<>(Arrays.asList(
            "LRU", "LFU", "FIFO", "RANDOM", "NONE"
        ));
        if (!validPolicies.contains(evictionPolicy.toUpperCase())) {
            errors.put("evictionPolicy", "Invalid eviction policy");
        }

        return errors;
    }

    /**
     * Validates load balancer configuration
     */
    public static Map<String, String> validateLoadBalancerConfig(
            String algorithm, int serverCount, int healthCheckInterval, 
            int timeout, String protocol) {
        Map<String, String> errors = new HashMap<>();
        
        // Algorithm validation
        Set<String> validAlgorithms = new HashSet<>(Arrays.asList(
            "ROUND_ROBIN", "LEAST_CONNECTIONS", "IP_HASH", "WEIGHTED_ROUND_ROBIN"
        ));
        if (!validAlgorithms.contains(algorithm.toUpperCase())) {
            errors.put("algorithm", "Invalid load balancing algorithm");
        }

        // Server count validation
        if (serverCount < 1 || serverCount > 1000) {
            errors.put("serverCount", "Server count must be between 1 and 1000");
        }

        // Health check interval validation (in seconds)
        if (healthCheckInterval < 1 || healthCheckInterval > 300) {
            errors.put("healthCheckInterval", "Health check interval must be between 1 and 300 seconds");
        }

        // Timeout validation (in milliseconds)
        if (timeout < 100 || timeout > 60000) {
            errors.put("timeout", "Timeout must be between 100ms and 60000ms");
        }

        // Protocol validation
        Set<String> validProtocols = new HashSet<>(Arrays.asList(
            "HTTP", "HTTPS", "TCP", "UDP"
        ));
        if (!validProtocols.contains(protocol.toUpperCase())) {
            errors.put("protocol", "Invalid protocol");
        }

        return errors;
    }

    /**
     * Validates API endpoint configuration
     */
    public static Map<String, String> validateAPIEndpoint(
            String endpoint, String method, List<String> requiredParams, 
            int rateLimit, int timeoutMs) {
        Map<String, String> errors = new HashMap<>();
        
        // Endpoint format validation
        if (!endpoint.startsWith("/") || endpoint.contains("//")) {
            errors.put("endpoint", "Invalid endpoint format. Must start with '/' and not contain '//'");
        }

        // HTTP method validation
        Set<String> validMethods = new HashSet<>(Arrays.asList(
            "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS"
        ));
        if (!validMethods.contains(method.toUpperCase())) {
            errors.put("method", "Invalid HTTP method");
        }

        // Required parameters validation
        if (requiredParams != null) {
            for (String param : requiredParams) {
                if (!param.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
                    errors.put("param_" + param, "Invalid parameter name format: " + param);
                }
            }
        }

        // Rate limit validation
        if (rateLimit < 1 || rateLimit > 10000) {
            errors.put("rateLimit", "Rate limit must be between 1 and 10000 requests per minute");
        }

        // Timeout validation
        if (timeoutMs < 100 || timeoutMs > 30000) {
            errors.put("timeout", "Timeout must be between 100ms and 30000ms");
        }

        return errors;
    }

    /**
     * Validates OAuth2 configuration
     */
    public static Map<String, String> validateOAuth2Config(
            String clientId, String clientSecret, List<String> scopes, 
            String grantType, int tokenExpirySeconds) {
        Map<String, String> errors = new HashMap<>();
        
        // Client ID validation
        if (!clientId.matches("^[a-zA-Z0-9-._~+/]{8,32}$")) {
            errors.put("clientId", "Invalid client ID format");
        }

        // Client secret validation
        if (!clientSecret.matches("^[a-zA-Z0-9-._~+/]{32,64}$")) {
            errors.put("clientSecret", "Invalid client secret format");
        }

        // Scopes validation
        Set<String> validScopes = new HashSet<>(Arrays.asList(
            "read", "write", "admin", "user", "profile", "email"
        ));
        if (scopes != null) {
            for (String scope : scopes) {
                if (!validScopes.contains(scope.toLowerCase())) {
                    errors.put("scope_" + scope, "Invalid scope: " + scope);
                }
            }
        }

        // Grant type validation
        Set<String> validGrantTypes = new HashSet<>(Arrays.asList(
            "authorization_code", "client_credentials", "password", "refresh_token"
        ));
        if (!validGrantTypes.contains(grantType.toLowerCase())) {
            errors.put("grantType", "Invalid grant type");
        }

        // Token expiry validation
        if (tokenExpirySeconds < 300 || tokenExpirySeconds > 86400) {
            errors.put("tokenExpiry", "Token expiry must be between 5 minutes and 24 hours");
        }

        return errors;
    }

    /**
     * Validates Webhook configuration
     */
    public static Map<String, String> validateWebhookConfig(
            String url, List<String> events, String secretKey, 
            int retryCount, int retryIntervalSeconds) {
        Map<String, String> errors = new HashMap<>();
        
        // URL validation
        try {
            new URL(url);
            if (!url.startsWith("https://")) {
                errors.put("url", "Webhook URL must use HTTPS");
            }
        } catch (MalformedURLException e) {
            errors.put("url", "Invalid webhook URL");
        }

        // Events validation
        Set<String> validEvents = new HashSet<>(Arrays.asList(
            "created", "updated", "deleted", "status_changed",
            "payment_received", "order_shipped", "user_registered"
        ));
        if (events != null) {
            for (String event : events) {
                if (!validEvents.contains(event.toLowerCase())) {
                    errors.put("event_" + event, "Invalid event type: " + event);
                }
            }
        }

        // Secret key validation
        if (secretKey.length() < 32 || !secretKey.matches("^[A-Za-z0-9+/=]+$")) {
            errors.put("secretKey", "Secret key must be at least 32 characters long and base64 encoded");
        }

        // Retry configuration validation
        if (retryCount < 0 || retryCount > 10) {
            errors.put("retryCount", "Retry count must be between 0 and 10");
        }

        if (retryIntervalSeconds < 60 || retryIntervalSeconds > 3600) {
            errors.put("retryInterval", "Retry interval must be between 1 minute and 1 hour");
        }

        return errors;
    }

    /**
     * Validates API response configuration
     */
    public static Map<String, String> validateAPIResponse(
            int statusCode, String contentType, long maxResponseSize, 
            boolean requireAuthentication) {
        Map<String, String> errors = new HashMap<>();
        
        // Status code validation
        if (statusCode < 100 || statusCode > 599) {
            errors.put("statusCode", "Invalid HTTP status code");
        }

        // Content type validation
        Set<String> validContentTypes = new HashSet<>(Arrays.asList(
            "application/json", "application/xml", "text/plain",
            "text/html", "application/octet-stream"
        ));
        if (!validContentTypes.contains(contentType.toLowerCase())) {
            errors.put("contentType", "Unsupported content type");
        }

        // Response size validation
        if (maxResponseSize < 0 || maxResponseSize > 10485760) { // 10MB
            errors.put("maxResponseSize", "Response size must be between 0 and 10MB");
        }

        return errors;
    }

    /**
     * Validates service health check configuration
     */
    public static Map<String, String> validateHealthCheckConfig(
            String endpoint, int intervalSeconds, int timeoutMs, 
            int failureThreshold, List<Integer> successCodes) {
        Map<String, String> errors = new HashMap<>();
        
        // Endpoint validation
        if (!endpoint.startsWith("/health") && !endpoint.startsWith("/status")) {
            errors.put("endpoint", "Health check endpoint should start with /health or /status");
        }

        // Interval validation
        if (intervalSeconds < 5 || intervalSeconds > 300) {
            errors.put("interval", "Health check interval must be between 5 and 300 seconds");
        }

        // Timeout validation
        if (timeoutMs < 100 || timeoutMs > 5000) {
            errors.put("timeout", "Health check timeout must be between 100ms and 5000ms");
        }

        // Failure threshold validation
        if (failureThreshold < 1 || failureThreshold > 10) {
            errors.put("failureThreshold", "Failure threshold must be between 1 and 10");
        }

        // Success codes validation
        Set<Integer> validSuccessCodes = new HashSet<>(Arrays.asList(200, 201, 202, 204));
        if (successCodes != null) {
            for (Integer code : successCodes) {
                if (!validSuccessCodes.contains(code)) {
                    errors.put("successCode_" + code, "Invalid success status code: " + code);
                }
            }
        }

        return errors;
    }

    /**
     * Validates GraphQL query
     */
    public static Map<String, String> validateGraphQLQuery(
            String query, int maxDepth, int maxComplexity, 
            List<String> requiredFields) {
        Map<String, String> errors = new HashMap<>();
        
        // Query syntax validation
        if (!query.trim().startsWith("query") && !query.trim().startsWith("mutation")) {
            errors.put("query", "Invalid GraphQL query format");
        }

        // Query depth validation
        int depth = calculateQueryDepth(query);
        if (depth > maxDepth) {
            errors.put("depth", "Query depth exceeds maximum allowed depth of " + maxDepth);
        }

        // Query complexity validation
        int complexity = calculateQueryComplexity(query);
        if (complexity > maxComplexity) {
            errors.put("complexity", "Query complexity exceeds maximum allowed value of " + maxComplexity);
        }

        // Required fields validation
        if (requiredFields != null) {
            for (String field : requiredFields) {
                if (!query.contains(field)) {
                    errors.put("field_" + field, "Required field missing: " + field);
                }
            }
        }

        return errors;
    }

    // Helper method for calculating GraphQL query depth
    private static int calculateQueryDepth(String query) {
        int maxDepth = 0;
        int currentDepth = 0;
        
        for (char c : query.toCharArray()) {
            if (c == '{') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == '}') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }

    // Helper method for calculating GraphQL query complexity
    private static int calculateQueryComplexity(String query) {
        // Simple complexity calculation based on field count
        return (int) query.chars().filter(ch -> ch == '{').count() * 
               (int) query.chars().filter(ch -> ch == ':').count();
    }

    /**
     * Validates message queue configuration
     */
    public static Map<String, String> validateMessageQueueConfig(
            String queueName, int maxQueueSize, int messageRetention,
            String deliveryMode, int maxRetries) {
        Map<String, String> errors = new HashMap<>();
        
        // Queue name validation
        if (!queueName.matches("^[a-zA-Z0-9-_]{1,80}$")) {
            errors.put("queueName", "Invalid queue name format");
        }

        // Queue size validation
        if (maxQueueSize < 1 || maxQueueSize > 1000000) {
            errors.put("maxQueueSize", "Queue size must be between 1 and 1,000,000");
        }

        // Message retention validation (in hours)
        if (messageRetention < 1 || messageRetention > 336) { // Max 14 days
            errors.put("messageRetention", "Message retention must be between 1 and 336 hours");
        }

        // Delivery mode validation
        Set<String> validDeliveryModes = new HashSet<>(Arrays.asList(
            "PERSISTENT", "NON_PERSISTENT", "AT_LEAST_ONCE", 
            "AT_MOST_ONCE", "EXACTLY_ONCE"
        ));
        if (!validDeliveryModes.contains(deliveryMode.toUpperCase())) {
            errors.put("deliveryMode", "Invalid delivery mode");
        }

        // Retry validation
        if (maxRetries < 0 || maxRetries > 100) {
            errors.put("maxRetries", "Max retries must be between 0 and 100");
        }

        return errors;
    }

    /**
     * Validates event message format
     */
    public static Map<String, String> validateEventMessage(
            String eventType, String eventSource, Map<String, Object> payload,
            String correlationId, int version) {
        Map<String, String> errors = new HashMap<>();
        
        // Event type validation
        if (!eventType.matches("^[A-Z][A-Za-z]*\\.[A-Z][A-Za-z]*(\\.[A-Z][A-Za-z]*)*$")) {
            errors.put("eventType", "Invalid event type format. Example: User.Created, Order.Status.Updated");
        }

        // Event source validation
        if (!eventSource.matches("^[a-zA-Z][a-zA-Z0-9-_./]*$")) {
            errors.put("eventSource", "Invalid event source format");
        }

        // Payload validation
        if (payload == null || payload.isEmpty()) {
            errors.put("payload", "Event payload cannot be empty");
        }

        // Correlation ID validation
        if (!correlationId.matches("^[A-Za-z0-9-]{10,50}$")) {
            errors.put("correlationId", "Invalid correlation ID format");
        }

        // Version validation
        if (version < 1) {
            errors.put("version", "Version must be greater than 0");
        }

        return errors;
    }

    /**
     * Validates event subscription configuration
     */
    public static Map<String, String> validateEventSubscription(
            List<String> eventTypes, String subscriberId,
            String deliveryEndpoint, Map<String, String> filters) {
        Map<String, String> errors = new HashMap<>();
        
        // Event types validation
        if (eventTypes == null || eventTypes.isEmpty()) {
            errors.put("eventTypes", "Must subscribe to at least one event type");
        } else {
            for (String eventType : eventTypes) {
                if (!eventType.matches("^[A-Z][A-Za-z]*\\.[A-Z][A-Za-z]*(\\.[A-Z][A-Za-z]*)*$")) {
                    errors.put("eventType_" + eventType, "Invalid event type format: " + eventType);
                }
            }
        }

        // Subscriber ID validation
        if (!subscriberId.matches("^[a-zA-Z0-9-_]{5,50}$")) {
            errors.put("subscriberId", "Invalid subscriber ID format");
        }

        // Delivery endpoint validation
        try {
            new URL(deliveryEndpoint);
            if (!deliveryEndpoint.startsWith("https://")) {
                errors.put("deliveryEndpoint", "Delivery endpoint must use HTTPS");
            }
        } catch (MalformedURLException e) {
            errors.put("deliveryEndpoint", "Invalid delivery endpoint URL");
        }

        // Filters validation
        if (filters != null) {
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                if (!filter.getKey().matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
                    errors.put("filter_" + filter.getKey(), "Invalid filter key format");
                }
                if (filter.getValue() == null || filter.getValue().trim().isEmpty()) {
                    errors.put("filter_" + filter.getKey(), "Filter value cannot be empty");
                }
            }
        }

        return errors;
    }

    /**
     * Validates message routing configuration
     */
    public static Map<String, String> validateMessageRouting(
            String routingKey, List<String> destinations,
            String routingStrategy, Map<String, String> routingRules) {
        Map<String, String> errors = new HashMap<>();
        
        // Routing key validation
        if (!routingKey.matches("^[a-zA-Z0-9-_.]+$")) {
            errors.put("routingKey", "Invalid routing key format");
        }

        // Destinations validation
        if (destinations == null || destinations.isEmpty()) {
            errors.put("destinations", "At least one destination is required");
        } else {
            for (String destination : destinations) {
                if (!destination.matches("^[a-zA-Z0-9-_./]+$")) {
                    errors.put("destination_" + destination, "Invalid destination format: " + destination);
                }
            }
        }

        // Routing strategy validation
        Set<String> validStrategies = new HashSet<>(Arrays.asList(
            "ROUND_ROBIN", "RANDOM", "CONSISTENT_HASH", "CONTENT_BASED",
            "WEIGHTED", "PRIORITY_BASED", "BROADCAST"
        ));
        if (!validStrategies.contains(routingStrategy.toUpperCase())) {
            errors.put("routingStrategy", "Invalid routing strategy");
        }

        // Routing rules validation
        if (routingRules != null) {
            for (Map.Entry<String, String> rule : routingRules.entrySet()) {
                if (!rule.getKey().matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
                    errors.put("rule_" + rule.getKey(), "Invalid routing rule key format");
                }
                if (!isValidRoutingRuleExpression(rule.getValue())) {
                    errors.put("rule_" + rule.getKey(), "Invalid routing rule expression");
                }
            }
        }

        return errors;
    }

    /**
     * Validates Dead Letter Queue (DLQ) configuration
     */
    public static Map<String, String> validateDLQConfig(
            String dlqName, int maxRetries, int retryDelay,
            String errorHandlingStrategy, long messageExpiry) {
        Map<String, String> errors = new HashMap<>();
        
        // DLQ name validation
        if (!dlqName.matches("^[a-zA-Z0-9-_]{1,80}$")) {
            errors.put("dlqName", "Invalid DLQ name format");
        }

        // Retry configuration validation
        if (maxRetries < 0 || maxRetries > 100) {
            errors.put("maxRetries", "Max retries must be between 0 and 100");
        }

        // Retry delay validation (in seconds)
        if (retryDelay < 1 || retryDelay > 3600) {
            errors.put("retryDelay", "Retry delay must be between 1 and 3600 seconds");
        }

        // Error handling strategy validation
        Set<String> validStrategies = new HashSet<>(Arrays.asList(
            "RETRY", "DISCARD", "MOVE_TO_DLQ", "NOTIFY_ADMIN",
            "LOG_ERROR", "TRIGGER_ALARM"
        ));
        if (!validStrategies.contains(errorHandlingStrategy.toUpperCase())) {
            errors.put("errorHandlingStrategy", "Invalid error handling strategy");
        }

        // Message expiry validation (in hours)
        if (messageExpiry < 1 || messageExpiry > 720) { // Max 30 days
            errors.put("messageExpiry", "Message expiry must be between 1 and 720 hours");
        }

        return errors;
    }

    /**
     * Helper method to validate routing rule expression
     */
    private static boolean isValidRoutingRuleExpression(String expression) {
        // Basic expression validation - can be enhanced based on needs
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }

        // Check for basic logical operators and syntax
        return expression.matches("^[\\w\\s.=><&|!()]+$") &&
               expression.matches(".*[=><].*") && // Must contain at least one comparison operator
               (expression.chars().filter(ch -> ch == '(').count() ==
                expression.chars().filter(ch -> ch == ')').count()); // Matching parentheses
    }
}