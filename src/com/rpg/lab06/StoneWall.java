package com.rpg.lab06;

public class StoneWall implements Destructible {
    private String name;
    private int maxDurability;
    private int currentDurability;
    private String wallType;

    public StoneWall(String name, int maxDurability, String wallType) {
        this.name = name;
        this.maxDurability = maxDurability;
        this.currentDurability = maxDurability;
        this.wallType = wallType;
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public String getLocation() { return name; }
    public int getMaxDurability() { return maxDurability; }
    public int getCurrentDurability() { return currentDurability; }
    public String getWallType() { return wallType; }

    // ===== DESTRUCTIBLE IMPLEMENTATION =====
    @Override
    public void takeDamage(int amount) {
        currentDurability -= amount;
        if (currentDurability < 0) currentDurability = 0;

        System.out.println(name + " takes " + amount + " damage! (Durability: " + currentDurability + "/" + maxDurability + ")");

        if (isDestroyed()) {
            System.out.println(name + " has CRUMBLED to pieces!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return currentDurability <= 0;
    }

    public void displayWallDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Type: " + wallType);
        System.out.println("Status: " + (isDestroyed() ? "DESTROYED" : "STANDING"));
        System.out.println("Durability: " + currentDurability + "/" + maxDurability);
    }
}

