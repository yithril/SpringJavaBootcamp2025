package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {
    private final String FILE_PATH = "src/main/resources/vehicles.csv";

    public Dealership getDealership() {
        Dealership dealership = null;
        FileInputStream fs = null;
        Scanner scanner = null;

        try {
            fs = new FileInputStream(FILE_PATH);
            scanner = new Scanner(fs);

            // Read first line: dealership info
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                String[] dealershipInfo = header.split("\\|");

                if (dealershipInfo.length != 3) {
                    System.out.println("ERROR: Dealership header line is malformed. Program cannot continue.");
                    return null; // fail fast – let the caller handle null if needed
                }

                dealership = new Dealership(
                        dealershipInfo[0].trim(),
                        dealershipInfo[1].trim(),
                        dealershipInfo[2].trim()
                );
            } else {
                System.out.println("ERROR: File is empty. Program cannot continue.");
                return null;
            }

            // Read and parse each vehicle
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] dataRow = input.split("\\|");

                try {
                    if (dataRow.length != 8) {
                        throw new IllegalArgumentException("Expected 8 columns but got " + dataRow.length);
                    }

                    int vin = Integer.parseInt(dataRow[0]);
                    int year = Integer.parseInt(dataRow[1]);
                    String make = dataRow[2];
                    String model = dataRow[3];
                    VehicleType type = VehicleType.valueOf(dataRow[4].trim().toUpperCase());
                    String color = dataRow[5];
                    int odometer = Integer.parseInt(dataRow[6]);
                    double price = Double.parseDouble(dataRow[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, type, odometer, price);
                    dealership.addVehicle(vehicle);

                } catch (Exception e) {
                    System.out.println("Skipping bad vehicle row: " + input);
                    System.out.println("Reason: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Using default dealership info.");
            dealership = new Dealership("Hop Motors", "123 Wherever St.", "555-1234");

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try{
            //This is not in append mode so it will overwrite the whole file
            FileWriter fw = new FileWriter("src/main/resources/vehicles.csv");

            //Write the header
            String headerRow = String.format("%s|%s|%s %n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            fw.write(headerRow);

            for(Vehicle vehicle : dealership.getAllVehicles()){
                String row = String.format("%d|%d|%s|%s|%s|%s|%d|%f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                                                                      vehicle.getColor(), vehicle.getVehicleType(), vehicle.getOdometer(), vehicle.getPrice());

                fw.write(row);
            }

            fw.close();
        }
        catch (IOException ex){
            System.out.println("Had a problem writing to the file cuz of: " + ex);
        }
    }
}
