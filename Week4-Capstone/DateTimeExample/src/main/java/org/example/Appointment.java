package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String description;

    // Constructor
    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, String description) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.description = description;
    }

    // Method to display the appointment nicely formatted
    public void displayAppointment() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = appointmentDate.format(dateFormatter);
        String formattedTime = appointmentTime.format(timeFormatter);

        System.out.println("Appointment on " + formattedDate + " at " + formattedTime + ": " + description);
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
