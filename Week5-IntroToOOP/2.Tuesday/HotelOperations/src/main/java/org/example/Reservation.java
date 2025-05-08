package org.example;

public class Reservation {
    private String roomType;  // "king" or "double"
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        double basePrice = 0;
        if (roomType.equalsIgnoreCase("king")) {
            basePrice = 139.0;
        } else  {
            basePrice = 124.0;
        }

        if (isWeekend) {
            basePrice *= 1.10;  // increase by 10%
        }

        return basePrice;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
