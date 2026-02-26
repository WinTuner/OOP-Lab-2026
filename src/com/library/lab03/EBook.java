package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String url, double size) {
        super(title, author, isbn);
        this.downloadUrl = url;
        this.fileSize = size;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }
    @Override
    public void printSummary() {
        System.out.println("EBook[Title='" + title + "', FileSize='" + fileSize + " MB', Status='" +
                (isAvailable ? "Available" : "Borrowed") + "']");
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Download URL: " + downloadUrl);
        System.out.println("- File Size: " + fileSize + " MB");
        System.out.println("- Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("- Return Due Date: " + (dueDate == null ? "N/A (E-book is available)" : dueDate));
        System.out.println();
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0;
    }
}
