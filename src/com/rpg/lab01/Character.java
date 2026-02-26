package com.rpg.lab01;

public class Character {
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int currentHealth;
    protected Weapon weapon;
    protected String characterClass;

    public Character(String name, int level, int maxHealth, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }


    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public Weapon getWeapon() { return weapon; }
    public String getCharacterClass() { return characterClass; }


    public void setName(String name) { this.name = name; }
    public void setLevel(int level) { this.level = level; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }

    public int attack() {
        int levelBonus = level * 2;
        int totalDamage = weapon.getDamage() + levelBonus;

        System.out.println(name + " (" + characterClass + ") attacks with " + weapon.getName() + "!");
        System.out.println("Attack Damage: " + totalDamage +
                " (Weapon Base: " + weapon.getDamage() +
                " + Level Bonus: " + levelBonus + ")");
        return totalDamage;
    }

    public void takeDamage(int damage) {
        currentHealth = Math.max(0, currentHealth - damage);
        System.out.println(name + " takes " + damage +
                " damage! Current HP: " +
                currentHealth + "/" + maxHealth);
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
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + currentHealth + "/" + maxHealth);
        System.out.println("Weapon: " + weapon);
    }
}
