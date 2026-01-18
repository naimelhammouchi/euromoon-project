package com.euromoon.model.person;
import java.time.LocalDate;

public class Passenger extends Person {
    public Passenger(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
    }
    @Override
    public String toString(){
        return "Passenger: " + super.toString();
    }

}
