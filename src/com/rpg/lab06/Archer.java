package com.rpg.lab06;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int maxHealth, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
        // Apply ArcherStyleDecorator to the base attack
        this.attack = new ArcherStyleDecorator(this.attack);
    }

    // ===== GETTERS =====
    public int getAccuracy() { return accuracy; }

    public boolean hasRangeAdvantage() {
        return true; // Archers always have range advantage
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("--- " + getName().toUpperCase() + " (" + getCharacterClass().toUpperCase() + ") ---");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + getLevel());
        System.out.println("Health Points: " + getCurrentHealth() + "/" + getMaxHealth());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + getWeapon().getDetails());
    }
}


