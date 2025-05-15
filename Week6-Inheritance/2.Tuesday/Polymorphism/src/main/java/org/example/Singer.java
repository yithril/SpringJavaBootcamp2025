package org.example;

public class Singer extends Performer{

    public Singer(String name) {
        super(name);
    }

    //annotation
    @Override
    public void perform(){
        System.out.println("Sings Diva and gets the crowd going.");
    }
}
