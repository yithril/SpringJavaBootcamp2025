package org.example;

//A Cat Is-A Animal
public class Cat extends Animal{
    private boolean isOutdoors;

    public Cat(String name, boolean isDomesticated, boolean isOutdoors){
        super(name, isDomesticated);
        this.isOutdoors = isOutdoors;
    }

    public boolean isOutdoors() {
        return isOutdoors;
    }

    public void setOutdoors(boolean outdoors) {
        isOutdoors = outdoors;
    }
}
