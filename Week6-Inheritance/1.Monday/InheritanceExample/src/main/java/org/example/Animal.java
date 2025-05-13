package org.example;

public class Animal {
    private String name;
    private boolean isDomesticated;

    public Animal(String name, boolean isDomesticated) {
        this.name = name;
        this.isDomesticated = isDomesticated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomesticated() {
        return isDomesticated;
    }

    public void setDomesticated(boolean domesticated) {
        isDomesticated = domesticated;
    }
}
