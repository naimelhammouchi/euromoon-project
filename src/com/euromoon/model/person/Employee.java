package com.euromoon.model.person;
/*package com.euromoon.model.types.Certification; */

import com.euromoon.model.types.Certification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {
    private List<Certification> certifications;

    public Employee(String firstName, String lastName, String nationRegisterNumber, LocalDate birthDay){
        super(firstName,lastName,nationRegisterNumber,birthDay);
        this.certifications = new ArrayList<>();
    }
    public void addCertification(Certification certification){
        if(!certifications.contains(certification)){
            certifications.add(certification);
        }
    }
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