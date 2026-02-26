package com.rpg.lab03;

import java.util.Random;

public class Archer extends Character {
    private int accuracy;
    private Random rand = new Random();

    public Archer(String name, int level, int maxHealth, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Character target) {
        int chance = rand.nextInt(100);

        if (chance < accuracy) {
            int dmg = getDamage() + getWeapon().getDamage();
            System.out.println(getName() + " (Archer) hits a precise arrow!");
            target.takeDamage(dmg);
        } else {
            System.out.println(getName() + " (Archer) missed the shot!");
        }
    }
}
