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
        int boosted = (int)(base * 1.5);

        System.out.println(getName() + " (Warrior) uses Power Slash!");
        System.out.println("Raw Attack Damage: " + boosted);
        System.out.println(target.getName() + "'s Defense: " + target.getDefense() +
                " (reduces damage by " + target.getDefense() + ")");

        target.takeDamage(boosted);
    }

}
