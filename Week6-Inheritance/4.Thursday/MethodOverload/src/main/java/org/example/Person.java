package org.example;

public class Person {
    private String name;
    private int age;
    private String birthdate;

    public Person(String name, int age, String birthdate) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){

    }
}
