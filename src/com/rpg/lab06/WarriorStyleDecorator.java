package com.rpg.lab06;

/**
 * Decorator for warrior-specific power strike behavior.
 * Applies a 1.5x damage multiplier.
 */
public class WarriorStyleDecorator extends AttackDecorator {
    /**
     * Initialize the warrior style decorator.
     * @param wrappedAttack The attack to wrap
     */
    public WarriorStyleDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();
        int enhancedDamage = (int) Math.round(originalDamage * 1.5);

        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        attacker.setDamage(enhancedDamage);

        System.out.println("\n⚔️ " + attacker.getName() + " (Warrior) performs a POWERFUL STRIKE on " + targetName + "!");
        System.out.println(" Base Damage: " + originalDamage + " -> Enhanced: " + enhancedDamage + " (1.5x multiplier)");

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage);
        }
    }
}

