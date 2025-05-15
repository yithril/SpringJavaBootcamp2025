package org.example;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        //call the constructor for the parent class
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue(){
        //4 different conditions, square footage, and the lot size
        //Based on condition, I multiple a different number by square footage
        //Then take the lot size, multiply it by .25 and then add those two numbers together
        int ratePerSquareFoot = 0;

        if(condition == 1){
            ratePerSquareFoot = 180;
        }
        else if(condition == 2){
            ratePerSquareFoot = 130;
        }
        else if(condition == 3){
            ratePerSquareFoot = 90;
        }
        else{
            ratePerSquareFoot = 80;
        }

        return (ratePerSquareFoot * squareFoot) + (.25 * lotSize);
    }
}
