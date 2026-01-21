/*
 * Developers:
 * Lanke Gauri Arvind
 * Lanke Payal Sambhaji
 * Hon Sakshi Santosh
 * Shaikh Fiza Ansar
 */

package com.medicare.main;

import java.util.Scanner;

import com.medicare.ui.PatientUI;
import com.medicare.ui.DoctorUI;
import com.medicare.ui.AppointmentUI;
import com.medicare.ui.BillingUI;
import com.medicare.ui.ReportUI;

/*
 * MainApp
 * -------
 * Entry point of MediCare System.
 * Only responsible for navigation.
 */

public class MainApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println();
            System.out.println("==================================================");
            System.out.println("        MEDICARE - HOSPITAL ADMINISTRATION SYSTEM      ");
            System.out.println("==================================================");

            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing & Payment Management");
            System.out.println("5. Reports Module");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                PatientUI.patientMenu();
                break;

            case 2:
                DoctorUI.doctorMenu();
                break;

            case 3:
                AppointmentUI.appointmentMenu();
                break;

            case 4:
                BillingUI.billingMenu();
                break;

            case 5:
                ReportUI.reportsMenu();
                break;

            case 6:
                System.out.println("\nThank you for using MediCare System");
                System.out.println("\nSystem Closed Successfully!");
                System.exit(0);

            default:
                System.out.println("\nInvalid Choice! Please Try Again");
            }
        }
    }
}
