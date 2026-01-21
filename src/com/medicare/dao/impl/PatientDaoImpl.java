package com.medicare.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.medicare.dao.PatientDao;
import com.medicare.entity.Patient;
import com.medicare.util.DBConnection;

/*
 * PatientDaoImpl
 * ---------------
 * This class provides JDBC implementation of PatientDao interface.
 * It performs all CRUD operations related to Patient table.
 * Database connection is obtained using DBConnection utility class.
 */

public class PatientDaoImpl implements PatientDao {

    // Database connection object
    Connection con = DBConnection.getDBConnection();

    // Inserts new patient record into database
    public void addPatient(Patient patient) {

        try {

            String query =
            "insert into patient(patientId, name, age, mobile, disease) values(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getMobile());
            ps.setString(5, patient.getDisease());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch single patient based on patientId
    public Patient getPatientById(int id) {

        Patient patient = null;

        try {

            String query =
            "select * from patient where patientId=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // Convert record into Patient object
            if (rs.next()) {

                patient = new Patient(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    // Retrieves all patients using Collection Framework
    public List<Patient> getAllPatients() {

        List<Patient> list = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet rs =
            stmt.executeQuery("select * from patient");

            // Convert each row into Patient object
            while (rs.next()) {

                Patient p = new Patient(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
                );

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Updates existing patient details
    public void updatePatient(Patient patient) {

        try {

            String query =
            "update patient set name=?, age=?, mobile=?, disease=? where patientId=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getMobile());
            ps.setString(4, patient.getDisease());
            ps.setInt(5, patient.getPatientId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletes patient based on patientId
    public void deletePatient(int id) {

        try {

            String query =
            "delete from patient where patientId=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
