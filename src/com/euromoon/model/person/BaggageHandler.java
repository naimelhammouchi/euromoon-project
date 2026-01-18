package com.euromoon.model.person;

import java.time.LocalDate;

public class BaggageHandler extends Employee {
    public BaggageHandler(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
    }
    @Override
    public String toString(){
        return "Baggage Handler: " + super.toString();
    }

}