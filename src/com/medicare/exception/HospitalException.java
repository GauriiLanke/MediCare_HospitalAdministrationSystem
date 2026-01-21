package com.medicare.exception;

/*
 * HospitalException
 * -----------------
 * This is the parent/custom base exception class
 * for the MediCare project.
 * All user defined exceptions extend this class
 * to maintain centralized exception hierarchy.
 */

@SuppressWarnings("serial")
public class HospitalException extends Exception {

    // Default Constructor
    public HospitalException() {
        super();
    }

    // Parameterized Constructor to pass message
    public HospitalException(String message) {
        super(message);
    }
}
