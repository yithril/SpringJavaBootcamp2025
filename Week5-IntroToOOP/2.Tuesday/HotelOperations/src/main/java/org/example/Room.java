package org.example;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    //isAvailable the derived getter
    public boolean isAvailable(){
        if(isOccupied == false && isDirty == false){
            return true;
        }
        else{
            return false;
        }
    }
}
