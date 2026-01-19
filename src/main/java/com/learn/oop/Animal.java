package com.learn.oop;

/**
 * Encapsulation: The Animal class encapsulates the common properties of animals.
 * Abstraction: This class is abstract because we cannot have a generic "Animal" without a specific type.
 */
public abstract class Animal {
    private String name;
    private int hungerLevel;

    public Animal(String name) {
        this.name = name;
        this.hungerLevel = 50; // Initial hunger level
    }

    // Encapsulation: Using getters and setters to access private fields
    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = Math.max(0, Math.min(100, hungerLevel));
    }

    /**
     * Polymorphism: Different animals will make different sounds.
     */
    public abstract String makeSound();

    /**
     * Inheritance: All animals can eat, but some might have specific ways.
     */
    public void eat() {
        this.hungerLevel -= 10;
        if (this.hungerLevel < 0) this.hungerLevel = 0;
    }

    /**
     * Overloading: Same method name 'eat', but different parameters.
     * This provides multiple ways to call the same behavior.
     */
    public void eat(String food) {
        this.hungerLevel -= 20; // Specialized food fills more
        if (this.hungerLevel < 0) this.hungerLevel = 0;
    }

    @Override
    public String toString() {
        return name + " (" + this.getClass().getSimpleName() + ")";
    }
}
