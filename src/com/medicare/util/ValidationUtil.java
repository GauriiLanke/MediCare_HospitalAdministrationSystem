package com.medicare.util;

/*
 * ValidationUtil
 * --------------
 * Common utility class for validating
 * user inputs across all modules.
 * Helps in maintaining clean service layer
 * and centralized validation logic.
 */

public class ValidationUtil {

    // Check string is not null or empty
    public static boolean isNotEmpty(String value) {

        return value != null && !value.trim().isEmpty();
    }

    // Validate Name (Only Alphabets & Space)
    public static boolean isValidName(String name) {

        return name.matches("[a-zA-Z ]+");
    }

    // Validate Mobile Number (10 Digits starting 6-9)
    public static boolean isValidMobile(String mobile) {

        return mobile.matches("[6-9][0-9]{9}");
    }

    // Validate Email format
    public static boolean isValidEmail(String email) {

        return email.matches(
            "^[A-Za-z0-9+_.-]+@(.+)$"
        );
    }

    // Validate Age range
    public static boolean isValidAge(int age) {

        return age > 0 && age <= 120;
    }

    // Validate ID (must be positive)
    public static boolean isValidId(int id) {

        return id > 0;
    }

    // Validate Amount (greater than zero)
    public static boolean isValidAmount(double amount) {

        return amount > 0;
    }
}
