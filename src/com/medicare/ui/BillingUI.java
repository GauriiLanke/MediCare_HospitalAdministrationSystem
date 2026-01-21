package com.medicare.ui;

import java.util.Scanner;

import com.medicare.entity.Bill;
import com.medicare.service.BillingService;
import com.medicare.service.impl.BillingServiceImpl;

/*
 * BillingUI
 * ---------
 * Handles all console operations for Billing Module.
 * Also links to PaymentUI for payment related tasks.
 */

public class BillingUI {

    static Scanner sc = new Scanner(System.in);

    // Service Object
    static BillingService billService = new BillingServiceImpl();

    // Billing Menu Controller
    public static void billingMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("        BILLING MANAGEMENT          ");
            System.out.println("====================================");

            System.out.println("1. Generate Bill");
            System.out.println("2. View Bill");
            System.out.println("3. View All Bills");
            System.out.println("4. Update Bill");
            System.out.println("5. Delete Bill");
            System.out.println("6. Payment Management");
            System.out.println("7. Back");

            System.out.print("\nEnter choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:
                    generateBill();
                    break;

                case 2:
                    viewBill();
                    break;

                case 3:
                    viewAllBills();
                    break;

                case 4:
                    updateBill();
                    break;

                case 5:
                    deleteBill();
                    break;

                case 6:
                    PaymentUI.paymentMenu();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println(" " + e.getMessage());
            }
        }
    }

    // Generate new bill
    private static void generateBill() throws Exception {

        System.out.println("\n---- Generate Bill ----");

        // ===== STEP 1 : Bill ID Duplicate Check =====
        System.out.print("Enter Bill ID: ");
        int bid = sc.nextInt();

        try {
            billService.getBillById(bid);
            throw new Exception("Bill ID Already Exists!");

        } catch (Exception e) {
            if (!e.getMessage().contains("Not Found")) {
                throw e;
            }
        }

        // ===== STEP 2 : Patient Validation =====
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        try {
            new com.medicare.service.impl.PatientServiceImpl()
                .getPatientById(pid);

        } catch (Exception e) {
            throw new Exception("Patient Not Found! Create Patient First.");
        }

        // ===== STEP 3 : Amount Validation =====
        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new Exception("Amount must be greater than 0");
        }

        // ===== STEP 4 : Date =====
        sc.nextLine();
        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        // ===== STEP 5 : Status (NO VALIDATION NOW) =====
        System.out.print("Enter Status: ");
        String st = sc.next();

        // ===== CREATE OBJECT =====
        Bill b = new Bill(bid, pid, amt, date, st);

        billService.addBill(b);

        System.out.println("\nBill Generated Successfully!");
    }


    // View single bill
    private static void viewBill() throws Exception {

        System.out.print("\nEnter Bill ID: ");
        int sb = sc.nextInt();

        System.out.println("\n---- Bill Details ----");
        System.out.println(billService.getBillById(sb));
    }

    // View all bills
    private static void viewAllBills() throws Exception {

        System.out.println("\n---- All Bills ----");

        billService.getAllBills().forEach(System.out::println);
    }

    // Update bill
    private static void updateBill() throws Exception {

        System.out.print("\nEnter Bill ID: ");
        int ub = sc.nextInt();

        // Validate FIRST
        billService.getBillById(ub);

        System.out.print("Enter New Amount: ");
        double uamt = sc.nextDouble();

        if (uamt <= 0) {
            throw new Exception("Amount must be > 0");
        }

        System.out.print("Enter Status: ");
        String ust = sc.next();

        Bill up = new Bill();
        up.setBillId(ub);
        up.setAmount(uamt);
        up.setStatus(ust);

        billService.updateBill(up);

        System.out.println("\nBill Updated Successfully!");
    }


    // Delete bill
    private static void deleteBill() throws Exception {

        System.out.print("\nEnter Bill ID: ");
        int db = sc.nextInt();

        // Validate FIRST
        billService.getBillById(db);

        billService.deleteBill(db);

        System.out.println("\nBill Deleted Successfully!");
    }
}
