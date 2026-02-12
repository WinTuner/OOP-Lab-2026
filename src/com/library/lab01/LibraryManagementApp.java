package com.library.lab01;

public class LibraryManagementApp {

    public static void main(String[] args) {

        System.out.println("\n" + "=".repeat(60));
        System.out.println(" LIBRARY MANAGEMENT SYSTEM - DEMONSTRATION");
        System.out.println("=".repeat(60));

        Book book1 = new Book(
                "Java Programming",
                "John Smith",
                "123-456",
                450.0,
                "Available"
        );

        Book book2 = new Book(
                "OOP Concepts",
                "Will Jones",
                "999-888",
                590.0,
                "Available"
        );

        System.out.println("\n--- Initial Book Information ---");
        book1.displayDetails();
        book2.displayDetails();

        System.out.println("\n--- Testing checkOut() Method ---");
        System.out.println("\nAttempting to checkout Book 1 and Book 2 (Available):");
        book1.checkOut();
        book2.checkOut();

        System.out.println("\nAttempting to checkout Book 2 again (Already Borrowed):");
        book2.checkOut();

        System.out.println("\n--- Testing returnBook() Method ---");
        System.out.println("\nReturning Book 1:");
        book1.returnBook();

        System.out.println("\n--- Final Book Information ---");
        book1.displayDetails();
        book2.displayDetails();
    }
}
