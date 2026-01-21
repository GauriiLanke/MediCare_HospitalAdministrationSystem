package com.medicare.dao;

import java.util.List;
import com.medicare.entity.Patient;

/*
 * PatientDao Interface
 * --------------------
 * Defines database operations for Patient table.
 * DAO layer directly interacts with JDBC.
 */

public interface PatientDao {

    // Insert new patient record
    void addPatient(Patient patient);

    // Fetch single patient by patientId
    Patient getPatientById(int id);

    // Fetch all patients using Collection Framework
    List<Patient> getAllPatients();

    // Update existing patient details
    void updatePatient(Patient patient);

    // Delete patient by patientId
    void deletePatient(int id);

}
