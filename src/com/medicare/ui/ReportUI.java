package com.medicare.ui;

import java.util.Scanner;

import com.medicare.service.ReportService;
import com.medicare.service.impl.ReportServiceImpl;

/*
 * ReportUI
 * --------
 * Handles console operations for Report Module.
 * Generates appointment, bill and revenue reports.
 */

public class ReportUI {

    static Scanner sc = new Scanner(System.in);

    // Service Object
    static ReportService reportService = new ReportServiceImpl();

    // Report Menu Controller
    public static void reportsMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("          REPORTS MODULE            ");
            System.out.println("====================================");

            System.out.println("1. Daily Appointment Report");
            System.out.println("2. Patient Wise Bill Report");
            System.out.println("3. Revenue Report");
            System.out.println("4. Back To Main Menu");

            System.out.print("\nEnter choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:
                    dailyAppointmentReport();
                    break;

                case 2:
                    patientBillReport();
                    break;

                case 3:
                    revenueReport();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println(" " + e.getMessage());
            }
        }
    }

    // Report: Appointments by Date
    private static void dailyAppointmentReport() throws Exception {

        System.out.println("\n---- Daily Appointment Report ----");

        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = sc.next();

        System.out.println("\nAppointments on " + date);
        System.out.println("------------------------------------");

        reportService.getAppointmentsByDate(date)
                     .forEach(System.out::println);
    }

    // Report: Bills of Particular Patient
    private static void patientBillReport() throws Exception {

        System.out.println("\n---- Patient Bill Report ----");

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.println("\nBills of Patient ID: " + pid);
        System.out.println("------------------------------------");

        reportService.getBillsByPatient(pid)
                     .forEach(System.out::println);
    }

    // Report: Total Revenue
    private static void revenueReport() throws Exception {

        System.out.println("\n---- Revenue Report ----");

        double total = reportService.getTotalRevenue();

        System.out.println("------------------------------------");
        System.out.println("Total Revenue = ₹ " + total);
        System.out.println("------------------------------------");
    }
}
