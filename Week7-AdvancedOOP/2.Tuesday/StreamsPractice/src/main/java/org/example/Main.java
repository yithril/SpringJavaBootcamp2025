package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> database = Arrays.asList(
                new Person(1, "Jack", "Brown", "Architect", "Texas", 48855),
                new Person(2, "Bob", "Smith", "Nurse", "Pennsylvania", 100711),
                new Person(3, "Ivy", "Smith", "Teacher", "Florida", 109366),
                new Person(4, "Emily", "Miller", "Nurse", "California", 53896),
                new Person(5, "Alice", "Garcia", "Doctor", "California", 57275),
                new Person(6, "Ivy", "Martinez", "Teacher", "California", 128061),
                new Person(7, "Alice", "Smith", "Farmer", "Texas", 41560),
                new Person(8, "Jack", "Garcia", "Nurse", "California", 97243),
                new Person(9, "Emily", "Smith", "Engineer", "Texas", 71966),
                new Person(10, "Alice", "Johnson", "Chef", "North Carolina", 96226),
                new Person(11, "Ivy", "Smith", "Chef", "Michigan", 113865),
                new Person(12, "Charlie", "Lee", "Doctor", "Illinois", 104835),
                new Person(13, "Grace", "Jones", "Farmer", "California", 114999),
                new Person(14, "Jack", "Davis", "Teacher", "Michigan", 89819),
                new Person(15, "Emily", "Miller", "Farmer", "North Carolina", 41535),
                new Person(16, "David", "Martinez", "Engineer", "Georgia", 70593),
                new Person(17, "Bob", "Johnson", "Doctor", "New York", 93464),
                new Person(18, "Emily", "Lee", "Chef", "New York", 133583),
                new Person(19, "Frank", "Garcia", "Teacher", "Illinois", 82528),
                new Person(20, "Charlie", "Brown", "Doctor", "Florida", 105548),
                new Person(21, "Alice", "Martinez", "Engineer", "California", 77609),
                new Person(22, "Jack", "Lee", "Farmer", "California", 126977),
                new Person(23, "Ivy", "Martinez", "Chef", "Texas", 81136),
                new Person(24, "Alice", "Brown", "Architect", "Ohio", 51435),
                new Person(25, "Charlie", "Smith", "Architect", "North Carolina", 66140),
                new Person(26, "Jack", "Johnson", "Engineer", "Florida", 143981),
                new Person(27, "David", "Garcia", "Teacher", "Ohio", 107622),
                new Person(28, "Emily", "Smith", "Nurse", "Georgia", 74796),
                new Person(29, "Grace", "Johnson", "Scientist", "Georgia", 148055),
                new Person(30, "Henry", "Martinez", "Scientist", "Illinois", 127989)
        );

        // 1. Print the full names of all people who live in Texas.
        database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("Texas"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 2. Print the full names of all people who are teachers.
        database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Teacher"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 3. Print the full names of people who earn more than $90,000.
        database.stream()
                .filter(person -> person.getYearlyIncome() > 90000)
                .forEach(person -> System.out.println(person.getFullName()));

        // 4. Print the full names of people who live in Florida and earn less than $60,000.
        database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("Florida") && person.getYearlyIncome() < 60000)
                .forEach(person -> System.out.println(person.getFullName()));

        // 5. Print the full names of doctors who live in California.
        database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Doctor") && person.getState().equalsIgnoreCase("California"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 6. Print the full names of people who do not live in New York.
        database.stream()
                .filter(person -> !person.getState().equalsIgnoreCase("New York"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 7. Print the full names of engineers who earn more than $80,000.
        database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Engineer") && person.getYearlyIncome() > 80000)
                .forEach(person -> System.out.println(person.getFullName()));

        // 8. Print the full names of people who are not teachers and not doctors.
        database.stream()
                .filter(person -> !person.getProfession().equalsIgnoreCase("Teacher") && !person.getProfession().equalsIgnoreCase("Doctor"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 9. Print the full names of people who live in Texas or Florida.
        database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("Texas") || person.getState().equalsIgnoreCase("Florida"))
                .forEach(person -> System.out.println(person.getFullName()));

        // 10. Print the full names of people who earn between $50,000 and $100,000.
        database.stream()
                .filter(person -> person.getYearlyIncome() >= 50000 && person.getYearlyIncome() <= 100000)
                .forEach(person -> System.out.println(person.getFullName()));

        // 11. Count how many people live in Texas.
        long texasCount = database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("Texas"))
                .count();
        System.out.println("People in Texas: " + texasCount);

        // 12. Count how many people are doctors.
        long doctorCount = database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Doctor"))
                .count();
        System.out.println("Doctors: " + doctorCount);

        // 13. Count how many people earn less than $60,000.
        long lowIncomeCount = database.stream()
                .filter(person -> person.getYearlyIncome() < 60000)
                .count();
        System.out.println("People earning < $60k: " + lowIncomeCount);

        // 14. Count how many people are not teachers.
        long notTeacherCount = database.stream()
                .filter(person -> !person.getProfession().equalsIgnoreCase("Teacher"))
                .count();
        System.out.println("People who are not teachers: " + notTeacherCount);

        // 15. Count how many people live in California and earn more than $90,000.
        long caHighEarners = database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("California") && person.getYearlyIncome() > 90000)
                .count();
        System.out.println("California earners > $90k: " + caHighEarners);

        // 16. Find the average income of all people.
        double avgIncome = database.stream()
                .mapToDouble(Person::getYearlyIncome)
                .average()
                .orElse(0);
        System.out.println("Average income: " + avgIncome);

        // 17. Find the average income of teachers.
        double avgTeacherIncome = database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Teacher"))
                .mapToDouble(Person::getYearlyIncome)
                .average()
                .orElse(0);
        System.out.println("Average teacher income: " + avgTeacherIncome);

        // 18. Find the average income of people who live in New York.
        double avgNyIncome = database.stream()
                .filter(person -> person.getState().equalsIgnoreCase("New York"))
                .mapToDouble(Person::getYearlyIncome)
                .average()
                .orElse(0);
        System.out.println("Average NY income: " + avgNyIncome);

        // 19. Find the highest income in the list.
        double maxIncome = database.stream()
                .mapToDouble(Person::getYearlyIncome)
                .max()
                .orElse(0);
        System.out.println("Highest income: " + maxIncome);

        // 20. Find the highest income of anyone who is a doctor.
        double maxDoctorIncome = database.stream()
                .filter(person -> person.getProfession().equalsIgnoreCase("Doctor"))
                .mapToDouble(Person::getYearlyIncome)
                .max()
                .orElse(0);
        System.out.println("Highest doctor income: " + maxDoctorIncome);
    }
}