package com.medicare.service;

import java.util.List;

import com.medicare.entity.Doctor;
import com.medicare.exception.HospitalException;

/*
 * DoctorService Interface
 * -----------------------
 * Defines business operations related to Doctor module.
 * Service layer performs validation and exception handling
 * before interacting with DAO layer.
 */

public interface DoctorService {

    // Add new doctor after validation
    void addDoctor(Doctor doctor)
            throws HospitalException;

    // Fetch single doctor by doctorId
    Doctor getDoctorById(int id)
            throws HospitalException;

    // Fetch all doctors using Collection Framework
    List<Doctor> getAllDoctors()
            throws HospitalException;

    // Update existing doctor details
    void updateDoctor(Doctor doctor)
            throws HospitalException;

    // Delete doctor by doctorId
    void deleteDoctor(int id)
            throws HospitalException;
}
