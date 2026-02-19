package com.library.lab03;

import java.time.LocalDate;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean isAvailable;
    protected Member borrower;
    protected LocalDate dueDate;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrower = null;
        this.dueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public abstract void displayDetails();


    public abstract double calculateLateFee(int days);

    public void checkOut(Member member) {
        if (!isAvailable) {
            System.out.println("Error: Item '" + title + "' is already borrowed and cannot be checked out again.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Member " + member.getName() + " has reached the borrow limit (3).");
            System.out.println("Borrow request denied for member " + member.getName() + ".");
            return;
        }

        this.isAvailable = false;
        this.borrower = member;
        this.dueDate = LocalDate.now().plusDays(7);
        member.borrowItem(this);

        System.out.println("Item '" + title + "' has been checked out successfully.");
        System.out.println("Item '" + title + "' has been borrowed by " + member.getName() + ".");
        System.out.println("Return Due Date: " + dueDate);
    }

    public void returnItem() {
        if (isAvailable) {
            System.out.println("Item is already available.");
            return;
        }

        isAvailable = true;
        borrower.returnItem(this);
        borrower = null;
        dueDate = null;
        System.out.println("Item '" + title + "' has been returned successfully.");
    }

    public void printSummary() {
        System.out.println("LibraryItem[Title='" + title + "', Status='" + (isAvailable ? "Available" : "Borrowed") + "']");
    }
}

