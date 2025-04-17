package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vehicle[] inventory = new Vehicle[20];

        Vehicle vehicle = new Vehicle(101, "Dodge Charger",
                "Grey", 20000, 15000);

        inventory[0] = vehicle;
        inventory[1] = new Vehicle(102, "Toyota Corolla", "White", 18000, 13000);
        inventory[2] = new Vehicle(103, "Ford Mustang", "Red", 28000, 21000);
        inventory[3] = new Vehicle(104, "Honda Civic", "Blue", 19000, 14000);
        inventory[4] = new Vehicle(105, "Chevrolet Tahoe", "Black", 35000, 29000);
        inventory[5] = new Vehicle(106, "Subaru Outback", "Green", 25000, 20000);

        //main menu
        //while(true) makes an infinite loop by definition
        Scanner scanner = new Scanner(System.in);

        while(true){
            //Show the menu -> ask the user for their input
            System.out.println("What do you want to do?");
            System.out.println("1) List All Vehicles");
            System.out.println("2) Search By Make and Model");
            System.out.println("3) Search By Price Range");
            System.out.println("4) Search By Color");
            System.out.println("5) Add a vehicle");
            System.out.println("6) Quit");

            int userChoice = scanner.nextInt();

            switch(userChoice){
                case 1:
                    displayCars(inventory);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select 1 through 6");
                    break;
            }
        }

    }

    public static void displayCars(Vehicle[] inventory){
        for(int i = 0; i < inventory.length; i++){
            //Is there a car at this index?
            Vehicle currentVehicle = inventory[i];
            //there are two options -> currentVehicle is null, or it isn't
            if(currentVehicle != null){
                System.out.println(currentVehicle.getMakeModel());
            }
        }
    }
}