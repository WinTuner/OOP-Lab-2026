package com.library.lab03;
import java.util.ArrayList;
import java.util.List;
public class LibraryManagementApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" LIBRARY MANAGEMENT SYSTEM - POLYMORPHISM DEMO");
        System.out.println("=".repeat(60));
// Create a list of LibraryItem (demonstrates polymorphism)
        List<PhysicalBook> physicalBooks = new ArrayList<>();
        List<EBook> eBooks = new ArrayList<>();
// Add Physical Books
        physicalBooks.add(new PhysicalBook("Java Programming", "John Smith", "978-0134685991",
                450.0, "A1-04"));
        physicalBooks.add(new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0,
                "B2-15"));
        physicalBooks.add(new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612",
                680.0, "A3-22"));
// Add E-Books
        eBooks.add(new EBook("Effective Java", "Joshua Bloch", "978-0134685991",
                "https://library.ebooks.com/effective-java.pdf", 5.2));
        eBooks.add(new EBook("Python Crash Course", "Eric Matthes", "978-1593279288",
                "https://library.ebooks.com/python-crash.pdf", 8.7));
// Instantiate member object
        Member member1 = new Member("M001", "Somsak");
        Member member2 = new Member("M002", "Suda");
// Display all items using polymorphism
        System.out.println("\n--- ALL LIBRARY ITEMS (Polymorphism Demo) ---");
        System.out.println("Calling displayDetails() on each item in the list:");
        System.out.println();
        for (PhysicalBook item : physicalBooks) {
            item.displayDetails();
        }
        for (EBook item : eBooks) {
            item.displayDetails();
        }
// Demonstrate checkOut() method
        System.out.println("\n--- TESTING CHECKOUT FUNCTIONALITY ---");
        System.out.println("\nMember Somsak borrows Physical Book:");
        physicalBooks.get(0).checkOut(member1);
        System.out.println("\nMember Suda borrows E-Book:");
        eBooks.get(1).checkOut(member2);
        System.out.println("\nAttempting to checkout an already borrowed item:");
        physicalBooks.get(0).checkOut(member2);
// Display items after checkout using polymorphism
        System.out.println("\n--- ITEMS STATUS AFTER CHECKOUT ---");
        for (PhysicalBook item : physicalBooks) {
            item.printSummary();
        }
// Demonstrate returnItem() method
        System.out.println("\n--- TESTING RETURN FUNCTIONALITY ---");
        System.out.println("\nReturning Physical Book:");
        physicalBooks.get(0).returnItem();
// Test borrowing limit
        System.out.println("\n--- TESTING BORROW LIMIT ---");
        physicalBooks.get(0).checkOut(member1);
        physicalBooks.get(1).checkOut(member1);
        physicalBooks.get(2).checkOut(member1);
        eBooks.get(1).checkOut(member1); // Should be denied (limit reached)
// Final display using polymorphism
        System.out.println("\n--- FINAL LIBRARY STATUS (Polymorphism Demo) ---");
        for (PhysicalBook item : physicalBooks) {
            item.displayDetails();
        }
        for (EBook item : eBooks) {
            item.displayDetails();
        }
// ==================== METHOD OVERRIDING: Late Fee Demo ====================
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" METHOD OVERRIDING: LATE FEE CALCULATION DEMO");
        System.out.println("=".repeat(60));
// Simulate late returnsล
        int daysLate = 5;
        System.out.println("\n--- Late Fee Calculation (" + daysLate + " days late) ---");
        System.out.println("\nPhysical Books (5 Baht per day late fee):");
        for (PhysicalBook book : physicalBooks) {
            double lateFee = book.calculateLateFee(daysLate);
            System.out.printf(" 📚 %s: %.2f Baht\n", book.getTitle(), lateFee);
        }
        System.out.println("\nE-Books (NO late fees - files auto-expire):");
        for (EBook book : eBooks) {
            double lateFee = book.calculateLateFee(daysLate);
            System.out.printf(" 💻 %s: %.2f Baht\n", book.getTitle(), lateFee);
        }
    }
}