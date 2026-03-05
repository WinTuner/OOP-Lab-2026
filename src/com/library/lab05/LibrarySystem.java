package com.library.lab05;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON PATTERN - LibrarySystem
 *
 * Ensures there is only ONE instance of LibrarySystem throughout the application.
 *
 * Benefits of Singleton Pattern:
 * - Centralized control of library operations
 * - Shared state across the entire application
 * - Guarantees only one database connection
 * - Easy to manage library resources
 *
 * How it works:
 * - Private constructor prevents instantiation from outside
 * - Static instance variable holds the single instance
 * - getInstance() method returns the singleton instance
 * - Thread-safe implementation (eager initialization)
 */
public class LibrarySystem {
    // Singleton instance
    private static final LibrarySystem INSTANCE = new LibrarySystem();

    // Library data
    private List<LibraryItem> items;
    private List<Member> members;

    // Private constructor - prevents instantiation from outside
    private LibrarySystem() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static LibrarySystem getInstance() {
        return INSTANCE;
    }

    // Add item to library
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("✅ Added item: " + item.getTitle());
    }

    // Add member to library
    public void addMember(Member member) {
        members.add(member);
        System.out.println("✅ Added member: " + member.getName() + " (" + member.getMemberId() + ")");
    }

    // Find member by ID
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    // Get all items
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(items);
    }

    // Get all members
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    // Display library statistics
    public void displayStatistics() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" LIBRARY SYSTEM STATISTICS");
        System.out.println("=".repeat(70));
        System.out.println("\n📚 Total Items in Library: " + items.size());
        System.out.println("👥 Total Members: " + members.size());

        int borrowedItems = 0;
        int availableItems = 0;

        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                availableItems++;
            } else {
                borrowedItems++;
            }
        }

        System.out.println("📖 Available Items: " + availableItems);
        System.out.println("🔒 Borrowed Items: " + borrowedItems);
        System.out.println();
    }
}

