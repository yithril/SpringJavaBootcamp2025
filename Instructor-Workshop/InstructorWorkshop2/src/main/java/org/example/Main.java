package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[20];

        books[0] = new Book(1, "978-0345339683", "Dune", false, "");
        books[1] = new Book(2, "978-0441013593", "Neuromancer", true, "Alice");
        books[2] = new Book(3, "978-0553283686", "Ender's Game", false, "");
        books[3] = new Book(4, "978-0345391803", "The Hitchhiker's Guide to the Galaxy", true, "Bob");
        books[4] = new Book(5, "978-0345413352", "Foundation", false, "");
        books[5] = new Book(6, "978-0441569595", "Snow Crash", true, "Clara");
        books[6] = new Book(7, "978-0441172719", "Hyperion", false, "");
        books[7] = new Book(8, "978-0345464262", "Old Man's War", true, "David");
        books[8] = new Book(9, "978-0765311788", "The Left Hand of Darkness", false, "");
        books[9] = new Book(10, "978-0312875848", "Altered Carbon", true, "Elena");
        books[10] = new Book(11, "978-0441017225", "Spin", false, "");
        books[11] = new Book(12, "978-0345382931", "Ringworld", true, "Frank");
        books[12] = new Book(13, "978-0812550702", "Starship Troopers", false, "");
        books[13] = new Book(14, "978-0765319647", "Blindsight", true, "Grace");
        books[14] = new Book(15, "978-0345339683", "Dune Messiah", false, "");
        books[15] = new Book(16, "978-0553573428", "The Reality Dysfunction", true, "Hank");
        books[16] = new Book(17, "978-0441007462", "A Fire Upon the Deep", false, "");
        books[17] = new Book(18, "978-0441009251", "The Mote in God's Eye", true, "Irene");
        books[18] = new Book(19, "978-0553380958", "Red Mars", false, "");
        books[19] = new Book(20, "978-0441478126", "Childhood's End", true, "Jake");

        Scanner scanner = new Scanner(System.in);

        while(true){
            displayMenu();
            try{
                int userInput = Integer.parseInt(scanner.nextLine());
                switch(userInput){
                    case 1:
                        displayBooks(false, books);
                        break;
                    case 2:
                        displayBooks(true, books);
                        break;
                    case 3:
                        System.out.println("Please type in the title of the book you are searching for:");
                        String title = scanner.nextLine();
                        searchForBookByTitle(title, books);
                        break;
                    case 4:
                        System.out.println("Please type the id of the book you'd like to check out:");
                        int bookId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Please give me your name:");
                        String name = scanner.nextLine();

                        checkOutBook(bookId, name, books);
                        break;
                    case 5:
                        System.out.println("Please type in the id of the book you'd like to check in:");
                        int checkInBookId = Integer.parseInt(scanner.nextLine());
                        checkBookIn(checkInBookId, books);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("That's not an option bro, try again.");
                        break;
                }
            }
            catch(Exception ex){
                System.out.println("For real, put in a number, I told you what to do.");
            }
        }
    }

    public static void displayMenu(){
        System.out.println("""
                Welcome to my library!
                1) Show Available Books
                2) Show Currently Checked Out Books
                3) Search For Book By Title
                4) Check Out a Book
                5) Check In a Book
                6) Exit Program
                Please select your desired option:
                """);
    }

    public static void displayBooks(boolean isCheckedOut, Book[] books){
        for(int i = 0; i < books.length; i++){
            Book currentBook = books[i];

            if(currentBook.isCheckedOut() == isCheckedOut){
                System.out.println(currentBook.toString());
            }
        }
    }

    public static void searchForBookByTitle(String title, Book[] books){
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.println(book.toString());
            }
        }
    }

    public static void checkOutBook(int id, String name, Book[] books){
        Book book = findBookById(id, books);

        //null means I didn't find it
        if(book == null){
            System.out.println("No book by that id!");
        }
        else{
            if(book.isCheckedOut()){
                System.out.println("Sorry that book is checked out to someone else.");
            }
            else{
                System.out.println("Congrats you've checked out " + book.getTitle());
                book.checkOut(name);
            }
        }
    }

    public static void checkBookIn(int id, Book[] books){
        Book book = findBookById(id, books);

        if(book == null){
            System.out.println("Sorry we don't have that title.");
        }
        else{
            if(!book.isCheckedOut()){
                System.out.println("The book must be already checked out if you want to check it in.");
            }
            else{
                System.out.println("Thank you for checking in: " + book.getTitle());
                book.checkIn();
            }
        }
    }

    public static Book findBookById(int id, Book[] books){
        for(Book currentBook : books){
            if(currentBook.getId() == id){
                return currentBook;
            }
        }

        return null;
    }
}