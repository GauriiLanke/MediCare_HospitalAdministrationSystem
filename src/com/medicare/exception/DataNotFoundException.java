package com.medicare.exception;

/*
 * DataNotFoundException
 * ---------------------
 * This exception is thrown when the requested
 * record is not available in database.
 * It extends HospitalException (custom base exception).
 */

@SuppressWarnings("serial")
public class DataNotFoundException extends HospitalException {

    // Default Constructor
    public DataNotFoundException() {
        super();
    }

    // Parameterized Constructor to pass custom message
    public DataNotFoundException(String message) {
        super(message);
    }
}
