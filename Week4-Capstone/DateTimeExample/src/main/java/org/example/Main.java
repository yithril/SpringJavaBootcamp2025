package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        Appointment appointment = new Appointment(date, time, "Doctor's Visit");

        // Display it
        appointment.displayAppointment();
    }
}