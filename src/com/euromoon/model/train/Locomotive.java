package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;

public class Locomotive {
    private String model;
    private int maxWagons;
    private static final int CAPACITY_PER_LOCOMOTIVE = 80;

    public Locomotive(String model, int maxWagons){
        this.model = model;
        this.maxWagons = maxWagons;
    }
    public static Locomotive createClass373(){
        return new Locomotive("Class 373", 12);
    }
    public static Locomotive createClass374(){
        return new Locomotive("Class 374", 14);
    }
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
