package com.rpg.lab06;

/**
 * Generic decorator that adds a flat damage boost.
 */
public class DamageBoostDecorator extends AttackDecorator {
    private final int bonusDamage;

    /**
     * Initialize the damage boost decorator.
     * @param wrappedAttack The attack to wrap
     * @param bonusDamage The amount of flat bonus damage
     * @throws IllegalArgumentException if bonusDamage is negative
     */
    public DamageBoostDecorator(Attack wrappedAttack, int bonusDamage) {
        super(wrappedAttack);
        if (bonusDamage < 0) {
            throw new IllegalArgumentException("Bonus damage cannot be negative.");
        }
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();
        attacker.setDamage(originalDamage + bonusDamage);

        try {
            System.out.println(" [Decorator] Damage Boost activated: +" + bonusDamage + " damage");
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage);
        }
    }
}

