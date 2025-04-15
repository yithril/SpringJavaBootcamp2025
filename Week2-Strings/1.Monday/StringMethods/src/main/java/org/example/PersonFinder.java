package org.example;

public class PersonFinder {
    public static void main(String[] args) {
        //instantiate a Person

        Person newUser = new Person(40, 6.1f, 185.5f, "Bob Jones");

        Person anotherUser = new Person(28, 6.3f, 207f, "Chris Beck");

        //print out newUser's age
        System.out.println(newUser.getAge());

        //Bob Jones gets older
        newUser.setAge(42);

        System.out.println(newUser.getAge());
    }
}
