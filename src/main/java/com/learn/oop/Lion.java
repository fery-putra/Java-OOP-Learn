package com.learn.oop;

/**
 * --- CONCEPT: INHERITANCE ---
 *
 * The Lion class 'extends' Animal. This means it inherits all the fields 
 * and methods of the Animal class (like name, hungerLevel, and eat()).
 */
public class Lion extends Animal {

    /**
     * CONSTRUCTOR:
     * We must call the 'super()' constructor to initialize the parts of 
     * the Lion that belong to the base Animal class (like the name).
     */
    public Lion(String name) {
        super(name);
    }

    /**
     * --- CONCEPT: POLYMORPHISM (Method Overriding) ---
     *
     * We provide a specific implementation for the 'makeSound()' method 
     * that was defined as abstract in the Animal class.
     */
    @Override
    public String makeSound() {
        return "Roar!";
    }

    /**
     * Here, we override the 'eat()' method to show that Lions could have 
     * unique eating habits, even though in this simple example we just 
     * call the original logic using 'super.eat()'.
     */
    @Override
    public void eat() {
        // 'super.eat()' calls the version of 'eat' defined in the Animal class.
        super.eat();
    }
}
