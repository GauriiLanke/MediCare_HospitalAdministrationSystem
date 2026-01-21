package com.medicare.service;

import java.util.List;
import com.medicare.entity.Appointment;
import com.medicare.entity.Bill;
import com.medicare.exception.HospitalException;

/*
 * ReportService Interface
 * -----------------------
 * Defines business operations for generating
 * various system reports for management.
 * This layer interacts with DAO layer to
 * fetch data and apply report logic.
 */

public interface ReportService {

    // Fetch appointments of a particular date
    List<Appointment> getAppointmentsByDate(String date)
            throws HospitalException;

    // Fetch all bills of a specific patient
    List<Bill> getBillsByPatient(int patientId)
            throws HospitalException;

    // Calculate total revenue from paid bills
    double getTotalRevenue()
            throws HospitalException;
}
