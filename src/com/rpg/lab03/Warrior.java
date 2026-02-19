package com.rpg.lab03;

public class Warrior extends Character {
    private int strength;

    public Warrior(String name, int level, int maxHealth, int damage, int defense, int strength, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Warrior");
        this.strength = strength;
    }

    @Override
    public void attack(Character target) {
        int base = getDamage() + getWeapon().getDamage() + (getLevel() * 2);
        int boosted = (int)(base * 1.5); // 1.5x bonus

        System.out.println(getName() + " (Warrior) uses Power Slash!");
        target.takeDamage(boosted);
    }
}
