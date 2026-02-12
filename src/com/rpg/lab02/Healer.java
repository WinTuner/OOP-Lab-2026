package com.rpg.lab02;

public class Healer extends Character {
    private int baseHealing;

    public Healer(String name, int level, int maxHealth, int damage, int defense, Weapon weapon, int baseHealing) {
        super(name, level, maxHealth, damage, defense, weapon, "Healer");
        this.baseHealing = baseHealing;
    }

    public int getHealingPower() {
        return baseHealing + (getLevel() * 3);
    }

    public void heal() {
        int healAmount = getHealingPower();
        System.out.println(getName() + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount +
                " (Base: " + baseHealing + " + Level Bonus: " + (getLevel() * 3) + ")");
    }

    public void healAlly(Character ally) {
        int healAmount = getHealingPower();
        System.out.println(getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Healing Amount: " + healAmount);
        System.out.println("Restored " + healAmount + " HP to " + ally.getName() + "! Their HP: " + ally.getMaxHealth());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Healing Power: " + getHealingPower());
    }
}
