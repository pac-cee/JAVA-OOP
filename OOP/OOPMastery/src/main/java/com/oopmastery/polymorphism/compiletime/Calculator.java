package com.oopmastery.polymorphism.compiletime;

/**
 * Calculator class demonstrating compile-time polymorphism through method overloading.
 * Shows different ways to overload methods:
 * 1. Different number of parameters
 * 2. Different parameter types
 * 3. Different parameter order
 * 4. Optional parameters with default values
 */
public class Calculator {
    
    // Basic arithmetic with two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded to handle three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded to handle doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded to handle mixed types
    public double add(int a, double b) {
        return a + b;
    }

    // Overloaded with different parameter order
    public double add(double a, int b) {
        return a + b;
    }

    // Overloaded to handle an array
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Multiplication with two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Overloaded to handle doubles
    public double multiply(double a, double b) {
        return a * b;
    }

    // Power function with default exponent
    public double power(double base) {
        return power(base, 2); // Default to square
    }

    // Power function with custom exponent
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // Average with variable number of arguments
    public double average(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Cannot calculate average of zero numbers");
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    // Overloaded to handle integer varargs
    public double average(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Cannot calculate average of zero numbers");
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    // Method to demonstrate type promotion
    public void printNumber(long number) {
        System.out.println("Long: " + number);
    }

    public void printNumber(double number) {
        System.out.println("Double: " + number);
    }

    // String concatenation overloading
    public String concat(String str1, String str2) {
        return str1 + str2;
    }

    public String concat(String str1, String str2, String separator) {
        return str1 + separator + str2;
    }

    public String concat(String... strings) {
        if (strings.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            result.append(" ").append(strings[i]);
        }
        return result.toString();
    }
} 