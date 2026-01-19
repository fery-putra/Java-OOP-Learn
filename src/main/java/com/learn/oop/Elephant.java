package com.learn.oop;

/**
 * Inheritance: Elephant inherits from Animal.
 */
public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    /**
     * Polymorphism: Specific implementation of makeSound for Elephant.
     */
    @Override
    public String makeSound() {
        return "Trumpet!";
    }

    /**
     * Polymorphism (Overriding): Elephant overrides eat to show custom behavior,
     * but still uses the base class behavior via 'super.eat()'.
     */
    @Override
    public void eat() {
        super.eat();
        // Additional behavior could be added here
    }
}
