package com.medicare.ui;

import java.util.Scanner;

import com.medicare.entity.Appointment;
import com.medicare.service.AppointmentService;
import com.medicare.service.impl.AppointmentServiceImpl;

/*
 * AppointmentUI
 * -------------
 * Handles console operations for Appointment Module.
 * UI Layer → calls AppointmentService only.
 */

public class AppointmentUI {

    static Scanner sc = new Scanner(System.in);

    // Service Object
    static AppointmentService appointmentService =new AppointmentServiceImpl();

    // Appointment Menu Controller
    public static void appointmentMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("      APPOINTMENT MANAGEMENT        ");
            System.out.println("====================================");

            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointment");
            System.out.println("3. View All Appointments");
            System.out.println("4. Update Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Back");

            System.out.print("\nEnter Choice: ");

            int ch = sc.nextInt();

            try {

                switch (ch) {

                case 1:
                    bookAppointment();
                    break;

                case 2:
                    viewAppointment();
                    break;

                case 3:
                    viewAllAppointments();
                    break;

                case 4:
                    updateAppointment();
                    break;

                case 5:
                    cancelAppointment();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println(" " + e.getMessage());
            }
        }
    }

    // Book new appointment
    private static void bookAppointment() throws Exception {

        System.out.println("\n---- Book Appointment ----");

        Appointment a = new Appointment();

        // ========== STEP 1 : Appointment ID ==========
        System.out.print("Enter Appointment ID: ");
        int appId = sc.nextInt();

        // Duplicate check
        try {
            appointmentService.getAppointmentById(appId);
            throw new Exception("Appointment ID Already Exists!");

        } catch (Exception e) {
            if (!e.getMessage().contains("Not Found")) {
                throw e;
            }
        }

        a.setAppointmentId(appId);

        // ========== STEP 2 : Patient Validation ==========
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        try {
            // calling patient service to validate
            new com.medicare.service.impl.PatientServiceImpl()
                .getPatientById(pid);

        } catch (Exception e) {
            throw new Exception("Patient ID Not Found! First Add Patient.");
        }

        a.setPatientId(pid);

        // ========== STEP 3 : Doctor Validation ==========
        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();

        try {
            new com.medicare.service.impl.DoctorServiceImpl()
                .getDoctorById(did);

        } catch (Exception e) {
            throw new Exception("Doctor ID Not Found! First Add Doctor.");
        }

        a.setDoctorId(did);

        // ========== STEP 4 : Remaining Details ==========
        sc.nextLine();
        System.out.print("Enter Date (yyyy-mm-dd): ");
        a.setAppDate(sc.nextLine());

        System.out.print("Enter Status (BOOKED/COMPLETED/CANCELLED): ");
        a.setStatus(sc.next());

        // FINAL SAVE
        appointmentService.addAppointment(a);

        System.out.println("\nAppointment Booked Successfully!");
    }


    // View single appointment
    private static void viewAppointment() throws Exception {

        System.out.print("\nEnter Appointment ID: ");
        int id = sc.nextInt();

        System.out.println("\n---- Appointment Details ----");
        System.out.println(
            appointmentService.getAppointmentById(id)
        );
    }

    // View all appointments
    private static void viewAllAppointments() throws Exception {

        System.out.println("\n---- All Appointments ----");

        appointmentService
            .getAllAppointments()
            .forEach(System.out::println);
    }

    // Update appointment with validation
    private static void updateAppointment() throws Exception {

        System.out.print("\nEnter Appointment ID: ");
        int uid = sc.nextInt();

        // VALIDATE FIRST
        appointmentService.getAppointmentById(uid);

        Appointment up = new Appointment();
        up.setAppointmentId(uid);

        sc.nextLine();
        System.out.print("Enter New Date (yyyy-mm-dd): ");
        up.setAppDate(sc.nextLine());

        System.out.print("Enter Status (BOOKED/COMPLETED/CANCELLED): ");
        up.setStatus(sc.next());

        appointmentService.updateAppointment(up);

        System.out.println("\nAppointment Updated Successfully!");
    }

    // Cancel/Delete appointment
    private static void cancelAppointment() throws Exception {

        System.out.print("\nEnter Appointment ID: ");
        int did = sc.nextInt();

        // Validate FIRST
        appointmentService.getAppointmentById(did);

        appointmentService.deleteAppointment(did);

        System.out.println("\nAppointment Cancelled Successfully!");
    }
}
