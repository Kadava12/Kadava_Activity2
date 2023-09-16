/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kadava_activity2;

import java.util.LinkedList;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;
    private String yearPublished;

    public Book(String isbn, String title, String author, String yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Year Published: " + yearPublished;
    }
}

public class Kadava_Activity2 {
private static LinkedList<Book> bookList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    storeBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Book Management System Menu:");
        System.out.println("1. Store a Book");
        System.out.println("2. Search for a Book");
        System.out.println("3. Display all Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void storeBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year Published: ");
        String yearPublished = scanner.nextLine();

        Book newBook = new Book(isbn, title, author, yearPublished);
        bookList.add(newBook);
        System.out.println("Book stored successfully.");
    }

    private static void searchBook() {
        System.out.print("Enter ISBN to search for a book: ");
        String isbn = scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Book information: " + book.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    private static void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books are currently stored.");
        } else {
            System.out.println("List of Books:");
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
        }
    }
    
}
