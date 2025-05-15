package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dancer dancer = new Dancer("Britney Spears");
        Juggler juggler = new Juggler("Bob");
        Singer singer = new Singer("Beyonce");
        Rapper rapper = new Rapper("Lil' Wayne");

        List<Performer> performers = new ArrayList<>();

        performers.add(dancer);
        performers.add(juggler);
        performers.add(singer);
        performers.add(rapper);

        //we'll start the talent show
        for(Performer performer : performers){
            performer.perform();

            //check to see if we're working with a juggler
            if(performer instanceof Juggler){
                ((Juggler) performer).breatheFire(); //downcasting
            }
        }

        //upcast
        Performer newPerformer = new Dancer("Mary");
    }
}