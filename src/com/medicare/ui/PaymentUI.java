package com.medicare.ui;

import java.util.Scanner;

import com.medicare.entity.Payment;
import com.medicare.service.PaymentService;
import com.medicare.service.impl.BillingServiceImpl;
import com.medicare.service.impl.PaymentServiceImpl;

/*
 * PaymentUI
 * ---------
 * Handles console operations for Payment Module.
 * UI Layer interacts with PaymentService only.
 */

public class PaymentUI {

    static Scanner sc = new Scanner(System.in);

    // Service Object
    static PaymentService paymentService = new PaymentServiceImpl();

    // Payment Menu Controller
    public static void paymentMenu() {

        while (true) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("        PAYMENT MANAGEMENT          ");
            System.out.println("====================================");

            System.out.println("1. Add Payment");
            System.out.println("2. View Payment");
            System.out.println("3. View All Payments");
            System.out.println("4. Update Payment");
            System.out.println("5. Delete Payment");
            System.out.println("6. Back");

            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                case 1:
                    addPayment();
                    break;

                case 2:
                    viewPayment();
                    break;

                case 3:
                    viewAllPayments();
                    break;

                case 4:
                    updatePayment();
                    break;

                case 5:
                    deletePayment();
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

    // Add new payment
    private static void addPayment() throws Exception {

        System.out.println("\n---- Add Payment ----");

        // ===== PAYMENT ID CHECK =====
        System.out.print("Enter Payment ID: ");
        int payId = sc.nextInt();

        try {
            paymentService.getPaymentById(payId);
            throw new Exception("Payment ID Already Exists!");

        } catch (Exception e) {
            if (!e.getMessage().contains("Not Found")) {
                throw e;
            }
        }

        // ===== BILL CHECK =====
        System.out.print("Enter Bill ID: ");
        int billId = sc.nextInt();

        try {
            new BillingServiceImpl().getBillById(billId);

        } catch (Exception e) {
            throw new Exception("Bill Not Found! Create Bill First.");
        }

        // ===== AMOUNT ONLY VALIDATION =====
        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new Exception("Amount must be greater than 0");
        }

        sc.nextLine();
        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        // ----- NO VALIDATION FOR MODE -----
        System.out.print("Enter Mode: ");
        String mode = sc.next();

        // ----- NO VALIDATION FOR STATUS -----
        System.out.print("Enter Status: ");
        String status = sc.next();

        Payment p = new Payment(payId, billId, amt, date, mode, status);

        paymentService.addPayment(p);

        System.out.println("\nPayment Added Successfully!");
    }


    // View single payment
    private static void viewPayment() throws Exception {

        System.out.print("\nEnter Payment ID: ");
        int id = sc.nextInt();

        System.out.println("\n---- Payment Details ----");
        System.out.println(paymentService.getPaymentById(id));
    }

    // View all payments
    private static void viewAllPayments() throws Exception {

        System.out.println("\n---- All Payments ----");

        paymentService.getAllPayments()
                      .forEach(System.out::println);
    }

    // Update payment
    private static void updatePayment() throws Exception {

        System.out.print("\nEnter Payment ID: ");
        int uid = sc.nextInt();

        // Validate FIRST
        paymentService.getPaymentById(uid);

        Payment up = new Payment();
        up.setPaymentId(uid);

        System.out.print("Enter New Amount: ");
        up.setAmount(sc.nextDouble());

        System.out.print("Enter New Status (SUCCESS/PENDING): ");
        up.setStatus(sc.next());

        paymentService.updatePayment(up);

        System.out.println("\nPayment Updated Successfully!");
    }

    // Delete payment
    private static void deletePayment() throws Exception {

        System.out.print("\nEnter Payment ID: ");
        int did = sc.nextInt();

        // Validate FIRST
        paymentService.getPaymentById(did);

        paymentService.deletePayment(did);

        System.out.println("\nPayment Deleted Successfully!");
    }
}
