package com.medicare.service;

import java.util.List;

import com.medicare.entity.Payment;
import com.medicare.exception.HospitalException;

/*
 * PaymentService Interface
 * ------------------------
 * Defines business operations related to Payment module.
 * Service layer performs validation and exception handling
 * before interacting with DAO layer.
 */

public interface PaymentService {

    // Add new payment after validation
    void addPayment(Payment payment)
            throws HospitalException;

    // Fetch single payment by paymentId
    Payment getPaymentById(int id)
            throws HospitalException;

    // Fetch all payments using Collection Framework
    List<Payment> getAllPayments()
            throws HospitalException;

    // Update existing payment details
    void updatePayment(Payment payment)
            throws HospitalException;

    // Delete payment by paymentId
    void deletePayment(int id)
            throws HospitalException;
}
