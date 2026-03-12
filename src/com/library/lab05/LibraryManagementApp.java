package com.library.lab05;

public class LibraryManagementApp {
    public static void main(String[] args) {
        // ==================== SINGLETON PATTERN DEMO ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" DESIGN PATTERNS: SINGLETON & STRATEGY");
        System.out.println("=".repeat(70));

        // Get the single instance of LibrarySystem (Singleton Pattern)
        System.out.println("\n[STEP 1] Initializing LibrarySystem (Singleton Pattern):");
        LibrarySystem librarySystem = LibrarySystem.getInstance();

        // Try to get instance again - should return same instance
        System.out.println("Getting LibrarySystem instance again:");
        LibrarySystem sameInstance = LibrarySystem.getInstance();
        System.out.println(" ✅ Same instance? " + (librarySystem == sameInstance));

        // ==================== CREATE LIBRARY ITEMS ====================
        System.out.println("\n[STEP 2] Creating Library Items:");

        // Add Physical Books
        PhysicalBook book1 = new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04");
        PhysicalBook book2 = new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0, "B2-15");
        PhysicalBook book3 = new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22");
        PhysicalBook book4 = new PhysicalBook("The Art of War", "Sun Tzu", "978-1599869773", 250.0, "C1-10");
        PhysicalBook book5 = new PhysicalBook("Refactoring", "Martin Fowler", "978-0134757599", 550.0, "A2-08");

        librarySystem.addItem(book1);
        librarySystem.addItem(book2);
        librarySystem.addItem(book3);
        librarySystem.addItem(book4);
        librarySystem.addItem(book5);

        // Add E-Books
        EBook ebook1 = new EBook("Effective Java", "Joshua Bloch", "978-0134685991",
                "https://library.ebooks.com/effective-java.pdf", 5.2);
        EBook ebook2 = new EBook("Python Crash Course", "Eric Matthes", "978-1593279288",
                "https://library.ebooks.com/python-crash.pdf", 8.7);

        librarySystem.addItem(ebook1);
        librarySystem.addItem(ebook2);

        // ==================== STRATEGY PATTERN: CREATE MEMBERS WITH DIFFERENT STRATEGIES ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 3] STRATEGY PATTERN: Creating Members with Different Strategies");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Each member has a MembershipStrategy!");
        System.out.println(" Strategy determines: borrow limit, loan period, late fee discount\n");

        // Create members with different strategies
        Member basicMember = new Member("M001", "Somsak", new BasicMembershipStrategy());
        Member studentMember = new Member("M002", "Suda", new StudentMembershipStrategy());
        Member premiumMember = new Member("M003", "Somchai", new PremiumMembershipStrategy());
        Member familyMember = new Member("M004", "Niran", new FamilyMembershipStrategy());

        librarySystem.addMember(basicMember);
        librarySystem.addMember(studentMember);
        librarySystem.addMember(premiumMember);
        librarySystem.addMember(familyMember);

        // Display member information
        // System.out.println("--- MEMBER INFORMATION ---");
        for (Member member : librarySystem.getAllMembers()) {
            member.displayMemberInfo();
        }

        // ==================== STRATEGY PATTERN: TESTING DIFFERENT BORROW BEHAVIORS
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 4] STRATEGY PATTERN: Testing Different Borrow Behaviors");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ Each member type has different borrow limits and loan periods!\n");

        // Basic Member borrows (limit: 1, period: 14 days)
        System.out.println("--- Basic Member (Somsak) Borrows ---");
        book1.checkOut(basicMember);

        // Student Member borrows (limit: 5, period: 21 days)
        System.out.println("\n--- Student Member (Suda) Borrows ---");
        book2.checkOut(studentMember);

        // Premium Member borrows (unlimited, period: 30 days)
        System.out.println("\n--- Premium Member (Somchai) Borrows ---");
        book3.checkOut(premiumMember);
        ebook1.checkOut(premiumMember);
        ebook2.checkOut(premiumMember); // Premium can borrow unlimited!

        // ==================== NEW: FAMILY MEMBER BORROWING DEMO ====================
        System.out.println("\n--- Family Member (Niran) Borrows ---");
        System.out.println("🎯 Demonstrating FamilyMembershipStrategy:");
        System.out.println("   - Borrow Limit: 6 items");
        System.out.println("   - Loan Period: 21 days");
        System.out.println("   - Late Fee Discount: 10%\n");
        book4.checkOut(familyMember);

        // ==================== STRATEGY PATTERN: LATE FEE COMPARISON
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 5] STRATEGY PATTERN: Late Fee Discounts");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ Different membership types get different late fee discounts!\n");

        double baseFee = 100.0;
        System.out.println("Base Late Fee: " + baseFee + " Baht\n");

        System.out.println("1️⃣ Basic Member (No discount):");
        double basicFee = basicMember.calculateLateFee(baseFee);
        System.out.println(" Final: " + basicFee + " Baht\n");

        System.out.println("2️⃣ Student Member (20% discount):");
        double studentFee = studentMember.calculateLateFee(baseFee);
        System.out.println(" Final: " + studentFee + " Baht\n");

        System.out.println("3️⃣ Premium Member (100% FREE!):");
        double premiumFee = premiumMember.calculateLateFee(baseFee);
        System.out.println(" Final: " + premiumFee + " Baht\n");

        System.out.println("4️⃣ Family Member (10% discount):");
        double familyFee = familyMember.calculateLateFee(baseFee);
        System.out.println(" Final: " + familyFee + " Baht\n");

        // ==================== FAMILY MEMBER LATE FEE TEST: Base Fee 200 ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 6] FAMILY MEMBER: Late Fee Calculation (Base Fee = 200 Baht)");
        System.out.println("=".repeat(70));
        System.out.println("\n🎯 SUCCESS CRITERIA: Base fee 200 → Final fee 180 (after 10% discount)\n");

        double familyBaseFee = 200.0;
        System.out.println("Family Member Late Fee Calculation:");
        double familyLateFee = familyMember.calculateLateFee(familyBaseFee);
        System.out.println(" Expected Final Fee: 180.0 Baht");
        System.out.println(" Actual Final Fee: " + familyLateFee + " Baht");
        if (familyLateFee == 180.0) {
            System.out.println(" ✅ SUCCESS: Discount correctly applied!");
        } else {
            System.out.println(" ❌ FAILED: Discount not correctly applied!");
        }

        // ==================== STRATEGY PATTERN: RUNTIME STRATEGY CHANGE
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 7] STRATEGY PATTERN: Changing Strategy at Runtime");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Members can upgrade/downgrade membership dynamically!\n");

        // Basic member upgrades to Premium
        System.out.println("--- Somsak (MemberID:M001) Upgrades from Basic to Premium ---");
        Member somsak = librarySystem.findMemberById("M001");
        System.out.println("\nBefore Upgrade: " + somsak.getMembershipStrategy().getMembershipType());
        System.out.println("Borrow Limit: " + somsak.getMembershipStrategy().getBorrowLimit() + " items\n");

        // Somsak tries to borrow more than basic limit
        System.out.println("Attempting to borrow another item (already has 1):");
        book5.checkOut(basicMember); // Should fail (limit reached)

        // Upgrade to Premium!
        System.out.println("\n⬆️ Upgrading to Premium Membership...\n");
        somsak.setMembershipStrategy(new PremiumMembershipStrategy());
        System.out.println("After Upgrade: " + somsak.getMembershipStrategy().getMembershipType());
        System.out.println("New Borrow Limit: " + somsak.getMembershipStrategy().getBorrowLimit() + " items\n");

        // Now Somsak can borrow more items!
        System.out.println("Now borrowing with upgraded Premium membership:");
        book5.checkOut(basicMember); // Now unlimited!

        // ==================== LIBRARY SYSTEM STATISTICS ====================
        librarySystem.displayStatistics();
    }
}