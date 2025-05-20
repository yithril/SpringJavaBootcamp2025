package org.example;

public class Fish extends Animal implements Swimable {
    @Override
    public void swim() {
        System.out.println("Swims against the current.");
    }
}
