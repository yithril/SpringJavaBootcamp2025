package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Author author = new Author(1945, "Isaac Asimov", "Russian",
                false, 10000);

        Publisher publisher = new Publisher("Penguin House", "New York",
                1900, true, 100000);

        Book book = new Book("Last Question", 20, author, publisher);

        Person person = new Person("Bob", 50, 200, 5.11f);

        person.selfIntroduction();
    }
}