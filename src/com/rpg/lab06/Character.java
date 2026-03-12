package com.rpg.lab06;

public class Character implements Destructible {
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected int damage;
    protected int defense;
    protected int armor;
    protected Weapon weapon;
    protected String characterClass;
    protected Attack attack;

    public Character(String name, int level, int maxHealth, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.defense = defense;
        this.armor = defense; // Default armor equals defense
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.attack = new BaseAttack(); // Initialize with base attack behavior
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getMaxHealth() { return maxHealth; }
    public int getMaxHealthPoints() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public int getHealthPoints() { return currentHealth; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getArmor() { return armor; }
    public Weapon getWeapon() { return weapon; }
    public String getCharacterClass() { return characterClass; }
    public Attack getAttack() { return attack; }

    // ===== SETTERS =====
    public void setCurrentHealth(int hp) {
        currentHealth = Math.min(hp, maxHealth);
        if (currentHealth < 0) currentHealth = 0;
    }

    public void setHealthPoints(int hp) {
        setCurrentHealth(hp);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttack(Attack attack) {
        if (attack == null) {
            throw new IllegalArgumentException("Attack cannot be null.");
        }
        this.attack = attack;
    }

    public void setMana(int mana) {
        // Default implementation for non-mage classes - override in Mage
    }

    public int getMana() {
        // Default implementation for non-mage classes - override in Mage
        return 0;
    }


    // ===== GAME LOGIC =====
    public boolean isAlive() {
        return currentHealth > 0;
    }

    @Override
    public boolean isDestroyed() {
        return !isAlive();
    }

    // POLYMORPHISM METHOD
    public void attack(Destructible target) {
        this.attack.attack(this, target);
    }


    // METHOD OVERRIDING TARGET
    public void receiveDamage(int rawDamage) {
        this.takeDamage(rawDamage);
    }

    // DESTRUCTIBLE IMPLEMENTATION
    @Override
    public void takeDamage(int rawDamage) {
        int afterArmor = Math.max(0, rawDamage - armor);
        int actualDamage = Math.max(0, afterArmor - defense);

        currentHealth -= actualDamage;
        if (currentHealth < 0) currentHealth = 0;
    }


    public void levelUp() {
        level++;
        maxHealth += 10;
        currentHealth = maxHealth;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHealth + " (full heal applied)");
    }

    public void displayCharacterDetails() {
        System.out.println("--- " + name.toUpperCase() + " (" + characterClass.toUpperCase() + ") ---");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + currentHealth + "/" + maxHealth);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Armor Value: " + armor);
        System.out.println("Weapon: " + weapon.getDetails());
    }
}
