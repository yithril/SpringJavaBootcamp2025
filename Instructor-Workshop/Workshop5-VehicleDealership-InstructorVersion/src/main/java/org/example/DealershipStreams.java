package org.example;

import java.util.ArrayList;
import java.util.List;

public class DealershipStreams {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory = new ArrayList<>();

    public DealershipStreams(String name, String address, String phone) {
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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream()
                .filter(v -> v.getPrice() >= min && v.getPrice() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream()
                .filter(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                .toList();
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream()
                .filter(v -> v.getYear() >= min && v.getYear() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color))
                .toList();
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream()
                .filter(v -> v.getOdometer() >= min && v.getOdometer() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        return inventory.stream()
                .filter(v -> v.getVehicleType() == vehicleType)
                .toList();
    }

    public List<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicleByVin(int vin) {
        inventory.removeIf(v -> v.getVin() == vin);
    }
}
