package com.euromoon.model.travel;

/**
 * Represents a train station.
 */

public class Station {
    private String name;
    private String city;

    /**
     * Constructor for Station
     *
     * @param name the name of the station
     * @param city the city where the station is located
     */


    public Station(String name, String city){
        this.name = name;
        this.city = city;
    }
    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }

    @Override
    public String toString(){
        return name + " (" + city + ")";
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass() ) return false;
        Station station = (Station) obj;
        return name.equals(station.name);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }

}

