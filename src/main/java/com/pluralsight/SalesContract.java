package com.pluralsight;

public class SalesContract extends Contract {

    private boolean finance;

    public SalesContract(String date,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold,
                         boolean finance) {

        super(date, customerName, customerEmail, vehicleSold);

        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public double getTotalPrice() {

        double price = vehicleSold.getPrice();

        double salesTax = price * 0.05;

        double recordingFee = 100;

        double processingFee;

        if (price < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        return price + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {

        if (!finance) {
            return 0;
        }

        double totalPrice = getTotalPrice();

        double interestRate;
        int months;

        if (vehicleSold.getPrice() >= 10000) {

            interestRate = 0.0425;
            months = 48;

        } else {

            interestRate = 0.0525;
            months = 24;
        }

        return (totalPrice * (1 + interestRate)) / months;
    }
}