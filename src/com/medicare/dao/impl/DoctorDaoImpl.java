package com.medicare.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.medicare.dao.DoctorDao;
import com.medicare.entity.Doctor;
import com.medicare.util.DBConnection;

/*
 * DoctorDaoImpl
 * --------------
 * This class provides JDBC implementation of DoctorDao interface.
 * It performs all CRUD operations related to Doctor table.
 * Database connection is obtained using DBConnection utility class.
 */

public class DoctorDaoImpl implements DoctorDao {

    // Database connection object
    Connection con = DBConnection.getDBConnection();

    // Inserts new doctor record into database
    public void addDoctor(Doctor d) {

        try {

            String q =
            "insert into doctor values(?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(q);

            ps.setInt(1, d.getDoctorId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getSpecialization());
            ps.setString(4, d.getMobile());
            ps.setInt(5, d.getExperience());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch single doctor based on doctorId
    public Doctor getDoctorById(int id) {

        Doctor d = null;

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "select * from doctor where doctorId=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // Convert record into Doctor object
            if (rs.next()) {

                d = new Doctor(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d;
    }

    // Retrieves all doctors using Collection Framework
    public List<Doctor> getAllDoctors() {

        List<Doctor> list = new ArrayList<>();

        try {

            Statement st = con.createStatement();

            ResultSet rs =
            st.executeQuery("select * from doctor");

            // Convert each row into Doctor object
            while (rs.next()) {

                Doctor d = new Doctor(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5)
                );

                list.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Updates doctor details
    public void updateDoctor(Doctor d) {

        try {

            String q =
            "update doctor set name=?, specialization=?, mobile=?, experience=? where doctorId=?";

            PreparedStatement ps =
            con.prepareStatement(q);

            ps.setString(1, d.getName());
            ps.setString(2, d.getSpecialization());
            ps.setString(3, d.getMobile());
            ps.setInt(4, d.getExperience());
            ps.setInt(5, d.getDoctorId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletes doctor based on doctorId
    public void deleteDoctor(int id) {

        try {

            PreparedStatement ps =
            con.prepareStatement(
            "delete from doctor where doctorId=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
