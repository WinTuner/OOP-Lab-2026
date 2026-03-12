package com.rpg.lab06;

public class Mage extends Character {
    private int maxMana;
    private int currentMana;

    public Mage(String name, int level, int maxHealth, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Mage");
        this.maxMana = mana;
        this.currentMana = mana;
        // Apply MageStyleDecorator to the base attack
        this.attack = new MageStyleDecorator(this.attack);
    }

    // ===== GETTERS =====
    public int getMaxMana() { return maxMana; }
    public int getCurrentMana() { return currentMana; }
    public int getMana() { return currentMana; }

    // ===== SETTERS =====
    public void setCurrentMana(int mana) {
        currentMana = Math.min(mana, maxMana);
        if (currentMana < 0) currentMana = 0;
    }

    public void setMana(int mana) {
        setCurrentMana(mana);
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("--- " + getName().toUpperCase() + " (" + getCharacterClass().toUpperCase() + ") ---");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + getLevel());
        System.out.println("Health Points: " + getCurrentHealth() + "/" + getMaxHealth());
        System.out.println("Mana: " + currentMana + "/" + maxMana);
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Weapon: " + getWeapon().getDetails());
    }
}
