package org.example;

public class Penguin extends Animal implements Swimable, Playable{
    @Override
    public void swim() {
        System.out.println("Dives in to the icy depths.");
    }

    @Override
    public void play() {
        System.out.println("Waddles along playfully.");
    }
}
