package com.rpg.lab06;

/**
 * Decorator for archer precision and range advantage behavior.
 * Applies accuracy checks and range bonuses.
 */
public class ArcherStyleDecorator extends AttackDecorator {
    /**
     * Initialize the archer style decorator.
     * @param wrappedAttack The attack to wrap
     */
    public ArcherStyleDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        if (!(attacker instanceof Archer)) {
            wrappedAttack.attack(attacker, target);
            return;
        }

        Archer archer = (Archer) attacker;
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";

        boolean hitSuccessful = (Math.random() * 100) < archer.getAccuracy();

        if (!hitSuccessful) {
            System.out.println("\n🏹 " + archer.getName() + " (Archer) shoots at " + targetName + "...");
            System.out.println(" MISS! The arrow flies wide! (Accuracy: " + archer.getAccuracy() + "%)");
            return;
        }

        int originalDamage = archer.getDamage();
        int bonusDamage = archer.hasRangeAdvantage() ? (int) Math.round(originalDamage * 0.3) : 0;
        int enhancedDamage = originalDamage + bonusDamage;

        archer.setDamage(enhancedDamage);

        System.out.println("\n🏹 " + archer.getName() + " (Archer) shoots a precise arrow at " + targetName + "!");
        System.out.println(" Base Damage: " + originalDamage + " + Range Bonus: " + bonusDamage + " = " + enhancedDamage);
        System.out.println(" Accuracy: " + archer.getAccuracy() + "% (HIT!)");

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            archer.setDamage(originalDamage);
        }
    }
}

