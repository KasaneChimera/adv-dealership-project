package com.pluralsight;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ContractDataManager {

    public void saveContract(Contract contract) {

        try {

            PrintWriter pw =
                    new PrintWriter(
                            new FileWriter("contracts.csv", true));

            if (contract instanceof SalesContract) {

                SalesContract sales =
                        (SalesContract) contract;

                pw.println(
                        "SALE|" +
                                sales.getDate() + "|" +
                                sales.getCustomerName() + "|" +
                                sales.getCustomerEmail() + "|" +
                                sales.getVehicleSold().getVin() + "|" +
                                sales.getMonthlyPayment()
                );
            }

            else if (contract instanceof LeaseContract) {

                LeaseContract lease =
                        (LeaseContract) contract;

                pw.println(
                        "LEASE|" +
                                lease.getDate() + "|" +
                                lease.getCustomerName() + "|" +
                                lease.getCustomerEmail() + "|" +
                                lease.getVehicleSold().getVin() + "|" +
                                lease.getMonthlyPayment()
                );
            }

            pw.close();

        } catch (Exception e) {

            System.out.println("Error saving contract.");
        }
    }
}