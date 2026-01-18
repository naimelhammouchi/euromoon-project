package com.euromoon.model.person;

import java.time.LocalDate;

public class Conductor extends Employee {
    public Conductor(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
    }
    @Override
    public String toString(){
        return "Conductor: " + super.toString();
    }

}