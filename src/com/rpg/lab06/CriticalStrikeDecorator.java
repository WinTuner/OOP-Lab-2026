package com.rpg.lab06;

/**
 * Generic decorator that applies critical-strike chance.
 * 25% chance to double damage on an attack.
 */
public class CriticalStrikeDecorator extends AttackDecorator {
    /**
     * Initialize the critical strike decorator.
     * @param wrappedAttack The attack to wrap
     */
    public CriticalStrikeDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();
        boolean critical = (Math.random() * 100) < 25;

        if (critical) {
            attacker.setDamage(originalDamage * 2);
            String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
            System.out.println("\n💥 " + attacker.getName() + " lands a CRITICAL STRIKE on " + targetName + "!");
            System.out.println(" Base Damage: " + originalDamage + " -> Critical: " + attacker.getDamage() + " (2x)");
        }

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage);
        }
    }
}

