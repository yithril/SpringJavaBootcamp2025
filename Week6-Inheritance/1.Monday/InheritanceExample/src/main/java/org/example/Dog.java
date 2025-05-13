package org.example;

public class Dog extends Animal {
    private String breed;
    private boolean hypoallergenic;

    public Dog(String name, boolean isDomesticated, String breed, boolean hypoallergenic) {
        super(name, isDomesticated);
        this.breed = breed;
        this.hypoallergenic = hypoallergenic;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(boolean hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }
}
