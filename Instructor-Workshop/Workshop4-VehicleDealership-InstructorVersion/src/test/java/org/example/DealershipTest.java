package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    private Dealership dealership;

    @BeforeEach
    public void setUp() {
        dealership = new Dealership("Sample Dealership", "123 Main St", "555-555-5555");
    }

    @Test
    public void testGetVehiclesByPrice() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Red", "Sedan", 15000, 25000.0);
        Vehicle vehicle2 = new Vehicle(2, 2019, "Honda", "Civic", "Blue", "Sedan", 12000, 20000.0);
        Vehicle vehicle3 = new Vehicle(3, 2021, "Ford", "F-150", "Black", "Truck", 10000, 35000.0);

        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);

        List<Vehicle> result = dealership.getVehiclesByPrice(20000.0, 30000.0);

        assertEquals(2, result.size());
        assertTrue(result.contains(vehicle1));
        assertTrue(result.contains(vehicle2));
        assertFalse(result.contains(vehicle3));
    }

    @Test
    public void testGetVehiclesByMakeModel() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Red", "Sedan", 15000, 25000.0);
        Vehicle vehicle2 = new Vehicle(2, 2019, "Honda", "Civic", "Blue", "Sedan", 12000, 20000.0);
        Vehicle vehicle3 = new Vehicle(3, 2021, "Toyota", "Corolla", "Silver", "Sedan", 10000, 22000.0);

        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);

        List<Vehicle> result = dealership.getVehiclesByMakeModel("Toyota", "Camry");

        assertEquals(1, result.size());
        assertTrue(result.contains(vehicle1));
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Red", "Sedan", 15000, 25000.0);

        dealership.addVehicle(vehicle);
        List<Vehicle> vehicles = dealership.getAllVehicles();

        assertTrue(vehicles.contains(vehicle));
    }

    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Red", "Sedan", 15000, 25000.0);

        dealership.addVehicle(vehicle);
        dealership.removeVehicle(vehicle);
        List<Vehicle> vehicles = dealership.getAllVehicles();

        assertFalse(vehicles.contains(vehicle));
    }
}