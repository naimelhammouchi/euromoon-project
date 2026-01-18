package com.euromoon.model.person;

import java.time.LocalDate;

/**
 * Represents a train conductor who drives the train.
 */


public class Conductor extends Employee {
    public Conductor(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
    }


    @Override
    public String toString(){
        return "Conductor: " + super.toString();
    }

}

/**
 * Constructor for Conductor
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param nationalRegisterNumber the national register number
 * @param birthDate the birth date
 */
