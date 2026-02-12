package com.rpg.lab02;

public class Healer extends Character {
    private int baseHealing;

    public Healer(String name, int level, int maxHealth, Weapon weapon, int baseHealing) {
        super(name, level, maxHealth, weapon, "Healer");
        this.baseHealing = baseHealing;
    }


    public int getBaseHealing() { return baseHealing; }
    public void setBaseHealing(int baseHealing) { this.baseHealing = baseHealing; }

    public int getHealingPower() {
        return baseHealing + (level * 3);
    }

    public void heal() {
        int healAmount = getHealingPower();
        currentHealth += healAmount;

        System.out.println(name + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount +
                " (Base: " + baseHealing +
                " + Level Bonus: " + (level * 3) + ")");
        System.out.println("Restored " + healAmount +
                " HP! Current HP: " +
                currentHealth + "/" + (maxHealth + 80));
    }

    public void healAlly(Character ally) {
        int healAmount = getHealingPower();
        ally.setCurrentHealth(
                Math.min(ally.getMaxHealth(),
                        ally.getCurrentHealth() + healAmount)
        );

        System.out.println(name + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Healing Amount: " + healAmount);
        System.out.println("Restored " + healAmount +
                " HP to " + ally.getName() +
                "! Their HP: " + ally.getCurrentHealth());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Healing Power: " + getHealingPower());
    }
}
