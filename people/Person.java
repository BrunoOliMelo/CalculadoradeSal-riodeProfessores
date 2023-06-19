package com.teachapp.people;

import com.teachapp.utilities.Input;

public abstract class Person {
    String name;

    // CONSTRUCTOR
    public Person (String name) {
        this.name = name;
    }

    public String getName() { return name.trim(); }

    public void setName() {
        String message = "Alterar nome";
        this.name = Input.inputString(message);
    }
}