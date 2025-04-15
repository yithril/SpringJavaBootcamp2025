package org.example;

public class Author {
    private int birthYear;
    private String name;
    private String nationality;
    private boolean alive;
    private double netWorthInMillions;

    public Author(int birthYear, String name, String nationality, boolean alive, double netWorthInMillions) {
        this.birthYear = birthYear;
        this.name = name;
        this.nationality = nationality;
        this.alive = alive;
        this.netWorthInMillions = netWorthInMillions;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getNetWorthInMillions() {
        return netWorthInMillions;
    }

    public void setNetWorthInMillions(double netWorthInMillions) {
        this.netWorthInMillions = netWorthInMillions;
    }
}
