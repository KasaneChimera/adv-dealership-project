package com.pluralsight;

public class LeaseContract extends Contract {

    public LeaseContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold) {

        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {

        double price = vehicleSold.getPrice();

        double expectedEndingValue = price * 0.5;

        double leaseFee = price * 0.07;

        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {

        return getTotalPrice() / 36;
    }
}