package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {
    @Test
    public void loadFilesFromFile_Succeeds(){
        DealershipFileManager fileManager = new DealershipFileManager();

        Dealership dealership = fileManager.getDealership();

        List<Vehicle> testVehicles = dealership.getAllVehicles();

        assertEquals(3, testVehicles.size());

        //These asserts prove that the data I loaded from the file landed in the right place
        //Data row it pulled from looks like this, so the first car in the arraylist should have these values
        //10112|1993|Ford|Explorer|SUV|Red|525123|995.00
        assertEquals(10112, testVehicles.get(0).getVin());
        assertEquals(1993, testVehicles.get(0).getYear());
        assertEquals("Ford", testVehicles.get(0).getMake());
        assertEquals("Explorer", testVehicles.get(0).getModel());
        assertEquals("SUV", testVehicles.get(0).getVehicleType());
        assertEquals("Red", testVehicles.get(0).getColor());
        assertEquals(525123, testVehicles.get(0).getOdometer());
        assertEquals(995.00, testVehicles.get(0).getPrice());
    }
}