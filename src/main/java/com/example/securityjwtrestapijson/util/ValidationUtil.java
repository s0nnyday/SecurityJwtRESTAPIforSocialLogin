package com.example.securityjwtrestapijson.util;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidationUtil {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public static boolean isValidEmail(String email) {
        // Use Apache Commons Validator for email validation
        return EmailValidator.getInstance().isValid(email);
    }

    public static boolean isValidPassword(String password) {
        // Password validation logic (example: at least one digit, one lowercase letter, one uppercase letter, and minimum length of 8 characters)
        return password.matches(PASSWORD_REGEX);
    }
}
