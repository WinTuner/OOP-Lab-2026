package com.library.lab01;

import java.time.LocalDate;

public class Book {

        private String title;
        private String author;
        private String isbn;
        private double price;
        private String status; // Available / Borrowed
        private LocalDate returnDueDate;

        public Book(String title, String author, String isbn, double price, String status) {
                this.title = title;
                this.author = author;
                this.isbn = isbn;
                this.price = price;
                this.status = status;
                this.returnDueDate = null;
        }

        public void checkOut() {
                if (status.equals("Available")) {
                        status = "Borrowed";
                        returnDueDate = LocalDate.now().plusDays(7);
                        System.out.println("Book '" + title + "' has been checked out successfully.");
                        System.out.println("Return Due Date: " + returnDueDate);
                } else {
                        System.out.println(
                                "Error: Book '" + title + "' is already borrowed and cannot be checked out again."
                        );
                }
        }

        public void returnBook() {
                if (status.equals("Borrowed")) {
                        status = "Available";
                        returnDueDate = null;
                        System.out.println("Book '" + title + "' has been returned successfully.");
                }
        }

        public void displayDetails() {
                System.out.println("- Title: " + title);
                System.out.println("- Author: " + author);
                System.out.println("- ISBN: " + isbn);
                System.out.println("- Price: " + price + " Baht");
                System.out.println("- Status: " + status);

                if (status.equals("Borrowed")) {
                        System.out.println("- Return Due Date: " + returnDueDate);
                } else {
                        System.out.println("- Return Due Date: N/A (Book is available)");
                }
        }
}
