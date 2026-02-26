package com.rpg.lab04;

public class Mage extends Character {
    private int maxMana;
    private int currentMana;

    public Mage(String name, int level, int maxHealth, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Mage");
        this.maxMana = mana;
        this.currentMana = mana;
    }

    // ===== GETTERS =====
    public int getMaxMana() { return maxMana; }
    public int getCurrentMana() { return currentMana; }

    // ===== SETTERS =====
    public void setCurrentMana(int mana) {
        currentMana = Math.min(mana, maxMana);
        if (currentMana < 0) currentMana = 0;
    }

    @Override
    public void attack(Destructible target) {
        int manaCost = 30;

        if (currentMana < manaCost) {
            System.out.println(getName() + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("Current Mana: " + currentMana + "/" + maxMana + " (Need: " + manaCost + ")");
            return;
        }

        int spellBonus = 10;
        int actualDamage = getDamage() + spellBonus + (getLevel() * 3);

        currentMana -= manaCost;

        System.out.println(getName() + " (Mage) casts MAGIC MISSILE at Target!");
        System.out.println("Spell Damage: " + actualDamage + " (Base: " + getDamage() + " + Spell Bonus: " + spellBonus + ")");
        System.out.println("Mana Used: " + manaCost + " | Remaining: " + currentMana + "/" + maxMana);

        if (target instanceof Character) {
            Character character = (Character) target;
            int afterDefense = Math.max(0, actualDamage - character.getDefense());
            System.out.println(character.getName() + "'s Defense: " + character.getDefense() + " (reduces damage from " + actualDamage + " to " + afterDefense + ")");
            System.out.println("Actual Damage Taken: " + afterDefense);
            character.takeDamage(actualDamage);
            System.out.println(character.getName() + "'s HP: " + character.getCurrentHealth() + "/" + character.getMaxHealth());
        } else {
            target.takeDamage(actualDamage);
        }
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
