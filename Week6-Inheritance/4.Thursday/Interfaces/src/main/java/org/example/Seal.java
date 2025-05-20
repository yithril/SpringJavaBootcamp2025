package org.example;

public class Seal extends Animal implements Swimable{
    @Override
    public void swim() {
        System.out.println("Slips against the ice then falls in.");
    }
}
