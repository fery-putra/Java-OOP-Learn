package com.learn.oop;

/**
 * --- CONCEPT: ABSTRACTION & ENCAPSULATION ---
 *
 * ABSTRACTION: This class is 'abstract', meaning you cannot create a generic "Animal" object.
 * It serves as a blueprint for specific types of animals (like Lion or Bird).
 * It defines what an animal "is" and "does" without specifying all the details yet.
 *
 * ENCAPSULATION: We hide the internal state (fields) of the object and only allow
 * access through public methods (getters/setters). This protects the data from
 * being set to invalid values.
 */
public abstract class Animal {
    // These fields are 'private', so they can't be accessed directly from outside this class.
    // This is a key part of Encapsulation.
    private String name;
    private int hungerLevel;

    /**
     * CONSTRUCTOR: Used to initialize a new Animal object.
     * @param name The name given to the animal.
     */
    public Animal(String name) {
        this.name = name;
        this.hungerLevel = 50; // Every animal starts with a default hunger level.
    }

    // --- ENCAPSULATION: GETTERS AND SETTERS ---
    // These methods provide controlled access to the private fields.

    public String getName() {
        return name;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    /**
     * Setter for hungerLevel.
     * Notice how we can add logic here to ensure the hunger level stays between 0 and 100.
     * This "validation" is a major benefit of Encapsulation.
     */
    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = Math.max(0, Math.min(100, hungerLevel));
    }

    /**
     * --- CONCEPT: POLYMORPHISM (Abstract Method) ---
     *
     * This method is 'abstract', so it has no body here.
     * It forces every subclass (Lion, Bird, etc.) to provide its own version of makeSound().
     * This is how we ensure that every animal has a sound, even if they are all different.
     */
    public abstract String makeSound();

    /**
     * --- CONCEPT: INHERITANCE (Base Method) ---
     *
     * This is a regular method that all subclasses will inherit.
     * Unless they "override" it, they will all use this exact logic.
     */
    public void eat() {
        this.hungerLevel -= 10;
        if (this.hungerLevel < 0) this.hungerLevel = 0;
    }

    /**
     * --- CONCEPT: METHOD OVERLOADING ---
     *
     * Notice we have TWO methods named 'eat', but they have different parameters.
     * - eat()
     * - eat(String food)
     * Java knows which one to call based on the arguments you provide.
     * This provides flexibility in how behaviors are triggered.
     */
    public void eat(String food) {
        // Specialized food fills the animal more!
        this.hungerLevel -= 20;
        if (this.hungerLevel < 0) this.hungerLevel = 0;
    }

    /**
     * Overriding toString() is a common practice in Java.
     * It allows us to define how the object should be represented as text.
     */
    @Override
    public String toString() {
        return name + " (" + this.getClass().getSimpleName() + ")";
    }
}
