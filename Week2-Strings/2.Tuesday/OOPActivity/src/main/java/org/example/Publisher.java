package org.example;

public class Publisher {
    private String name;
    private String location;
    private int yearFounded;
    private boolean independent;
    private long revenue;

    public Publisher(String name, String location, int yearFounded, boolean independent, long revenue) {
        this.name = name;
        this.location = location;
        this.yearFounded = yearFounded;
        this.independent = independent;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}
