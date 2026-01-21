package com.learn.oop;

/**
 * --- CONCEPT: INTERFACE ---
 *
 * An Interface defines a "contract" or a "capability".
 * It tells the world what an object CAN DO, rather than what it IS.
 *
 * Any class that 'implements' Flyable (like Bird or even a Plane) 
 * must provide its own way to 'fly()'.
 */
public interface Flyable {
    /**
     * Interface methods are 'public' and 'abstract' by default.
     * They define the signature but not the implementation.
     */
    String fly();
}
