package com.teachapp.people;

public class Professor extends Employee{
    private static int professorCounter = 0;
    private final int professorID;

    // CONSTRUCTOR
    public Professor(String name, Contract contract, double salary) {
        super(name);
        this.salary = salary;
        this.contract = contract;

        professorCounter++;
        this.professorID = professorCounter;
    }

    public String toString() {
        return getProfessorID() + " | " + getName() + " | " + getContract().getPaymentScheme();
    }

    public int getProfessorID() { return professorID; }}
