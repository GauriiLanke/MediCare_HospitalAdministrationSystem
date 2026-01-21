package com.medicare.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.medicare.dao.BillDao;
import com.medicare.entity.Bill;
import com.medicare.util.DBConnection;

/*
 * BillDaoImpl
 * ------------
 * This class provides JDBC implementation of BillDao interface.
 * It performs all CRUD operations related to Bill table.
 * Database connection is obtained using DBConnection utility class.
 */

public class BillDaoImpl implements BillDao {

    // Database connection object
    Connection con = DBConnection.getDBConnection();

    // Inserts new bill record into database
    public void addBill(Bill bill) {

        try {
            String q = "insert into bill values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, bill.getBillId());
            ps.setInt(2, bill.getPatientId());
            ps.setDouble(3, bill.getAmount());
            ps.setString(4, bill.getBillDate());
            ps.setString(5, bill.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch single bill based on billId
    public Bill getBillById(int id) {

        Bill b = null;
        try {
            PreparedStatement ps =
            con.prepareStatement("select * from bill where billId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Convert record into Bill object
            if (rs.next()) {
                b = new Bill(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    // Retrieves all bill records using Collection Framework
    public List<Bill> getAllBills() {

        List<Bill> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from bill");

            // Convert each row into Bill object
            while (rs.next()) {
                Bill b = new Bill(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5)
                );
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Updates bill amount or status
    public void updateBill(Bill bill) {

        try {
            String q =
            "update bill set amount=?, status=? where billId=?";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setDouble(1, bill.getAmount());
            ps.setString(2, bill.getStatus());
            ps.setInt(3, bill.getBillId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletes bill based on billId
    public void deleteBill(int id) {

        try {
            PreparedStatement ps =
            con.prepareStatement("delete from bill where billId=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
