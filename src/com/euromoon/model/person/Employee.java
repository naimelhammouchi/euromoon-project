package com.euromoon.model.person;
import com.euromoon.model.types.Certification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all employee types.
 * Employees have certifications required for their roles.
 */



public class Employee extends Person {
    private List<Certification> certifications;

    public Employee(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
        this.certifications = new ArrayList<>();
    }
    /**
     * Adds a certification to this employee
     *
     * @param certification the certification to add
     */


    public void addCertification(Certification certification){
        if(!certifications.contains(certification)){
            certifications.add(certification);
        }
    }

    /**
     * Checks if employee has a specific certification
     *
     * @param certification the certification to check
     * @return true if employee has the certification
     */

    public boolean hasCertification(Certification certification){
        return certifications.contains(certification);
    }
    public List<Certification> getCertifications(){
        return new ArrayList<>(certifications);
    }

    @Override
    public String toString(){
        return super.toString() + " - Certifications: " + certifications;
    }

}

/**
 * Constructor for Employee
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param nationalRegisterNumber the national register number
 * @param birthDate the birth date
 */

