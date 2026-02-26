package com.library.lab04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private List<LibraryItem> borrowedItems;

    public static final int MAX_BORROW_LIMIT = 3;

    public Member(String id, String name) {
        this.memberId = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedItems.size() < MAX_BORROW_LIMIT;
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);

    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);

    }
}