package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //polymorphism again
        Cat garfield = new Cat();
        Fish nemo = new Fish();
        Penguin tuxedo = new Penguin();
        Seal seal = new Seal();

        List<Swimable> swimmers = new ArrayList<>();

        swimmers.add(nemo);
        swimmers.add(tuxedo);
        swimmers.add(seal);
        //Cant add cat
        //swimmers.add(garfield);

        List<Playable> players = new ArrayList<>();
        players.add(garfield);
        players.add(tuxedo);
    }
}