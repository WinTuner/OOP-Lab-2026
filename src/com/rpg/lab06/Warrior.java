package com.rpg.lab06;

public class Warrior extends Character {
    private int strength;

    public Warrior(String name, int level, int maxHealth, int damage, int defense, int strength, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Warrior");
        this.strength = strength;
        // Apply WarriorStyleDecorator to the base attack
        this.attack = new WarriorStyleDecorator(this.attack);
    }

    // ===== GETTERS =====
    public int getStrength() { return strength; }
}

