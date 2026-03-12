package com.rpg.lab06;

/**
 * Abstract decorator that wraps another Attack component.
 * Provides a base for all concrete decorators.
 */
public abstract class AttackDecorator implements Attack {
    /**
     * The wrapped attack component.
     */
    protected final Attack wrappedAttack;

    /**
     * Initialize the decorator with a wrapped attack.
     * @param wrappedAttack The attack to wrap
     * @throws IllegalArgumentException if wrappedAttack is null
     */
    protected AttackDecorator(Attack wrappedAttack) {
        if (wrappedAttack == null) {
            throw new IllegalArgumentException("Wrapped attack cannot be null.");
        }
        this.wrappedAttack = wrappedAttack;
    }
}

