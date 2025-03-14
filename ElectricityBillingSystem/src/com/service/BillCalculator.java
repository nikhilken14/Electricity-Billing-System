package com.service;

public class BillCalculator {

    public double calculateBill(double units) {
        if (units <= 100) {
        	return units * 5;
        }
        else if (units <= 300) {
        	return (100 * 5) + ((units - 100) * 7);
        }
        else {
        	return (100 * 5) + (200 * 7) + ((units - 300) * 10);
        }
    }
}
