package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType() == vehicleType){
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
    }
}
