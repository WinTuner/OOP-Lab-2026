package com.rpg.lab04;

public class HealthPotion implements Consumable {
    private String name;
    private int healingPower;
    private int quantity;

    public HealthPotion(String name, int healingPower, int quantity) {
        this.name = name;
        this.healingPower = healingPower;
        this.quantity = quantity;
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public int getHealingPower() { return healingPower; }
    public int getQuantity() { return quantity; }

    // ===== CONSUMABLE IMPLEMENTATION =====
    @Override
    public void use(Character user) {
        if (quantity <= 0) {
            System.out.println(user.getName() + " tries to use " + name + " but there are none left!");
            return;
        }

        int oldHealth = user.getCurrentHealth();
        int newHealth = Math.min(oldHealth + healingPower, user.getMaxHealth());
        int actualHealing = newHealth - oldHealth;

        user.setCurrentHealth(newHealth);
        quantity--;

        System.out.println(user.getName() + " drinks " + name + "!");
        System.out.println("Health restored: " + oldHealth + " → " + newHealth + " (+" + actualHealing + ")");
        System.out.println(name + " remaining: " + quantity);
    }

    public void displayPotionDetails() {
        System.out.println("--- " + name.toUpperCase() + " ---");
        System.out.println("Healing Power: " + healingPower + " HP");
        System.out.println("Quantity: " + quantity);
        System.out.println("Type: Consumable");
    }
}

