package com.medicare.dao.impl;

import java.sql.*;
import java.util.*;

import com.medicare.dao.AppointmentDao;
import com.medicare.entity.Appointment;
import com.medicare.util.DBConnection;

/*
 * AppointmentDaoImpl
 * -------------------
 * This class provides JDBC implementation of AppointmentDao interface.
 * It performs all CRUD operations related to Appointment table.
 * Database connection is obtained using DBConnection utility class.
 */

public class AppointmentDaoImpl implements AppointmentDao {

    // Database connection object
    Connection con = DBConnection.getDBConnection();

    //Inserts new appointment record into database
    public void addAppointment(Appointment a) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "insert into appointment values(?,?,?,?,?)"
            );
            ps.setInt(1, a.getAppointmentId());
            ps.setInt(2, a.getPatientId());
            ps.setInt(3, a.getDoctorId());
            ps.setString(4, a.getAppDate());
            ps.setString(5, a.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            // Exception handled silently as per project pattern
        }
    }

    //Fetch single appointment based on appointmentId
    public Appointment getAppointmentById(int id) {

        Appointment a = null;
        try {
            PreparedStatement ps = con.prepareStatement(
                "select * from appointment where appointmentId=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // If record found convert into Appointment object
            if (rs.next()) {
                a = new Appointment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
                );
            }
        } catch (Exception e) {
            // Exception ignored
        }
        return a;
    }

    //Retrieves all appointment records using Collection Framework
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery("select * from appointment");

            // Convert each row into Appointment object
            while (rs.next()) {
                list.add(new Appointment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5)
                ));
            }
        } catch (Exception e) {
            // Exception ignored
        }
        return list;
    }

    //Updates date and status of existing appointment
    public void updateAppointment(Appointment a) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "update appointment set appDate=?, status=? where appointmentId=?"
            );
            ps.setString(1, a.getAppDate());
            ps.setString(2, a.getStatus());
            ps.setInt(3, a.getAppointmentId());
            ps.executeUpdate();
        } catch (Exception e) {
            // Exception ignored
        }
    }

    //Deletes appointment based on appointmentId
    public void deleteAppointment(int id) {

        try {
            PreparedStatement ps = con.prepareStatement(
                "delete from appointment where appointmentId=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            // Exception ignored
        }
    }
}
