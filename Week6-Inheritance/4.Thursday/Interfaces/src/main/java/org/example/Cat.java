package org.example;

public class Cat extends Animal implements Playable{
    @Override
    public void play() {
        System.out.println("Chases the laser pointer.");
    }
}
