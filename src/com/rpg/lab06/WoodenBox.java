package com.rpg.lab06;

public class WoodenBox implements Destructible {
    private String name;
    private int maxHealth;
    private int currentHealth;
    private boolean locked;
    private String contents;

    public WoodenBox(String name, int maxHealth, boolean locked, String contents) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.locked = locked;
        this.contents = contents;
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public boolean isLocked() { return locked; }
    public String getContents() { return contents; }

    // ===== DESTRUCTIBLE IMPLEMENTATION =====
    @Override
    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth < 0) currentHealth = 0;

        System.out.println(name + " takes " + amount + " damage!");
        System.out.println(name + " HP: " + currentHealth + "/" + maxHealth);

        if (isDestroyed()) {
            System.out.println(name + " has been DESTROYED!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return currentHealth <= 0;
    }

    // ===== BOX-SPECIFIC METHODS =====
    public void breakOpen() {
        if (isDestroyed()) {
            System.out.println("Breaking open the " + name + "...");
            if (locked) {
                System.out.println("The lock broke! " + name + " breaks open!");
                System.out.println("Contents revealed: " + contents);
            } else {
                System.out.println(name + " breaks open!");
                System.out.println("Contents revealed: " + contents);
            }
        } else {
            System.out.println("Cannot break open " + name + " - it's still intact!");
        }
    }

    public void displayBoxDetails() {
        System.out.println("--- " + name.toUpperCase() + " (WOODEN BOX) ---");
        System.out.println("Status: " + (isDestroyed() ? "Destroyed" : "Intact"));
        System.out.println("Health: " + currentHealth + "/" + maxHealth);
        System.out.println("Locked: " + (locked ? "Yes" : "No"));
        System.out.println("Contains: " + contents);
    }
}

