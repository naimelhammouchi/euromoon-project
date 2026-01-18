package com.euromoon.model.person;

import java.time.LocalDate;

public class Steward extends Employee {
    public Steward(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
    }
    @Override
    public String toString(){
        return "Steward: " + super.toString();
    }

}