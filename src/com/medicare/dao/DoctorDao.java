package com.medicare.dao;

import java.util.List;
import com.medicare.entity.Doctor;

/*
 * DoctorDao Interface
 * -------------------
 * Defines database operations for Doctor table.
 * DAO layer performs direct JDBC communication.
 */

public interface DoctorDao {

    // Insert new doctor record
    void addDoctor(Doctor doctor);

    // Fetch single doctor by doctorId
    Doctor getDoctorById(int id);

    // Fetch all doctors using Collection Framework
    List<Doctor> getAllDoctors();

    // Update existing doctor details
    void updateDoctor(Doctor doctor);

    // Delete doctor by doctorId
    void deleteDoctor(int id);

}
