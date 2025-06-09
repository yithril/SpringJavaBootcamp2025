package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main <db_url> <user> <password>");
            return;
        }

        //this is how we set up the username and password
        String dbUrl = args[0];
        String dbUser = args[1];
        String dbPass = args[2];

        TemplateDao dao = new TemplateDao(dbUrl, dbUser, dbPass);
    }
}