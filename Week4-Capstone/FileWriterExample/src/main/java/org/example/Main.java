package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // First dummy transaction
        Transaction t1 = new Transaction(
                LocalDate.of(2023, 4, 15),
                LocalTime.of(10, 13, 25),
                "ergonomic keyboard",
                "Amazon",
                -89.50
        );

        // Second dummy transaction
        Transaction t2 = new Transaction(
                LocalDate.of(2023, 4, 15),
                LocalTime.of(11, 15, 0),
                "Invoice 1001 paid",
                "Joe",
                1500.00
        );

        // Write both to the file
        TransactionFileManager.appendTransaction(t1);
        TransactionFileManager.appendTransaction(t2);

        System.out.println("Transactions written successfully!");
    }
}