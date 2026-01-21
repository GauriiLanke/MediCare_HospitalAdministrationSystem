package com.medicare.entity;

/*
 * Appointment Entity Class
 * ------------------------
 * Represents appointment between Patient and Doctor.
 * This class acts as a POJO with private fields,
 * getters, setters and toString method.
 */

public class Appointment {

    // Attributes of Appointment
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appDate;
    private String status;

    // Default Constructor
    public Appointment(){}

    // Parameterized Constructor
    public Appointment(int appointmentId,
                       int patientId,
                       int doctorId,
                       String appDate,
                       String status){

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appDate = appDate;
        this.status = status;
    }

    // Getter and Setter methods
    public int getAppointmentId(){
        return appointmentId;
    }

    public void setAppointmentId(int id){
        appointmentId = id;
    }

    public int getPatientId(){
        return patientId;
    }

    public void setPatientId(int id){
        patientId = id;
    }

    public int getDoctorId(){
        return doctorId;
    }

    public void setDoctorId(int id){
        doctorId = id;
    }

    public String getAppDate(){
        return appDate;
    }

    public void setAppDate(String d){
        appDate = d;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String s){
        status = s;
    }

    // Display Appointment details in readable format
    @Override
    public String toString(){

        return appointmentId +
        " | Patient:" + patientId +
        " | Doctor:" + doctorId +
        " | Date:" + appDate +
        " | Status:" + status;
    }
}
