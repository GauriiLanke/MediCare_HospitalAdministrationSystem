package com.medicare.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.medicare.dao.AppointmentDao;
import com.medicare.dao.BillDao;
import com.medicare.dao.impl.AppointmentDaoImpl;
import com.medicare.dao.impl.BillDaoImpl;

import com.medicare.entity.Appointment;
import com.medicare.entity.Bill;

import com.medicare.exception.DataNotFoundException;
import com.medicare.exception.HospitalException;
import com.medicare.service.ReportService;

/*
 * ReportServiceImpl
 * -----------------
 * Implements report generation logic for MediCare system.
 * This class processes data from DAO layer and
 * generates analytical reports for management.
 */

public class ReportServiceImpl implements ReportService {

    // DAO objects for fetching data
    AppointmentDao appDao = new AppointmentDaoImpl();

    BillDao billDao =new BillDaoImpl();

    // Get all appointments of specific date
    @Override
    public List<Appointment> getAppointmentsByDate(String date) throws HospitalException {

        List<Appointment> all =appDao.getAllAppointments();

        List<Appointment> result =new ArrayList<>();

        // Filter appointments by date
        for (Appointment a : all) {

            if (a.getAppDate()
                    .equals(date)) {

                result.add(a);
            }
        }

        if (result.isEmpty())
            throw new DataNotFoundException(
                "\nNo Appointments on this date!");

        return result;
    }

    // Get all bills of one patient
    @Override
    public List<Bill> getBillsByPatient(int patientId)throws HospitalException {

        List<Bill> all =billDao.getAllBills();

        List<Bill> result =new ArrayList<>();

        // Filter bills by patientId
        for (Bill b : all) {

            if (b.getPatientId() == patientId) {

                result.add(b);
            }
        }

        if (result.isEmpty())
            throw new DataNotFoundException(
                "\nNo Bills for this patient!");

        return result;
    }

    // Calculate total revenue from PAID bills
    @Override
    public double getTotalRevenue() throws HospitalException {

        List<Bill> all =billDao.getAllBills();

        if (all.isEmpty())
            throw new DataNotFoundException(
                "\nNo Bills Available!");

        double sum = 0;

        for (Bill b : all) {

            if (b.getStatus()
                    .equalsIgnoreCase("\nPAID")) {

                sum = sum + b.getAmount();
            }
        }

        return sum;
    }
}
