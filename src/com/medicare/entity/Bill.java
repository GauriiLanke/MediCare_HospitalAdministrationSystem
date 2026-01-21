package com.medicare.entity;

/*
 * Bill Entity Class
 * -----------------
 * Represents billing details of a patient.
 * This class is a POJO containing attributes,
 * constructors, getters, setters and toString method.
 */

public class Bill {

    // Bill attributes
    private int billId;
    private int patientId;
    private double amount;
    private String billDate;
    private String status;   // PAID / UNPAID

    // Default Constructor
    public Bill() { }

    // Parameterized Constructor
    public Bill(int billId, int patientId,
                double amount, String billDate,
                String status) {

        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.billDate = billDate;
        this.status = status;
    }

    // -------- Getter & Setter Methods --------

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display bill details in readable format
    @Override
    public String toString() {

        return billId +
        " | Patient:" + patientId +
        " | Amount:" + amount +
        " | Date:" + billDate +
        " | Status:" + status;
    }
}
