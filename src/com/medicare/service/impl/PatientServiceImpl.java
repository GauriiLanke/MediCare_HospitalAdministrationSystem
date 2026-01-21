package com.medicare.service.impl;

import java.util.List;

import com.medicare.dao.PatientDao;
import com.medicare.dao.impl.PatientDaoImpl;
import com.medicare.entity.Patient;
import com.medicare.exception.*;
import com.medicare.service.PatientService;
import com.medicare.util.ValidationUtil;

/*
 * PatientServiceImpl
 * ------------------
 * Implements business logic for Patient module.
 * Performs input validation and exception handling
 * before interacting with DAO layer.
 */

public class PatientServiceImpl implements PatientService {

    // DAO object for Patient operations
    PatientDao dao =  new PatientDaoImpl();

    // Add Patient with validations
    public void addPatient(Patient patient) throws HospitalException {

        // Validate patient ID
        if (!ValidationUtil.isValidId( patient.getPatientId())) {
            throw new InvalidInputException("\nInvalid Patient ID");
        }

        // Validate patient name
        if (!ValidationUtil.isValidName(patient.getName())) {
            throw new InvalidInputException(
                "\nInvalid Name");
        }

        // Check duplicate record
        if (dao.getPatientById(patient.getPatientId()) != null) {
            throw new DuplicateRecordException(
                "\nPatient Already Exists!");
        }

        dao.addPatient(patient);
    }

    // Fetch single patient by ID
    public Patient getPatientById(int id) throws HospitalException {

        Patient patient = dao.getPatientById(id);

        if (patient == null) {
            throw new DataNotFoundException(
                "\nPatient Not Found!");
        }

        return patient;
    }

    // Fetch all patients
    public List<Patient> getAllPatients() throws HospitalException {

        List<Patient> list = dao.getAllPatients();

        if (list.isEmpty()) {
            throw new DataNotFoundException(
                "\nNo Patient Records Available!");
        }

        return list;
    }

    // Update patient after existence check
    public void updatePatient(Patient patient) throws HospitalException {

        if (dao.getPatientById(patient.getPatientId()) == null) {
            throw new DataNotFoundException(
                "\nPatient Not Found!");
        }

        dao.updatePatient(patient);
    }

    // Delete patient after validation
    public void deletePatient(int id) throws HospitalException {

        if (dao.getPatientById(id) == null) {
            throw new DataNotFoundException(
                "\nPatient Not Found!");
        }

        dao.deletePatient(id);
    }
}
