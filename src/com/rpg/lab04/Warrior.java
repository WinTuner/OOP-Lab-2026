package com.rpg.lab04;

public class Warrior extends Character {
    private int strength;

    public Warrior(String name, int level, int maxHealth, int damage, int defense, int strength, Weapon weapon) {
        super(name, level, maxHealth, damage, defense, weapon, "Warrior");
        this.strength = strength;
    }

    // ===== GETTERS =====
    public int getStrength() { return strength; }

    @Override
    public void attack(Destructible target) {
        int base = getDamage() + getWeapon().getDamage() + (getLevel() * 2);
        int boosted = (int)(base * 1.5);

        System.out.println(getName() + " (Warrior) performs a POWERFUL STRIKE on Target!");
        System.out.println("Base Damage: " + base + " → Enhanced: " + boosted + " (1.5x multiplier)");

        // Handle Character-specific details
        if (target instanceof Character) {
            Character character = (Character) target;
            int armorReduction = character.getArmor();
            int afterArmor = Math.max(0, boosted - armorReduction);
            int defenseReduction = character.getDefense();
            int finalDamage = Math.max(0, afterArmor - defenseReduction);

            System.out.println(character.getName() + "'s Armor: " + character.getArmor() + " (reduces damage from " + boosted + " to " + afterArmor + ")");
            System.out.println(character.getName() + "'s Defense: " + character.getDefense() + " (reduces damage from " + afterArmor + " to " + finalDamage + ")");
            System.out.println("Actual Damage Taken: " + finalDamage);
            System.out.println(character.getName() + "'s HP: " + (character.getCurrentHealth() - finalDamage) + "/" + character.getMaxHealth());
        }

        target.takeDamage(boosted);
    }

}
