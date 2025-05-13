package org.example;

public class Main {
    public static void main(String[] args) {
        Dog fido = new Dog("Fido", true, "German Shepherd", false);


        fido.setDomesticated(true);

        System.out.println(fido.getName());
    }
}