package com.euromoon.model.person;

import java.time.LocalDate;

/**
 * Represents baggage personnel who handle luggage.
 */


public class BaggageHandler extends Employee {
    public BaggageHandler(String firstName, String lastName, String nationalRegisterNumber, LocalDate birthDate){
        super(firstName,lastName,nationalRegisterNumber,birthDate);
    }
    @Override
    public String toString(){
        return "Baggage Handler: " + super.toString();
    }

}

/**
 * Constructor for BaggageHandler
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param nationalRegisterNumber the national register number
 * @param birthDate the birth date
 */
