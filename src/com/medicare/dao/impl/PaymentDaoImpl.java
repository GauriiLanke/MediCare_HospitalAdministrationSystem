package com.medicare.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.medicare.dao.PaymentDao;
import com.medicare.entity.Payment;
import com.medicare.util.DBConnection;

/*
 * PaymentDaoImpl
 * ---------------
 * This class provides JDBC implementation of PaymentDao interface.
 * It performs all CRUD operations related to Payment table.
 * Database connection is obtained using DBConnection utility class.
 */

public class PaymentDaoImpl implements PaymentDao {

    // Database connection object
    Connection con = DBConnection.getDBConnection();

    // Inserts new payment record into database
    public void addPayment(Payment p) {

        try {

            String query =
            "insert into payment values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, p.getPaymentId());
            ps.setInt(2, p.getBillId());
            ps.setDouble(3, p.getAmount());
            ps.setString(4, p.getPaymentDate());
            ps.setString(5, p.getMode());
            ps.setString(6, p.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch single payment based on paymentId
    public Payment getPaymentById(int id) {

        Payment payment = null;

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "select * from payment where paymentId=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // Convert record into Payment object
            if (rs.next()) {

                payment = new Payment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payment;
    }

    // Retrieves all payments using Collection Framework
    public List<Payment> getAllPayments() {

        List<Payment> list = new ArrayList<>();

        try {

            Statement st = con.createStatement();

            ResultSet rs =
            st.executeQuery("select * from payment");

            // Convert each row into Payment object
            while (rs.next()) {

                Payment p = new Payment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                );

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Updates payment amount or status
    public void updatePayment(Payment p) {

        try {

            String query =
            "update payment set amount=?, status=? where paymentId=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, p.getAmount());
            ps.setString(2, p.getStatus());
            ps.setInt(3, p.getPaymentId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletes payment based on paymentId
    public void deletePayment(int id) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "delete from payment where paymentId=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
