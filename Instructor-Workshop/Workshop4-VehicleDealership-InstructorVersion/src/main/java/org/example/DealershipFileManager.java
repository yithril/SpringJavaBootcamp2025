package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {
    public Dealership getDealership(){
        Dealership dealership = new Dealership("Hop Motors", "123 Wherever St.", "555-1234");

        try{
            FileInputStream fs = new FileInputStream("src/main/resources/vehicles.csv");

            Scanner scanner = new Scanner(fs);

            //skip first line
            scanner.nextLine();

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                String[] dataRow = input.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(dataRow[0]), Integer.parseInt(dataRow[1]), dataRow[2],
                        dataRow[3], dataRow[5], dataRow[4], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));

                dealership.addVehicle(vehicle);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Couldn't find the file to read from sorry.");
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try{
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
