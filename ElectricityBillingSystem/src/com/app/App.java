package com.app;

import com.service.BillCalculator;
import com.service.BillPredictor;
import com.database.*;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillCalculator calculator = new BillCalculator();
        BillOps ops = new BillOps();
        BillPredictor predictor = new BillPredictor();

        while (true) {
            System.out.println("\nElectricity Billing System:");
            System.out.println("1. Calculate and Save Bill");
            System.out.println("2. Predict Next Month's Bill");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter month (e.g., Jan, Feb): ");
                String month = scanner.nextLine();
                System.out.print("Enter electricity units: ");
                double units = scanner.nextDouble();
                double bill = calculator.calculateBill(units);
                System.out.println("Total Bill for " + month + ": ₹" + bill);
                try {
                    ops.saveBill(month, units, bill);
                    System.out.println("Bill saved successfully.");
                } catch (SQLException e) {
                    System.err.println("Error saving bill: " + e.getMessage());
                }
            } 
            else if (choice == 2) {
                try {
                    double predictedBill = predictor.predictBillForNextMonth();
                    System.out.println("Predicted Bill for Next Month: ₹" + predictedBill);
                } catch (SQLException e) {
                    System.err.println("Error predicting bill: " + e.getMessage());
                }
            } 
            else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
