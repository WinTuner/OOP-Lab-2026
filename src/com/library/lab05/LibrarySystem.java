package com.library.lab05;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    // Singleton instance
    private static LibrarySystem instance;
    // Library data
    private List<LibraryItem> allItems;
    private List<Member> allMembers;
    private String libraryName;
    private String libraryLocation;
    /**
     * Private constructor - Prevents direct instantiation
     * Only getInstance() can create the instance
     */
    private LibrarySystem() {
        this.allItems = new ArrayList<>();
        this.allMembers = new ArrayList<>();
        this.libraryName = "City Central Library";
        this.libraryLocation = "123 Main Street, Downtown";
    }
    /**
     * SINGLETON METHOD: Thread-safe getInstance()
     * Returns the single instance of LibrarySystem
     * Creates instance on first call, returns same instance on subsequent calls
     */
    public static synchronized LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
            System.out.println("📚 [Singleton] LibrarySystem initialized (First time)");
        }
        return instance;
    }
    // Getters
    public String getLibraryName() {
        return libraryName;
    }
    public String getLibraryLocation() {
        return libraryLocation;
    }
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(allItems);
    }
    public List<Member> getAllMembers() {
        return new ArrayList<>(allMembers);
    }
    // Library Operations
    public void addItem(LibraryItem item) {
        allItems.add(item);
        System.out.println(" ✅ Item added to system: " + item.getTitle());
    }
    public void addMember(Member member) {
        allMembers.add(member);
        System.out.println(" ✅ Member registered: " + member.getName());
    }
    public int getTotalItems() {
        return allItems.size();
    }
    public int getTotalMembers() {
        return allMembers.size();
    }
    public int getAvailableItemsCount() {
        return (int) allItems.stream().filter(LibraryItem::isAvailable).count();
    }
    public int getBorrowedItemsCount() {
        return (int) allItems.stream().filter(item -> !item.isAvailable()).count();
    }
    /**
     * Display library statistics
     */
    public void displayStatistics() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" 📚 LIBRARY SYSTEM STATISTICS (Singleton Instance)");
        System.out.println("=".repeat(60));
        System.out.println("\nLibrary: " + libraryName);
        System.out.println("Location: " + libraryLocation);
        System.out.println("\n📊 STATISTICS:");
        System.out.println(" Total Items: " + getTotalItems());
        System.out.println(" Available Items: " + getAvailableItemsCount());
        System.out.println(" Borrowed Items: " + getBorrowedItemsCount());
        System.out.println(" Total Members: " + getTotalMembers());
        System.out.println("\n✨ Note: This is the ONLY instance of LibrarySystem in the application!");
        System.out.println(" (Singleton Pattern ensures single centralized management)");
    }
    /**
     * Find item by title
     */
    public LibraryItem findItemByTitle(String title) {
        return allItems.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
    /**
     * Find member by ID
     */
    public Member findMemberById(String memberId) {
        return allMembers.stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
}