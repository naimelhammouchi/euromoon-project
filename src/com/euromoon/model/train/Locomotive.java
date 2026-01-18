package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;

/**
 * Represents a locomotive with a specific model and maximum wagon capacity.
 */




public class Locomotive {
    private String model;
    private int maxWagons;
    private static final int CAPACITY_PER_LOCOMOTIVE = 80;

    /**
     * Constructor for Locomotive
     *
     * @param model the locomotive model name
     * @param maxWagons the maximum number of wagons this locomotive can pull
     */

    public Locomotive(String model, int maxWagons){
        this.model = model;
        this.maxWagons = maxWagons;
    }
    /**
     * Creates a Class 373 locomotive
     *
     * @return a Class 373 locomotive with max 12 wagons
     */

    public static Locomotive createClass373(){
        return new Locomotive("Class 373", 12);
    }

    /**
     * Creates a Class 374 locomotive
     *
     * @return a Class 374 locomotive with max 14 wagons
     */

    public static Locomotive createClass374(){
        return new Locomotive("Class 374", 14);
    }

    /**
     * Gets the capacity of the locomotive itself
     *
     * @return the passenger capacity
     */


    public int getLocomotiveCapacity(){
        return CAPACITY_PER_LOCOMOTIVE;
    }
    public String getModel(){
        return model;
    }
    public int getMaxWagons(){
        return maxWagons;
    }

    @Override
    public String toString(){
        return model + " (max " + maxWagons + " wagons)";
    }
}
