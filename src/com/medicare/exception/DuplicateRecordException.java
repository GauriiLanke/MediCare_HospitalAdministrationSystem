package com.medicare.exception;

/*
 * DuplicateRecordException
 * ------------------------
 * This exception is thrown when user tries to insert
 * a record that already exists in database.
 * It extends HospitalException (custom base exception).
 */

@SuppressWarnings("serial")
public class DuplicateRecordException extends HospitalException {

    // Default Constructor
    public DuplicateRecordException() {
        super();
    }

    // Parameterized Constructor to pass custom message
    public DuplicateRecordException(String message) {
        super(message);
    }
}
