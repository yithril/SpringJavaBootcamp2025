package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    public void determineHouseValue(){
        //Arrange
        //Condition, lot size, sq ft
        House testHouse = new House("McMansion", "12-25-2000",
                100000, "123 Somewhere St.", 1,
                2000, 1000);

        House testHouse2 = new House("McMansion", "12-25-2000",
                100000, "123 Somewhere St.", 2,
                2000, 1000);

        House testHouse3 = new House("McMansion", "12-25-2000",
                100000, "123 Somewhere St.", 3,
                2000, 1000);

        House testHouse4 = new House("McMansion", "12-25-2000",
                100000, "123 Somewhere St.", 4,
                2000, 1000);

        //Act
        double result = testHouse.getValue();
        double result2 = testHouse2.getValue();
        double result3 = testHouse3.getValue();
        double result4 = testHouse4.getValue();

        //Assert
        assertEquals(360250, result);
    }
}