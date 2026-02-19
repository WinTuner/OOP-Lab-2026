package com.rpg.lab03;

public class Character {
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    protected String characterClass;

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

    // ===== GETTERS =====
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public Weapon getWeapon() { return weapon; }
    public String getCharacterClass() { return characterClass; }

    // ===== SETTERS =====
    public void setCurrentHealth(int hp) {
        currentHealth = Math.min(hp, maxHealth);
    }

    // ===== GAME LOGIC =====
    public boolean isAlive() {
        return currentHealth > 0;
    }

    // POLYMORPHISM METHOD
    public void attack(com.rpg.lab03.Character target) {
        int rawDamage = damage + weapon.getDamage() + (level * 2);
        System.out.println(name + " (" + characterClass + ") attacks " + target.getName() +
                " with " + weapon.getName() + "!");
        System.out.println("Raw Attack Damage: " + rawDamage);
        target.receiveDamage(rawDamage);
    }

    // METHOD OVERRIDING TARGET
    public void receiveDamage(int rawDamage) {
        int actualDamage = Math.max(0, rawDamage - defense);
        System.out.println(name + "'s Defense: " + defense);
        System.out.println("Actual Damage Taken: " + actualDamage);

        currentHealth -= actualDamage;
        if (currentHealth < 0) currentHealth = 0;

        System.out.println(name + "'s HP: " + currentHealth + "/" + maxHealth);
    }

    // legacy
    public void takeDamage(int rawDamage) {
        receiveDamage(rawDamage);
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
