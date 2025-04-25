package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Product> readFile(){
        try{
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //skip the first line
            bufferedReader.readLine();

            String input;

            List<Product> productList = new ArrayList<>();
            while((input = bufferedReader.readLine()) != null){
                String[] row = input.split("\\|");
                //index 0 is the SKU, index 1 is ProductName, index 2 is the price, and index 3 is department
                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]);
                String department = row[3];
                Product product = new Product(sku, productName, price, department);
                productList.add(product);
            }

            bufferedReader.close();

            return productList;
        }
        catch (IOException ex){
            System.out.println("Failed to load csv file.");
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    //File writing example
    public static void writeFile(List<Product> productList) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/products.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the header
            bufferedWriter.write("SKU|Product Name|Price|Department");
            bufferedWriter.newLine();

            // Write product rows
            for (Product product : productList) {
                String line = product.getSku() + "|" +
                        product.getProductName() + "|" +
                        product.getPrice() + "|" +
                        product.getDepartment();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            // Close the writer
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Failed to write to csv file.");
            ex.printStackTrace();
        }
    }
}
