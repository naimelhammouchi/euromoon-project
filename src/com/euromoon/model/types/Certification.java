package com.euromoon.model.types;


/**
 * Enumeration representing the different certifications employees can have.
 */

public enum Certification {
    SAFETY("Veiligheid"),
    DRIVER_LICENSE_B1("Rijbewijs B1 (personenvervoer)"),
    DRIVER_LICENCE_A3("Rijbewijs A3 (onderhousspoorwagens"),
    TOURISM("Toerisme"),
    FIRST_AID("Eerste Hulp"),
    BAGGAGE_HANDLING("Bagagebehandeling");

    private final String description;

    /**
     * Constructor for Certification
     *
     * @param description the description of the certification
     */

    Certification(String description){
        this.description = description;
    }


    /**
     * Gets the description of this certification
     *
     * @return the certification description
     */


    public String getDescription(){
        return description;
    }



    @Override
    public String toString(){
        return description;
    }
}

