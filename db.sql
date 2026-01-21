/* =========================================
   Database : medicare_db
   ========================================= */

CREATE DATABASE IF NOT EXISTS medicare_db;
USE medicare_db;

/* ================= PATIENT ================= */

CREATE TABLE patient (
    patientId INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    mobile VARCHAR(15) UNIQUE NOT NULL,
    disease VARCHAR(150) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* ================= DOCTOR ================= */

CREATE TABLE doctor (
    doctorId INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    mobile VARCHAR(15),
    experience INT
);

/* ================= BILL ================= */

CREATE TABLE bill (
    billId INT PRIMARY KEY,
    patientId INT,
    amount DOUBLE,
    billDate VARCHAR(20),
    status VARCHAR(10)
);

/* ================= PAYMENT ================= */

CREATE TABLE payment (
    paymentId INT PRIMARY KEY,
    billId INT,
    amount DOUBLE,
    paymentDate VARCHAR(20),
    mode VARCHAR(20),
    status VARCHAR(10)
);

/* ================= APPOINTMENT ================= */

CREATE TABLE appointment (
    appointmentId INT PRIMARY KEY,
    patientId INT,
    doctorId INT,
    appDate VARCHAR(20),
    status VARCHAR(15)
);
