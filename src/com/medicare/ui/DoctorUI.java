package com.medicare.ui;

import java.util.Scanner;

import com.medicare.entity.Doctor;
import com.medicare.service.DoctorService;
import com.medicare.service.impl.DoctorServiceImpl;

/*
 * DoctorUI
 * --------
 * Handles all console interactions for Doctor Module.
 * UI Layer → calls Service Layer only.
 */

public class DoctorUI {

    static Scanner sc = new Scanner(System.in);

    // Service object
    static DoctorService doctorService = new DoctorServiceImpl();

    // Doctor Menu Controller
    public static void doctorMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("         DOCTOR MANAGEMENT          ");
            System.out.println("====================================");

            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctor");
            System.out.println("3. View All Doctors");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back To Main Menu");

            System.out.print("\nEnter choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    viewDoctor();
                    break;

                case 3:
                    viewAllDoctors();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
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

    // Add new doctor
    private static void addDoctor() throws Exception {

        Doctor d = new Doctor();

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();

        try {
            doctorService.getDoctorById(id);

            // If no exception → doctor already exists
            throw new Exception("Doctor ID Already Exists!");

        } catch (Exception e) {

            // Continue only when "Not Found"
            if (!e.getMessage().contains("Not Found")) {
                throw e;
            }
        }

        d.setDoctorId(id);

        sc.nextLine();
        System.out.print("Enter Name: ");
        d.setName(sc.nextLine());

        System.out.print("Enter Specialization: ");
        d.setSpecialization(sc.nextLine());

        System.out.print("Enter Mobile: ");
        d.setMobile(sc.next());

        System.out.print("Enter Experience (years): ");
        d.setExperience(sc.nextInt());

        doctorService.addDoctor(d);

        System.out.println("\nDoctor Added Successfully!");
    }

    // View single doctor
    private static void viewDoctor() throws Exception {

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();

        System.out.println("\n---- Doctor Details ----");
        System.out.println(doctorService.getDoctorById(id));
    }

    // View all doctors
    private static void viewAllDoctors() throws Exception {

        System.out.println("\n---- All Doctors ----");

        doctorService.getAllDoctors()
                     .forEach(System.out::println);
    }

    // Update doctor with validation
    private static void updateDoctor() throws Exception {

        System.out.print("Enter Doctor ID: ");
        int uid = sc.nextInt();

        // VALIDATE FIRST
        doctorService.getDoctorById(uid);

        Doctor up = new Doctor();
        up.setDoctorId(uid);

        sc.nextLine();
        System.out.print("Enter New Name: ");
        up.setName(sc.nextLine());

        System.out.print("Enter New Specialization: ");
        up.setSpecialization(sc.nextLine());

        System.out.print("Enter New Mobile: ");
        up.setMobile(sc.next());

        System.out.print("Enter New Experience: ");
        up.setExperience(sc.nextInt());

        doctorService.updateDoctor(up);

        System.out.println("\nDoctor Updated Successfully!");
    }

    // Delete doctor
    private static void deleteDoctor() throws Exception {

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();

        // Validate first
        doctorService.getDoctorById(did);

        doctorService.deleteDoctor(did);

        System.out.println("\nDoctor Deleted Successfully!");
    }
}
