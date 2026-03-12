package com.rpg.lab06;

public class CastleGate implements Destructible {
    private String name;
    private int maxDurability;
    private int currentDurability;
    private boolean locked;
    private boolean reinforced;

    public CastleGate(String name, int maxDurability, boolean locked, boolean reinforced) {
        this.name = name;
        this.maxDurability = maxDurability;
        this.currentDurability = maxDurability;
        this.locked = locked;
        this.reinforced = reinforced;
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public int getMaxDurability() { return maxDurability; }
    public int getCurrentDurability() { return currentDurability; }
    public boolean isLocked() { return locked; }
    public boolean isReinforced() { return reinforced; }

    // ===== DESTRUCTIBLE IMPLEMENTATION =====
    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount;

        if (reinforced) {
            actualDamage = amount / 2;
            System.out.println(name + " is REINFORCED! (reduces damage from " + amount + " to " + actualDamage + ")");
        }

        currentDurability -= actualDamage;
        if (currentDurability < 0) currentDurability = 0;

        System.out.println(name + " takes " + actualDamage + " damage! (Durability: " + currentDurability + "/" + maxDurability + ")");

        if (isDestroyed()) {
            if (reinforced) {
                System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
            } else {
                System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
            }
        }
    }

    @Override
    public boolean isDestroyed() {
        return currentDurability <= 0;
    }

    public void displayGateDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Status: " + (isDestroyed() ? "BREACHED" : "INTACT"));
        System.out.println("Durability: " + currentDurability + "/" + maxDurability);
        System.out.println("Locked: " + (locked ? "Yes" : "No"));
        System.out.println("Reinforced: " + (reinforced ? "Yes" : "No"));
    }
}

