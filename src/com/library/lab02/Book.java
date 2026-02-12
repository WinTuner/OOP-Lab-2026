package com.library.lab02;

import java.time.LocalDate;

public class Book {
        private String title;
        private String author;
        private String isbn;
        private double price;
        private String status;
        private Member borrower;

        public Book(String title, String author, String isbn, double price, String status) {
                this.title = title;
                this.author = author;
                this.isbn = isbn;
                this.price = price;
                this.status = status;
        }

        public void checkOut(Member borrower) {
                if (status.equals("Borrowed")) {
                        System.out.println("Error: Book '" + title + "' is already borrowed and cannot be checked out again.");
                        return;
                }

                if (!borrower.canBorrow()) {
                        System.out.println("Member " + borrower.getName() + " has reached the borrow limit (3).");
                        System.out.println("Borrow request denied for member " + borrower.getName() + ".");
                        return;
                }

                this.status = "Borrowed";
                this.borrower = borrower;
                borrower.borrowBook(this);

                System.out.println("Book '" + title + "' has been checked out successfully.");
                System.out.println("Book " + title + " has been borrowed by " + borrower.getName() + ".");
                System.out.println("Return Due Date: " + LocalDate.now().plusDays(7));
        }

        public void returnBook() {
                if (status.equals("Available")) {
                        System.out.println("Book is already available.");
                        return;
                }

                status = "Available";
                borrower.returnBook(this);
                borrower = null;
                System.out.println("Book '" + title + "' has been returned successfully.");
        }

        public void printSummary() {
                System.out.println("Book[Title='" + title + "', Status='" + status + "']");
        }
}
