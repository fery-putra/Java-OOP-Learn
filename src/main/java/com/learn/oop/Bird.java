package com.learn.oop;

/**
 * Inheritance: Bird inherits from Animal.
 */
public class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }

    /**
     * Polymorphism: Specific implementation of makeSound for Bird.
     */
    @Override
    public String makeSound() {
        return "Chirp!";
    }

    /**
     * Interface Implementation: Providing behavior defined in Flyable interface.
     */
    @Override
    public String fly() {
        return getName() + " is soaring through the sky!";
    }

    /**
     * Polymorphism (Overriding): Bird might have a different way of eating.
     */
    @Override
    public void eat() {
        super.eat();
    }
}
