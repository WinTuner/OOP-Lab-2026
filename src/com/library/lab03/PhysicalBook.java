package com.library.lab03;

public class PhysicalBook extends LibraryItem {
    private double price;
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn);
        this.price = price;
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Price: " + price + " Baht");
        System.out.println("- Shelf Location: " + shelfLocation);
        System.out.println("- Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("- Return Due Date: " + (dueDate == null ? "N/A (Book is available)" : dueDate));
        System.out.println();
    }


    @Override
    public void printSummary() {
        System.out.println("PhysicalBook[Title='" + title + "', Location='" + shelfLocation +
                "', Status='" + (isAvailable ? "Available" : "Borrowed") + "']");
    }


    @Override
    public double calculateLateFee(int days) {
        return days * 5.0;
    }
}
