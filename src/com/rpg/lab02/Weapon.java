package com.rpg.lab02;

public class Weapon {
    private String name;
    private String type;
    private int damage;
    private String ability;

    public Weapon(String name, String type, int damage, String ability) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.ability = ability;
    }


    public String getName() { return name; }
    public String getType() { return type; }
    public int getDamage() { return damage; }
    public String getAbility() { return ability; }


    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setAbility(String ability) { this.ability = ability; }


    @Override
    public String toString() {
        return name + " (Type: " + type +
                ", Damage: " + damage +
                ", Ability: " + ability + ")";
    }
}
