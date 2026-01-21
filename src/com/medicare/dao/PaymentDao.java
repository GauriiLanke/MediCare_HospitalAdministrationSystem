package com.medicare.dao;

import java.util.List;
import com.medicare.entity.Payment;

/*
 * PaymentDao Interface
 * --------------------
 * Defines database operations for Payment table.
 * DAO layer performs direct JDBC communication.
 */

public interface PaymentDao {

    // Insert new payment record
    void addPayment(Payment payment);

    // Fetch single payment by paymentId
    Payment getPaymentById(int id);

    // Fetch all payments using Collection Framework
    List<Payment> getAllPayments();

    // Update existing payment details
    void updatePayment(Payment payment);

    // Delete payment by paymentId
    void deletePayment(int id);

}
