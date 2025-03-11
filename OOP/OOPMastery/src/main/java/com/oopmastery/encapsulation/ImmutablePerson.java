package com.oopmastery.encapsulation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ImmutablePerson demonstrates complete immutability in Java.
 * Key characteristics:
 * 1. Class is final (cannot be extended)
 * 2. All fields are private and final
 * 3. No setters
 * 4. Defensive copying in constructor and getters
 * 5. All mutable object references are protected
 */
public final class ImmutablePerson {
    private final String name;
    private final LocalDate dateOfBirth;
    private final List<String> qualifications;
    private final Address address;

    /**
     * Constructor that creates a deep copy of all mutable objects.
     * @param name Person's name
     * @param dateOfBirth Person's date of birth
     * @param qualifications List of qualifications
     * @param address Person's address
     */
    public ImmutablePerson(String name, LocalDate dateOfBirth, 
                          List<String> qualifications, Address address) {
        // Validate input
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        this.name = name.trim();
        this.dateOfBirth = dateOfBirth; // LocalDate is immutable, no need to copy
        
        // Defensive copy of mutable objects
        this.qualifications = qualifications != null ? 
            new ArrayList<>(qualifications) : new ArrayList<>();
        this.address = new Address(address); // Create a copy using copy constructor
    }

    /**
     * Gets the person's name.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the person's date of birth.
     * @return The date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth; // LocalDate is immutable, safe to return directly
    }

    /**
     * Gets the person's qualifications.
     * @return An unmodifiable list of qualifications
     */
    public List<String> getQualifications() {
        return Collections.unmodifiableList(qualifications);
    }

    /**
     * Gets the person's address.
     * @return A copy of the address
     */
    public Address getAddress() {
        return new Address(address); // Return a copy to maintain immutability
    }

    @Override
    public String toString() {
        return String.format("Person[name=%s, dateOfBirth=%s, address=%s, qualifications=%s]",
            name, dateOfBirth, address, qualifications);
    }

    /**
     * Static inner class representing an address.
     * This could be its own class file, included here for demonstration.
     */
    public static class Address {
        private final String street;
        private final String city;
        private final String country;
        private final String postalCode;

        public Address(String street, String city, String country, String postalCode) {
            this.street = street;
            this.city = city;
            this.country = country;
            this.postalCode = postalCode;
        }

        // Copy constructor
        public Address(Address other) {
            this.street = other.street;
            this.city = other.city;
            this.country = other.country;
            this.postalCode = other.postalCode;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getPostalCode() {
            return postalCode;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s %s",
                street, city, country, postalCode);
        }
    }
} 