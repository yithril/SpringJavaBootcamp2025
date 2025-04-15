package org.example;

public class Person {
    private String name;
    private int age;
    private float weight;
    private float height;

    public Person(String name, int age, float weight, float height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    //custom methods come after getters and setters
    //make a method for the person to introduce themselves
    public void selfIntroduction(){
        System.out.println("Hi my name is " + this.name);
    }
}
