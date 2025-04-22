package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please pick a story to read:");
            System.out.println(("1) Goldilocks"));
            System.out.println(("2) Mary Had a Little Lamb"));
            System.out.println("3) Hansel and Gretel");
            System.out.println("4) Quit the program");

            try{
                int userInput = scanner.nextInt();

                switch(userInput){
                    //each story has a slightly different filePath
                    case 1:
                        readStory("src/main/resources/goldilocks.txt");
                        break;
                    case 2:
                        readStory("src/main/resources/hansel_and_gretel.txt");
                        break;
                    case 3:
                        readStory("src/main/resources/mary_had_a_little_lamb.txt");
                        break;
                    case 4:
                        System.out.println("See ya!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("That's not a choice");
                        break;
                }
            }
            catch(Exception ex){
                System.out.println();
            }
        }


    }

    public static void readStory(String filePath){
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //now we are going to actually read the file
            String input;
            //keep reading line by line until there are no more lines
            while((input = bufferedReader.readLine()) != null){
                System.out.println(input);
            }

            bufferedReader.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}