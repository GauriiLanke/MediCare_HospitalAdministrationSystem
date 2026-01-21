package com.medicare.service.impl;

import java.util.List;

import com.medicare.dao.PaymentDao;
import com.medicare.dao.impl.PaymentDaoImpl;
import com.medicare.entity.Payment;
import com.medicare.exception.*;
import com.medicare.service.PaymentService;
import com.medicare.util.ValidationUtil;

/*
 * PaymentServiceImpl
 * ------------------
 * Implements business logic for Payment module.
 * Performs validations and exception handling
 * before interacting with DAO layer.
 */

public class PaymentServiceImpl implements PaymentService {

    // DAO object for Payment operations
    PaymentDao dao = new PaymentDaoImpl();

    // Add payment with validations
    public void addPayment(Payment p) throws HospitalException {

        // Validate payment ID
        if (!ValidationUtil.isValidId( p.getPaymentId())) {
            throw new InvalidInputException(
                "\nInvalid Payment ID");
        }

        // Check duplicate record
        if (dao.getPaymentById(p.getPaymentId()) != null) {
            throw new DuplicateRecordException(
                "\nPayment Already Exists!");
        }

        dao.addPayment(p);
    }

    // Get payment by ID
    public Payment getPaymentById(int id)throws HospitalException {

        Payment p =   dao.getPaymentById(id);

        if (p == null) {
            throw new DataNotFoundException(
                "\nPayment Not Found!");
        }

        return p;
    }

    // View all payments
    public List<Payment> getAllPayments()
            throws HospitalException {

        List<Payment> list = dao.getAllPayments();

        if (list.isEmpty()) {
            throw new DataNotFoundException(
                "\nNo Payment Records!");
        }

        return list;
    }

    // Update payment after existence check
    public void updatePayment(Payment p) throws HospitalException {

        if (dao.getPaymentById(
                p.getPaymentId()) == null) {
            throw new DataNotFoundException(
                "\nPayment Not Found!");
        }

        dao.updatePayment(p);
    }

    // Delete payment after validation
    public void deletePayment(int id) throws HospitalException {

        if (dao.getPaymentById(id) == null) {
            throw new DataNotFoundException(
                "\nPayment Not Found!");
        }

        dao.deletePayment(id);
    }
}
