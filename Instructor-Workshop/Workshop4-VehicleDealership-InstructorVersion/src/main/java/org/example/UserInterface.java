package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){
        init();
    }

    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if (this.dealership == null) {
            System.out.println("ERROR: The dealership data file is missing or malformed.");
            System.out.println("Please ensure 'vehicles.csv' exists and has the correct format.");
            System.out.println("The application cannot continue.");
            System.exit(1);
        }
    }

    public void display(){
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while(isRunning){
            System.out.printf("Welcome to %s, the best place to buy a car! %n", this.dealership.getName());
            System.out.printf("Located at %s %n", this.dealership.getAddress());
            System.out.println("Select from the following options:");
            System.out.println("0. Exit Program");
            System.out.println("1. View all vehicles");
            System.out.println("2. Search for vehicles by price");
            System.out.println("3. Search for vehicles by make/model");
            System.out.println("4. Search for vehicles by year");
            System.out.println("5. Search for vehicles by color");
            System.out.println("6. Search for vehicles by mileage");
            System.out.println("7. Search for vehicles by vehicleType");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");

            try{
                int userInput = scanner.nextInt();

                switch(userInput){
                    case 0:
                        DealershipFileManager fileManager = new DealershipFileManager();
                        fileManager.saveDealership(dealership);
                        System.exit(0);
                        break;
                    case 1:
                        processGetAllVehiclesRequest();
                        break;
                    case 2:
                        processGetByPriceRequest();
                        break;
                    case 3:
                        processGetByMakeModelRequest();
                        break;
                    case 4:
                        processGetByYearRequest();
                        break;
                    case 5:
                        processGetByColorRequest();
                        break;
                    case 6:
                        processGetByMileageRequest();
                        break;
                    case 7:
                        processGetByVehicleTypeRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    default:
                        System.out.println("Not an option, please try again.");
                        break;
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please select a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public void processGetByPriceRequest(){
        boolean isGettingByPrice = true;

        while(isGettingByPrice){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum price of the vehicle you are looking for?");
                double minPrice = scanner.nextDouble();
                System.out.println("What is the maximum price of the vehicle you are looking for?");
                double maxPrice = scanner.nextDouble();

                if(minPrice < maxPrice){
                    System.out.printf("Here are all the vehicles between %d and %d", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehicleList);
                    isGettingByPrice = false;
                }
                else{
                    System.out.println("Min price cannot be greater than max price");
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Price must be a number");
            }
        }
    }

    public void processGetByMakeModelRequest(){
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the make of the vehicle you are looking for:");
                String make = scanner.nextLine();
                System.out.println("Enter the model of the vehicle you are looking for:");
                String model = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                isGettingByMakeModel = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void processGetByYearRequest(){
        boolean isGettingByYear = true;

        while (isGettingByYear) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the minimum year of the vehicle you are looking for:");
                int minYear = scanner.nextInt();
                System.out.println("Enter the maximum year of the vehicle you are looking for:");
                int maxYear = scanner.nextInt();

                if (minYear <= maxYear) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehicleList);
                    isGettingByYear = false;
                } else {
                    System.out.println("Minimum year cannot be greater than maximum year.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Year must be a number.");
            }
        }
    }

    public void processGetByColorRequest(){
        boolean isGettingByColor = true;

        while (isGettingByColor) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the color of the vehicle you are looking for:");
                String color = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
                displayVehicles(vehicleList);
                isGettingByColor = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void processGetByMileageRequest(){
        boolean isGettingByMileage = true;

        while (isGettingByMileage) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the minimum mileage of the vehicle you are looking for:");
                int minMileage = scanner.nextInt();
                System.out.println("Enter the maximum mileage of the vehicle you are looking for:");
                int maxMileage = scanner.nextInt();

                if (minMileage <= maxMileage) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    displayVehicles(vehicleList);
                    isGettingByMileage = false;
                } else {
                    System.out.println("Minimum mileage cannot be greater than maximum mileage.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Mileage must be a number.");
            }
        }
    }

    public void processGetByVehicleTypeRequest(){
        boolean isGettingByVehicleType = true;

        while (isGettingByVehicleType) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the vehicle type you are looking for:");
                System.out.println("Available types: " + Arrays.toString(VehicleType.values()));

                String input = scanner.nextLine().trim().toUpperCase();
                VehicleType vehicleType = VehicleType.valueOf(input);

                List<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
                displayVehicles(vehicleList);
                isGettingByVehicleType = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(this.dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){
        boolean isAddingVehicle = true;

        while (isAddingVehicle) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter VIN (Vehicle Identification Number):");
                int vin = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter year:");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter make:");
                String make = scanner.nextLine();

                System.out.println("Enter model:");
                String model = scanner.nextLine();

                System.out.println("Enter color:");
                String color = scanner.nextLine();

                VehicleType vehicleType = null;
                while (vehicleType == null) {
                    System.out.println("Enter vehicle type (e.g., SUV, TRUCK, SEDAN):");
                    String vehicleTypeInput = scanner.nextLine().trim().toUpperCase();
                    try {
                        vehicleType = VehicleType.valueOf(vehicleTypeInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid vehicle type. Please try again.");
                    }
                }

                System.out.println("Enter odometer reading:");
                int odometer = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter price:");
                double price = scanner.nextDouble();

                Vehicle newVehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer, price);

                dealership.addVehicle(newVehicle);

                System.out.println("Vehicle added successfully!");
                isAddingVehicle = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please check your input format and try again.");
            }
        }
    }

    public void processRemoveVehicleRequest(){
        boolean isRemovingVehicle = true;

        while (isRemovingVehicle) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the VIN (Vehicle Identification Number) of the vehicle you want to remove:");
                int vinToRemove = scanner.nextInt();
                scanner.nextLine();

                // Search for the vehicle with the VIN in the inventory
                List<Vehicle> inventory = dealership.getAllVehicles();
                Vehicle vehicleToRemove = null;

                for (Vehicle vehicle : inventory) {
                    if (vehicle.getVin() == vinToRemove) {
                        vehicleToRemove = vehicle;
                        break;
                    }
                }

                if (vehicleToRemove != null) {
                    // Remove the vehicle from the inventory
                    dealership.removeVehicle(vehicleToRemove);
                    System.out.println("Vehicle removed successfully!");
                } else {
                    System.out.println("Vehicle with VIN " + vinToRemove + " not found in inventory.");
                }

                isRemovingVehicle = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. VIN must be a number.");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }
}
