package com.rpg.lab04;

public class Weapon {
    private String name;
    private String type;
    private String ability;
    private int damage;

    public Weapon(String name, String type, int damage, String ability) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.ability = ability;
    }

    // ===== GETTERS =====
    public String getName() { return name; }
    public String getType() { return type; }
    public int getDamage() { return damage; }
    public String getAbility() { return ability; }

    // ===== SETTERS (optional but Lab OOP bonus) =====
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDetails() {
        return name + " (Type: " + type + ", Damage: " + damage + ", Ability: " + ability + ")";
    }
}
