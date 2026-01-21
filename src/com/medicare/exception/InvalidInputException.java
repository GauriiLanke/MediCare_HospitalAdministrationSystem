package com.medicare.exception;

/*
 * InvalidInputException
 * ---------------------
 * This exception is thrown when user provides
 * invalid or improper input.
 * It extends HospitalException (custom base exception).
 */

@SuppressWarnings("serial")
public class InvalidInputException extends HospitalException {

    // Default Constructor
    public InvalidInputException() {
        super();
    }

    // Parameterized Constructor to pass custom message
    public InvalidInputException(String message) {
        super(message);
    }
}
