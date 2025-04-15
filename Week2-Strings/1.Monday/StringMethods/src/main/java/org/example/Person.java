package org.example;

public class Person {
    //properties
    //age, height, weight, name
    private int age;
    private float height;
    private float weight;
    private String name;

    //constructors
    //The constructor is the same name as the class
    public Person(int age, float height, float weight, String name){
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    //behaviors (methods)
    //getter and setter
    //getters get the value of the property, setters change the value of the property

    //getter for age
    public int getAge(){
        return this.age;
    }

    //setter for age
    public void setAge(int age){
        this.age = age;
    }

    //getter for height
    public float getHeight(){
        return this.height;
    }

    public void setHeight(float height){
        this.height = height;
    }
}
