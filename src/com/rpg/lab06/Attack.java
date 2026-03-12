package com.rpg.lab06;

/**
 * Component interface for decorator-based attack processing.
 */
public interface Attack {
    /**
     * Execute an attack from one character against a destructible target.
     * @param attacker The character performing the attack
     * @param target The target being attacked (implements Destructible)
     */
    void attack(Character attacker, Destructible target);
}

