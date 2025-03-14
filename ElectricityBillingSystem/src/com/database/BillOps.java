package com.database;

import com.connectiondb.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillOps {
    public void saveBill(String month, double units, double billAmount) throws SQLException {
        String query = "INSERT INTO electricitybills (month, units, bill) VALUES (?, ?, ?)";
        try (Connection conn = DataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, month);
            stmt.setDouble(2, units);
            stmt.setDouble(3, billAmount);
            stmt.executeUpdate();
        }
    }

    public List<BillObject> getLastSixBills() throws SQLException {
        List<BillObject> bills = new ArrayList<>();
        String query = "SELECT * FROM electricitybills ORDER BY id DESC LIMIT 6";
        try (Connection conn = DataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                bills.add(new BillObject(rs.getInt("id"), rs.getString("month"), rs.getDouble("units"), rs.getDouble("bill")));
            }
        }
        return bills;
    }
}