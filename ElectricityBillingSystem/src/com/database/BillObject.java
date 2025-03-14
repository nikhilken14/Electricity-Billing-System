package com.database;

public class BillObject {
    private int id;
    private String month;
    private double units;
    private double billAmount;

    public BillObject(int id, String month, double units, double billAmount) {
        this.id = id;
        this.month = month;
        this.units = units;
        this.billAmount = billAmount;
    }

    public int getId() { return id; }
    public String getMonth() { return month; }
    public double getUnits() { return units; }
    public double getBillAmount() { return billAmount; }

    @Override
    public String toString() {
        return "BillRecord [id=" + id + ", month=" + month + ", units=" + units + ", billAmount=" + billAmount + "]";
    }
}