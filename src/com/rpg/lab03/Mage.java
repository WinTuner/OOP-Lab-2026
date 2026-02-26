package com.rpg.lab03;

public class Mage extends Character {
    private int mana;

    public Mage(String name, int level, int maxHealth, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Mage");
        this.mana = mana;
    }

    @Override
    public void attack(Character target) {
        int magicDamage = getDamage() + (getLevel() * 3);

        System.out.println(getName() + " (Mage) casts Magic Missile!");
        System.out.println("Raw Attack Damage: " + magicDamage);

        target.receiveDamage(magicDamage);
    }
}
