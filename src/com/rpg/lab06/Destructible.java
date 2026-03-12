package com.rpg.lab06;

public interface Destructible {
    /**
     * Apply damage to this destructible object
     * @param amount The amount of damage to take
     */
    void takeDamage(int amount);

    /**
     * Check if this object is destroyed
     * @return true if destroyed, false otherwise
     */
    boolean isDestroyed();
}

