package com.rpg.lab02;

public class Character {
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int maxHealth, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    // ================= GETTERS =================
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCurrentHealth() { return currentHealth; }
    public int getMaxHealth() { return maxHealth; }
    public int getDefense() { return defense; }

    // ================= GAME LOGIC =================

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void attack(Character target) {
        int levelBonus = level * 2;
        int rawDamage;

        if (characterClass.equals("Warrior")) {
            rawDamage = weapon.getDamage() + levelBonus;
        }
        else if (characterClass.equals("Mage")) {
            rawDamage = damage + 20;
        }
        else {
            rawDamage = damage + levelBonus;
        }

        System.out.println(name + " (" + characterClass + ") attacks "
                + target.getName() + " with " + weapon.getName() + "!");
        System.out.println("Raw Attack Damage: " + rawDamage);

        target.takeDamage(rawDamage);
    }

    public void takeDamage(int rawDamage) {
        System.out.println(name + "'s Defense: " + defense + " (reduces damage by " + defense + ")");

        int actualDamage = rawDamage - defense;
        System.out.println("Actual Damage Taken: " + actualDamage);

        currentHealth -= actualDamage;

        System.out.println(name + "'s HP: " + currentHealth + "/" + maxHealth);
    }

    public void levelUp() {
        level++;
        maxHealth += 10;
        currentHealth = maxHealth;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHealth + " (full heal applied)");
    }

    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Class: " + characterClass);
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + currentHealth + "/" + maxHealth);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Weapon: " + weapon.getDetails());
    }
}
