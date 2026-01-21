package com.medicare.service.impl;

import java.util.List;

import com.medicare.dao.AppointmentDao;
import com.medicare.dao.impl.AppointmentDaoImpl;
import com.medicare.entity.Appointment;
import com.medicare.exception.*;
import com.medicare.service.AppointmentService;
import com.medicare.util.ValidationUtil;

/*
 * AppointmentServiceImpl
 * ----------------------
 * Implements business logic for Appointment module.
 * Performs validations and throws custom exceptions
 * before calling DAO layer.
 */

public class AppointmentServiceImpl implements AppointmentService {

    // DAO object for database operations
    AppointmentDao dao =new AppointmentDaoImpl();

    // Add new appointment with validations
    public void addAppointment(Appointment a) throws HospitalException {

        // Validate ID
        if (!ValidationUtil.isValidId(a.getAppointmentId()))
            throw new InvalidInputException("\nInvalid ID");

        // Check duplicate record
        if (dao.getAppointmentById(a.getAppointmentId()) != null)
            throw new DuplicateRecordException("\nExists");

        dao.addAppointment(a);
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) throws HospitalException {

        Appointment a = dao.getAppointmentById(id);

        if (a == null)
            throw new DataNotFoundException("\nNot Found");

        return a;
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() throws HospitalException {

        List<Appointment> list = dao.getAllAppointments();

        if (list.isEmpty())
            throw new DataNotFoundException("\nEmpty");

        return list;
    }

    // Update appointment after existence check
    public void updateAppointment(Appointment a) throws HospitalException {

        if (dao.getAppointmentById(a.getAppointmentId()) == null)
            throw new DataNotFoundException("\nNot Found");

        dao.updateAppointment(a);
    }

    // Delete appointment after validation
    public void deleteAppointment(int id)  throws HospitalException {

        if (dao.getAppointmentById(id) == null)
            throw new DataNotFoundException("\nNot Found");

        dao.deleteAppointment(id);
    }
}
