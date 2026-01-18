package com.euromoon.model.person;
import java.time.LocalDate;

/**
 * Represents a passenger who can purchase tickets for train journeys.
 */





public class Passenger extends Person {
    public Passenger(String firstName, String lastName, String nationalRegisterNumber, LocalDate birthDate){
        super(firstName,lastName,nationalRegisterNumber,birthDate);
    }
    @Override
    public String toString(){
        return "Passenger: " + super.toString();
    }

}

/**
 * Constructor for Passenger
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param nationalRegisterNumber the national register number
 * @param birthDate the birth date
 */