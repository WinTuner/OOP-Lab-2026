package com.rpg.lab06;

/**
 * Concrete base component that performs a regular attack.
 * This represents the core attack logic without any decorations.
 */
public class BaseAttack implements Attack {
    /**
     * Perform a basic attack with raw damage calculation.
     * @param attacker The character performing the attack
     * @param target The target being attacked
     */
    @Override
    public void attack(Character attacker, Destructible target) {
        if (!attacker.isAlive()) {
            System.out.println(attacker.getName() + " cannot attack because they have fainted.");
            return;
        }

        int totalDamage = attacker.getDamage() + attacker.getWeapon().getDamage();
        System.out.println("⚔️ Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }
}

