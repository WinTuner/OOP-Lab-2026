package com.rpg.lab06;

/**
 * Generic decorator that restores HP after an attack (life steal effect).
 */
public class LifeStealDecorator extends AttackDecorator {
    private final double ratio;

    /**
     * Initialize the life steal decorator.
     * @param wrappedAttack The attack to wrap
     * @param ratio The ratio of damage to restore as HP (0.0 to 1.0)
     * @throws IllegalArgumentException if ratio is outside valid range
     */
    public LifeStealDecorator(Attack wrappedAttack, double ratio) {
        super(wrappedAttack);
        if (ratio < 0 || ratio > 1) {
            throw new IllegalArgumentException("Life steal ratio must be between 0 and 1.");
        }
        this.ratio = ratio;
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int hpBefore = attacker.getHealthPoints();
        wrappedAttack.attack(attacker, target);

        if (!attacker.isAlive()) {
            return;
        }

        int healBase = attacker.getDamage() + attacker.getWeapon().getBaseDamage();
        int healAmount = Math.max(1, (int) Math.round(healBase * ratio));
        int missing = attacker.getMaxHealthPoints() - attacker.getHealthPoints();

        if (missing <= 0) {
            return;
        }

        int restored = Math.min(healAmount, missing);
        attacker.setHealthPoints(attacker.getHealthPoints() + restored);

        System.out.println(" [Decorator] Life Steal restored " + restored + " HP to " + attacker.getName()
            + " (" + hpBefore + " -> " + attacker.getHealthPoints() + ")");
    }
}

