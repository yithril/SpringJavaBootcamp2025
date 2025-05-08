package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {
   //annotation @
    @Test
    public void roomIsClean_roomIsNotOccupied_Available(){
        //Arrange
        //Make any objects or variables you need for your test
        Room room = new Room(3, 10, false, false);

        //Act
        boolean result = room.isAvailable();

        //Assert
        //Junit has assertions, it's a special kind of method in JUnit
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({
          "true, true, false",
          "false, false, true",
          "true, false, false",
          "false, true, false"
    })
    public void testAvailability(boolean isOccupied, boolean isDirty, boolean expected){
        Room room = new Room(4, 20, isOccupied, isDirty);

        boolean result = room.isAvailable();

        assertEquals(expected, result);
    }
}