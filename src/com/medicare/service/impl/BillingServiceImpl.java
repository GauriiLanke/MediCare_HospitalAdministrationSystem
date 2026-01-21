package com.medicare.service.impl;

import java.util.List;

import com.medicare.dao.BillDao;
import com.medicare.dao.impl.BillDaoImpl;
import com.medicare.entity.Bill;
import com.medicare.exception.*;
import com.medicare.service.BillingService;
import com.medicare.util.ValidationUtil;

/*
 * BillingServiceImpl
 * ------------------
 * Implements business logic for Billing module.
 * Performs validations and throws custom exceptions
 * before interacting with DAO layer.
 */

public class BillingServiceImpl implements BillingService {

    // DAO object for Bill operations
    BillDao dao = new BillDaoImpl();

    // Add bill with validations
    @Override
    public void addBill(Bill bill) throws HospitalException {

        // Validate bill ID
        if (!ValidationUtil.isValidId(bill.getBillId()))
            throw new InvalidInputException("\nInvalid Bill ID");

        // Check duplicate
        if (dao.getBillById( bill.getBillId()) != null)
            throw new DuplicateRecordException("\nBill Already Exists!");

        dao.addBill(bill);
    }

    // Fetch single bill by ID
    @Override
    public Bill getBillById(int id)throws HospitalException {

        Bill b = dao.getBillById(id);

        if (b == null) throw new DataNotFoundException("\nBill Not Found!");

        return b;
    }

    // Fetch all bills using collection
    @Override
    public List<Bill> getAllBills() throws HospitalException {

        List<Bill> list = dao.getAllBills();

        if (list.isEmpty())
        	throw new DataNotFoundException("\nNo Bills Available!");

        return list;
    }

    // Update bill after existence check
    @Override
    public void updateBill(Bill bill) throws HospitalException {

        if (dao.getBillById( bill.getBillId()) == null)
            throw new DataNotFoundException("\nBill Not Found!");

        dao.updateBill(bill);
    }

    // Delete bill after validation
    @Override
    public void deleteBill(int id) throws HospitalException {

        if (dao.getBillById(id) == null)
            throw new DataNotFoundException("\nBill Not Found!");

        dao.deleteBill(id);
    }
}
