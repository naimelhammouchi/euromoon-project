package com.euromoon.model.person;

import java.time.LocalDate;

/**
 * Represents a steward who assists passengers during the journey.
 */


public class Steward extends Employee {
    public Steward(String firstName, String lastName, String nationalRegisterNumber, LocalDate birthDate){
        super(firstName,lastName,nationalRegisterNumber,birthDate);
    }
    @Override
    public String toString(){
        return "Steward: " + super.toString();
    }

}

/**
 * Constructor for Steward
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param nationalRegisterNumber the national register number
 * @param birthDate the birth date
 */
