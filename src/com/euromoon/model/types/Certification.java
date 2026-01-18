package com.euromoon.model.types;

public enum Certification {
    SAFETY("Veiligheid"),
    DRIVER_LICENSE_B1("Rijbewijs B1 (personenvervoer)"),
    DRIVER_LICENCE_A3("Rijbewijs A3 (onderhousspoorwagens"),
    TOURISM("Toerisme"),
    FIRST_AID("Eerste Hulp"),
    BAGGAGE_HANDLING("Bagagebehandeling");

    private final String description;

    Certification(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return description;
    }
}
