package com.medicare.service.impl;

import java.util.List;

import com.medicare.dao.DoctorDao;
import com.medicare.dao.impl.DoctorDaoImpl;
import com.medicare.entity.Doctor;
import com.medicare.exception.*;
import com.medicare.service.DoctorService;
import com.medicare.util.ValidationUtil;

/*
 * DoctorServiceImpl
 * -----------------
 * Implements business logic for Doctor module.
 * Performs input validation and exception handling
 * before calling DAO layer.
 */

public class DoctorServiceImpl implements DoctorService {

    // DAO object for Doctor operations
    DoctorDao dao =new DoctorDaoImpl();

    // Add Doctor with validations
    public void addDoctor(Doctor d)throws HospitalException {

        // Validate doctor ID
        if (!ValidationUtil.isValidId(d.getDoctorId()))
            throw new InvalidInputException("\nInvalid ID");

        // Validate doctor name
        if (!ValidationUtil.isValidName( d.getName()))
            throw new InvalidInputException("\nInvalid Name");

        // Check duplicate record
        if (dao.getDoctorById(d.getDoctorId()) != null)
            throw new DuplicateRecordException("\nDoctor Already Exists!");

        dao.addDoctor(d);
    }

    // Find Doctor by ID
    public Doctor getDoctorById(int id)
    		throws HospitalException {

        Doctor d = dao.getDoctorById(id);

        if (d == null)
            throw new DataNotFoundException("\nDoctor Not Found!");

        return d;
    }

    // View All Doctors
    public List<Doctor> getAllDoctors()throws HospitalException {

        List<Doctor> list =dao.getAllDoctors();

        if (list.isEmpty())
            throw new DataNotFoundException("\nNo Doctors!");

        return list;
    }

    // Update Doctor after existence check
    public void updateDoctor(Doctor d) throws HospitalException {

        if (dao.getDoctorById( d.getDoctorId()) == null)
            throw new DataNotFoundException("\nDoctor Not Found!");

        dao.updateDoctor(d);
    }

    // Delete Doctor after validation
    public void deleteDoctor(int id) throws HospitalException {

        if (dao.getDoctorById(id) == null)
            throw new DataNotFoundException("\nDoctor Not Found!");

        dao.deleteDoctor(id);
    }
}
