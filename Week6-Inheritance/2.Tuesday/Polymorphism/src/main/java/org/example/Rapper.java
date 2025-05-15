package org.example;

public class Rapper extends Performer{
    public Rapper(String name) {
        super(name);
    }

    @Override
    public void perform(){
        System.out.println("Raps and raps again.");
    }


}
