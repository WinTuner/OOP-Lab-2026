package com.rpg.lab04;

import java.util.Random;

public class Archer extends Character {
    private int accuracy;
    private Random rand = new Random();

    public Archer(String name, int level, int maxHealth, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    // ===== GETTERS =====
    public int getAccuracy() { return accuracy; }

    @Override
    public void attack(Destructible target) {
        int chance = rand.nextInt(100);
        int damage = getDamage() + getWeapon().getDamage() + (getLevel() * 2);
        int rangeBonus = (damage * 30) / 100;
        int totalDamage = damage + rangeBonus;

        System.out.println(getName() + " (Archer) shoots a precise arrow at Target!");
        System.out.println("Base Damage: " + damage + " + Range Bonus: " + rangeBonus + " = " + totalDamage);
        System.out.println("Accuracy: " + accuracy + "% (" + (chance < accuracy ? "HIT!" : "MISS!") + ")");

        if (chance < accuracy) {
            if (target instanceof Character) {
                Character character = (Character) target;
                int afterDefense = Math.max(0, totalDamage - character.getDefense());
                System.out.println(character.getName() + "'s Defense: " + character.getDefense() + " (reduces damage)");
                System.out.println("Actual Damage Taken: " + afterDefense);
                character.takeDamage(totalDamage);
                System.out.println(character.getName() + "'s HP: " + character.getCurrentHealth() + "/" + character.getMaxHealth());
            } else {
                target.takeDamage(totalDamage);
            }
        } else {
            System.out.println(getName() + " (Archer) missed the shot!");
        }
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("--- " + getName().toUpperCase() + " (" + getCharacterClass().toUpperCase() + ") ---");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + getLevel());
        System.out.println("Health Points: " + getCurrentHealth() + "/" + getMaxHealth());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + getWeapon().getDetails());
    }
}
