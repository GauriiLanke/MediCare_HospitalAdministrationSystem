package com.medicare.service;

import java.util.List;
import com.medicare.entity.Bill;
import com.medicare.exception.HospitalException;

/*
 * BillingService Interface
 * ------------------------
 * Defines business operations related to Billing module.
 * Service layer performs validation and exception handling
 * before interacting with DAO layer.
 */

public interface BillingService {

    // Add new bill after validation
    void addBill(Bill bill)
            throws HospitalException;

    // Fetch single bill by billId
    Bill getBillById(int id)
            throws HospitalException;

    // Fetch all bills using Collection Framework
    List<Bill> getAllBills()
            throws HospitalException;

    // Update existing bill details
    void updateBill(Bill bill)
            throws HospitalException;

    // Delete bill by billId
    void deleteBill(int id)
            throws HospitalException;
}
