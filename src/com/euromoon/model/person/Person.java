package com.euromoon.model.person;
import java.time.LocalDate;

/**
 * Abstract base class representing any person in the Euromoon system
 * Contains common attributes for all people including passengers and employees
 */


public abstract class Person {
    private String firstName;
    private String lastName;
    private String nationalRegisterNumber;
    private LocalDate birthDate;

    /**
     * Constructor for Person
     *
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     * @param nationalRegisterNumber the national register number
     * @param birthDate the birthdate of the person
     *
     */

    public Person(String firstName, String lastName, String nationalRegisterNumber, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalRegisterNumber = nationalRegisterNumber;
        this.birthDate = birthDate;

    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getNationalRegisterNumber(){
        return nationalRegisterNumber;
    }
    public void setNationalRegisterNumber(String nationalRegisterNumber){
        this.nationalRegisterNumber = nationalRegisterNumber;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " (" + nationalRegisterNumber + ")";
    }





}
