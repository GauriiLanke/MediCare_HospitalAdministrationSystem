package com.medicare.dao;

import java.util.List;
import com.medicare.entity.Appointment;

/*
 * AppointmentDao Interface
 * ------------------------
 * Defines database operations for Appointment table.
 * DAO layer directly interacts with JDBC and database.
 */

public interface AppointmentDao {

    // Insert new appointment record
    void addAppointment(Appointment a);

    // Fetch single appointment by ID
    Appointment getAppointmentById(int id);

    // Fetch all appointments using Collection
    List<Appointment> getAllAppointments();

    // Update existing appointment
    void updateAppointment(Appointment a);

    // Delete appointment by ID
    void deleteAppointment(int id);

}
