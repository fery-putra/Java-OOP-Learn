package com.learn.oop;

/**
 * Inheritance: Lion inherits from Animal.
 */
public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    /**
     * Polymorphism: Specific implementation of makeSound for Lion.
     */
    @Override
    public String makeSound() {
        return "Roar!";
    }

    /**
     * Polymorphism (Overriding): Lion overrides eat to show custom behavior.
     */
    @Override
    public void eat() {
        super.eat();
    }
}
