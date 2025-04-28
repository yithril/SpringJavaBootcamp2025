package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ParseExample {
    public static void main(String[] args) {
        String dateString = "2025-04-28";
        String timeString = "14:30:00";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDate parsedDate = LocalDate.parse(dateString, dateFormatter);
        LocalTime parsedTime = LocalTime.parse(timeString, timeFormatter);

        System.out.println("Parsed Date: " + parsedDate);
        System.out.println("Parsed Time: " + parsedTime);
    }
}
