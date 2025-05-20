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

        // 2. Print the full names of all people who are teachers.

        // 3. Print the full names of people who earn more than $90,000.

        // 4. Print the full names of people who live in Florida and earn less than $60,000.

        // 5. Print the full names of doctors who live in California.

        // 6. Print the full names of people who do not live in New York.

        // 7. Print the full names of engineers who earn more than $80,000.

        // 8. Print the full names of people who are not teachers and not doctors.

        // 9. Print the full names of people who live in Texas or Florida.

        // 10. Print the full names of people who earn between $50,000 and $100,000.

        // 11. Count how many people live in Texas. (Hint: Use .count())

        // 12. Count how many people are doctors. (Hint: Use .count())

        // 13. Count how many people earn less than $60,000. (Hint: Use .count())

        // 14. Count how many people are not teachers. (Hint: Use .count())

        // 15. Count how many people live in California and earn more than $90,000. (Hint: Use .count())

        // 16. Find the average income of all people. (Hint: Use .mapToDouble(...).average())

        // 17. Find the average income of teachers.

        // 18. Find the average income of people who live in New York.

        // 19. Find the highest income in the list. (Hint: Use .mapToDouble(...).max())

        // 20. Find the highest income of anyone who is a doctor.
    }
}