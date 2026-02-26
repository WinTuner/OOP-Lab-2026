package com.rpg.lab04;

public interface Consumable {
    /**
     * Use this consumable item on a character
     * @param user The character using this item
     */
    void use(Character user);
}

