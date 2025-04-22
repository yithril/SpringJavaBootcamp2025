package org.example;

public class CsvReader {
    public static void main(String[] args) {
        String test = "Jonathan|Hop|8675309|123 Somewhere Street";

        //The two slashes are because we're using a pipe
        //if it were a comma or a letter or a space, you won't need them
        String[] splitTest = test.split("\\|");

        System.out.println(splitTest[3]);
    }
}
