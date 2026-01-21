package com.medicare.service;

import java.util.List;

import com.medicare.entity.Patient;
import com.medicare.exception.HospitalException;

/*
 * PatientService Interface
 * ------------------------
 * Defines business operations related to Patient module.
 * Service layer performs validation and exception handling
 * before interacting with DAO layer.
 */

public interface PatientService {

    // Add new patient after validation
    void addPatient(Patient patient)
            throws HospitalException;

    // Fetch single patient by patientId
    Patient getPatientById(int id)
            throws HospitalException;

    // Fetch all patients using Collection Framework
    List<Patient> getAllPatients()
            throws HospitalException;

    // Update existing patient details
    void updatePatient(Patient patient)
            throws HospitalException;

    // Delete patient by patientId
    void deletePatient(int id)
            throws HospitalException;
}
