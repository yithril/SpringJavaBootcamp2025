package org.example;

public class Performer {
    private String name;

    public Performer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void perform(){
        System.out.println(name + " performs a skit.");
    }
}
