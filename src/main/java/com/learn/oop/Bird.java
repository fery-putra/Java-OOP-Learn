package com.learn.oop;

/**
 * --- CONCEPT: MULTIPLE HIERARCHIES (Inheritance + Interface) ---
 *
 * The Bird class 'extends' Animal (Inheritance) AND 'implements' Flyable (Interface).
 * This means a Bird "IS AN" Animal and it "CAN" Fly.
 */
public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name);
    }

    /**
     * --- CONCEPT: POLYMORPHISM ---
     * Providing the specific sound for a Bird.
     */
    @Override
    public String makeSound() {
        return "Chirp!";
    }

    /**
     * --- CONCEPT: INTERFACE IMPLEMENTATION ---
     *
     * Because Bird implements Flyable, it MUST provide an implementation 
     * for the fly() method.
     */
    @Override
    public String fly() {
        return getName() + " is soaring through the sky!";
    }

    /**
     * Overriding the eat method from the Animal class.
     */
    @Override
    public void eat() {
        super.eat();
    }
}
