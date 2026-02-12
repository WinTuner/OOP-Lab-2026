package com.rpg.lab02;

public class RPGGameApp {
    public static void main(String[] args) {

        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SCENARIO 2: RPG GAME CHARACTER - DEMONSTRATION");
        System.out.println("=".repeat(70));

        // ==================== CREATE WEAPONS ====================
        System.out.println("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Sword", "Melee", 25, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff", "Magic", 20, "Spell Cast");
        Weapon staffHealer = new Weapon("Healing Staff", "Magic", 15, "Healing");

        // ==================== CREATE CHARACTERS ====================
        System.out.println("\n[STEP 2] Creating Characters...");
        Character warrior = new Character("Arthur", 10, 1500, swordWeapon, "Warrior");
        Character mage = new Character("Merlin", 12, 800, staffWeapon, "Mage");
        Healer healer = new Healer("Elara", 9, 1000, staffHealer, 30);

        // ==================== DISPLAY INITIAL STATUS ====================
        System.out.println("\n[STEP 3] Initial Character Status:");
        warrior.displayCharacterDetails();
        mage.displayCharacterDetails();
        healer.displayCharacterDetails();

        // ==================== TEST ATTACK METHOD ====================
        System.out.println("\n[STEP 4] Testing attack() Method:");
        System.out.println("\n--- Warrior's Turn ---");
        int warriorDamage = warrior.attack();

        System.out.println("\n--- Mage's Turn ---");
        int mageDamage = mage.attack();

        // ==================== SIMULATE COMBAT ====================
        System.out.println("\n[STEP 5] Simulating Combat Scenario:");
        System.out.println("\n--- Mage takes damage from Warrior ---");
        mage.takeDamage(warriorDamage);

        System.out.println("\n--- Warrior takes damage from Mage ---");
        warrior.takeDamage(mageDamage);

        // ==================== TEST LEVEL UP ====================
        System.out.println("\n[STEP 6] Testing levelUp() Method:");
        System.out.println("\n--- Arthur levels up! ---");
        warrior.levelUp();

        System.out.println("\n--- Merlin levels up! ---");
        mage.levelUp();

        // ==================== TEST HEALER ABILITIES ====================
        System.out.println("\n[STEP 7] Testing Healer Special Abilities:");
        System.out.println("\n--- Healer heals themselves ---");
        healer.displayCharacterDetails();
        healer.heal();

        System.out.println("\n--- Healer heals the Warrior ---");
        healer.healAlly(warrior);
    }
}
