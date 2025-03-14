package com.service;

import com.database.*;
import java.sql.SQLException;
import java.util.List;

public class BillPredictor {
	private final BillOps ops;

    public BillPredictor() {
        this.ops = new BillOps();
    }

    public double predictBillForNextMonth() throws SQLException {
        List<BillObject> bills = ops.getLastSixBills();
        int n = bills.size();
        if (n < 2) return -1; 

        double xSum = 0, ySum = 0, xySum = 0, xSquaredSum = 0;
        for (int i = 0; i < n; i++) {
            xSum += i + 1;
            ySum += bills.get(i).getBillAmount();
            xySum += (i + 1) * bills.get(i).getBillAmount();
            xSquaredSum += (i + 1) * (i + 1);
        }

        double slope = (n * xySum - xSum * ySum) / (n * xSquaredSum - xSum * xSum);
        double intercept = (ySum - slope * xSum) / n;
        return slope * (n + 1) + intercept;
    }
}
