package org.example;

public class Main {
    public static void main(String[] args) {
        boolean dormammuHasHadEnough = false;
        int dormammusAnger = 0;

        while(dormammuHasHadEnough == false){
            //this is the code that will repeat over and over
            System.out.println("Dr. Strange: Dormammu I've come to bargain");
            System.out.println("Dormammu: You've come to die");
            System.out.println("Dr. Strange dies in unique horrible ways.");
            dormammusAnger += 1;

            if(dormammusAnger > 10){
                System.out.println("Dr. Strange saves the world");
                break;
            }
        }

        int counter = 20;

        while(counter > 0){
            System.out.println("Counter: " + counter);
            counter--;
        }

        //for loops are a set number of times
        //first part is where you start. We start at 0
        for(int i = 0; i < 6; i++){
            System.out.println("The current value of i is: " + i);
        }

        //count backwards
        for(int i = 6; i > 0; i--){
            System.out.println("Counting backwards with i: " + i);
        }
    }
}