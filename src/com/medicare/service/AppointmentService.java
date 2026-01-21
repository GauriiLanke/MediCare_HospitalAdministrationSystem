package com.medicare.service;

import java.util.List;

import com.medicare.entity.Appointment;
import com.medicare.exception.HospitalException;

/*
 * AppointmentService Interface
 * ----------------------------
 * Defines business operations related to Appointment module.
 * Service layer performs validation and exception handling
 * before interacting with DAO layer.
 */

public interface AppointmentService {

    // Add new appointment after validation
    void addAppointment(Appointment a)
            throws HospitalException;

    // Fetch single appointment by ID
    Appointment getAppointmentById(int id)
            throws HospitalException;

    // Fetch all appointments using collection
    List<Appointment> getAllAppointments()
            throws HospitalException;

    // Update existing appointment details
    void updateAppointment(Appointment a)
            throws HospitalException;

    // Delete appointment by ID
    void deleteAppointment(int id)
            throws HospitalException;
}
