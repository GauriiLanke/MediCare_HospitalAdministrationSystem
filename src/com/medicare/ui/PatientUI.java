package com.medicare.ui;

import java.util.Scanner;

import com.medicare.entity.Patient;
import com.medicare.service.PatientService;
import com.medicare.service.impl.PatientServiceImpl;

/*
 * PatientUI
 * ---------
 * Handles all console operations for Patient Module.
 * UI Layer interacts only with Service Layer.
 */

public class PatientUI {

    static Scanner sc = new Scanner(System.in);

    // Service Object
    static PatientService service = new PatientServiceImpl();

    // Main Patient Menu
    public static void patientMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("        PATIENT MANAGEMENT          ");
            System.out.println("====================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back");

            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatient();
                    break;

                case 3:
                    viewAllPatients();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
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

    // Add new patient
    
    private static void addPatient() throws Exception {

        System.out.println("\n---- Add Patient ----");

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        try {
            service.getPatientById(id);

            // If above line DOES NOT throw exception → means exists
            throw new Exception("\nPatient ID Already Exists!");

        } catch (Exception e) {

            // If it is DataNotFoundException → good, continue
            if (!e.getMessage().contains("Not Found")) {
                throw e;    // real duplicate case
            }
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Mobile: ");
        String mobile = sc.next();

        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, mobile, disease);

        service.addPatient(p);

        System.out.println("\nPatient Added Successfully!");
    }


    // View single patient
    private static void viewPatient() throws Exception {

        System.out.print("\nEnter Patient ID: ");
        int pid = sc.nextInt();

        System.out.println("\n---- Patient Details ----");
        System.out.println(service.getPatientById(pid));
    }

    // View all patients
    private static void viewAllPatients() throws Exception {

        System.out.println("\n---- All Patients ----");

        service.getAllPatients()
               .forEach(System.out::println);
    }

    // Update patient with validation
    private static void updatePatient() throws Exception {

        System.out.print("\nEnter Patient ID: ");
        int uid = sc.nextInt();

        // Validate FIRST
        service.getPatientById(uid);

        sc.nextLine();
        System.out.print("Enter New Name: ");
        String uname = sc.nextLine();

        System.out.print("Enter New Age: ");
        int uage = sc.nextInt();

        System.out.print("Enter New Mobile: ");
        String umobile = sc.next();

        sc.nextLine();
        System.out.print("Enter New Disease: ");
        String udisease = sc.nextLine();

        Patient up = new Patient(uid, uname, uage, umobile, udisease);

        service.updatePatient(up);

        System.out.println("\nPatient Updated Successfully!");
    }

    // Delete patient
    private static void deletePatient() throws Exception {

        System.out.print("\nEnter Patient ID: ");
        int did = sc.nextInt();

        // Validate FIRST
        service.getPatientById(did);

        service.deletePatient(did);

        System.out.println("\nPatient Deleted Successfully!");
    }
}
