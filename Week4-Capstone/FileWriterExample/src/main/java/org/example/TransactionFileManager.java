package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionFileManager {

    public static void appendTransaction(Transaction transaction) {
        String filePath = "src/main/resources/transactions.csv";
        File file = new File(filePath);

        try {
            // Step 1: Make sure the folder exists
            File folder = file.getParentFile();
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Step 2: Check if file exists and is empty
            boolean fileExists = file.exists();
            boolean isEmpty = !fileExists || file.length() == 0;

            // Step 3: Open file in append mode
            FileWriter writer = new FileWriter(file, true);

            // Step 4: Write header if it's a new or empty file
            if (isEmpty) {
                writer.write("date|time|description|vendor|amount\n");
            }

            // Step 5: Write the transaction
            writer.write(transaction.toString() + "\n");

            // Step 6: Close the writer
            writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong while saving the transaction.");
            e.printStackTrace();
        }
    }
}
