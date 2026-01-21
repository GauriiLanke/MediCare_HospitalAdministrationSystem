package com.medicare.entity;

/*
 * Doctor Entity Class
 * -------------------
 * Represents information related to Doctor.
 * This class acts as POJO with private fields,
 * constructors, getters, setters and toString method.
 */

public class Doctor {

    // Doctor attributes
    private int doctorId;
    private String name;
    private String specialization;
    private String mobile;
    private int experience;

    // Default Constructor
    public Doctor() { }

    // Parameterized Constructor
    public Doctor(int doctorId,
                  String name,
                  String specialization,
                  String mobile,
                  int experience) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.mobile = mobile;
        this.experience = experience;
    }

    // -------- Getter & Setter Methods --------

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Display doctor details in readable format
    @Override
    public String toString() {

        return "DoctorID: " + doctorId +
               " | Name: " + name +
               " | Specialization: " + specialization +
               " | Mobile: " + mobile +
               " | Experience: " + experience + " yrs";
    }

}
