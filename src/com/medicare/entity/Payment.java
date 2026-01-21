package com.medicare.entity;

/*
 * Payment Entity Class
 * --------------------
 * Represents payment details of a Bill.
 * This class acts as a POJO containing attributes,
 * constructors, getters, setters and toString method.
 */

public class Payment {

    // Payment attributes
    private int paymentId;
    private int billId;
    private double amount;
    private String paymentDate;
    private String mode;     // CASH / CARD / UPI
    private String status;   // SUCCESS / PENDING

    // Default Constructor
    public Payment() { }

    // Parameterized Constructor
    public Payment(int paymentId,
                   int billId,
                   double amount,
                   String paymentDate,
                   String mode,
                   String status) {

        this.paymentId = paymentId;
        this.billId = billId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.mode = mode;
        this.status = status;
    }

    // -------- Getter & Setter Methods --------

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display payment details in readable format
    @Override
    public String toString() {

        return paymentId +
        " | Bill:" + billId +
        " | Amount:" + amount +
        " | Date:" + paymentDate +
        " | Mode:" + mode +
        " | Status:" + status;
    }
}
