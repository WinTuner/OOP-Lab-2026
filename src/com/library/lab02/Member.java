package com.library.lab02;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private static final int MAX_BORROW = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_BORROW;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }
}
