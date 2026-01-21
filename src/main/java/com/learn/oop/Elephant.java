package com.learn.oop;

/**
 * --- CONCEPT: INHERITANCE ---
 *
 * The Elephant class 'extends' Animal. It inherits properties like 
 * name and hungerLevel from the Animal class.
 */
public class Elephant extends Animal {

    /**
     * CONSTRUCTOR:
     * We use 'super(name)' to pass the name up to the Animal class constructor.
     */
    public Elephant(String name) {
        super(name);
    }

    /**
     * --- CONCEPT: POLYMORPHISM (Method Overriding) ---
     *
     * Every animal makes a different sound. The Elephant "trumpets".
     */
    @Override
    public String makeSound() {
        return "Trumpet!";
    }

    /**
     * By overriding 'eat', we can customize the behavior for elephants.
     * Here, we call 'super.eat()' to keep the basic hunger logic, 
     * but we could also add elephant-specific logic here.
     */
    @Override
    public void eat() {
        // Reuse the logic from the base Animal class.
        super.eat();
    }
}
