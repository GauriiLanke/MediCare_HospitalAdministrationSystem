package com.medicare.dao;

import java.util.List;
import com.medicare.entity.Bill;

/*
 * BillDao Interface
 * -----------------
 * Defines database operations for Bill table.
 * DAO layer handles direct JDBC communication.
 */

public interface BillDao {

    // Insert new bill record
    void addBill(Bill bill);

    // Fetch single bill by billId
    Bill getBillById(int id);

    // Fetch all bills using Collection Framework
    List<Bill> getAllBills();

    // Update existing bill details
    void updateBill(Bill bill);

    // Delete bill by billId
    void deleteBill(int id);
}
