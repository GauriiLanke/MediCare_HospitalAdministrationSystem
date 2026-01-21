package com.medicare.entity;

/*
 * Patient Entity Class
 * --------------------
 * Represents Patient table data.
 * This class is a POJO containing attributes,
 * constructors, getters, setters and toString method.
 */

public class Patient {

    // Patient attributes
    private int patientId;
    private String name;
    private int age;
    private String mobile;
    private String disease;

    // Default Constructor
    public Patient() {
    }

    // Parameterized Constructor
    public Patient(int patientId,
                   String name,
                   int age,
                   String mobile,
                   String disease) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.disease = disease;
    }

    // -------- Getter & Setter Methods --------

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    // Display patient details in readable format
    @Override
    public String toString() {

        return "PatientID: " + patientId +
               " | Name: " + name +
               " | Age: " + age +
               " | Mobile: " + mobile +
               " | Disease: " + disease;
    }

}
