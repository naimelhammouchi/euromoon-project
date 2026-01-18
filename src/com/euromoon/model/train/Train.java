package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a train consisting of a locomotive and wagons.
 * Enforces the maximum wagon limit based on the locomotive type.
 *
 * @author Student
 * @version 1.0
 */


public class Train {
    private Locomotive locomotive;
    private List<Wagon> wagons;

    /**
     * Constructor for Train
     *
     * @param locomotive the locomotive for this train
     */


    public Train(Locomotive locomotive){
        this.locomotive = locomotive;
        this.wagons = new ArrayList<>();
    }

    /**
     * Adds a wagon to the train
     *
     * @param wagon the wagon to add
     * @throws IllegalStateException if maximum wagon capacity is exceeded
     */


    public void addWagon(Wagon wagon){
        if(wagons.size() >= locomotive.getMaxWagons()){
            throw new IllegalStateException("Cannot add more wagons. Maximum capacity of " + locomotive.getMaxWagons() + " wagons reached for " + locomotive.getModel());

        }
        wagons.add(wagon);
    }

    /**
     * Calculates the total capacity for a specific ticket class
     *
     * @param ticketClass the ticket class to calculate capacity for
     * @return the total capacity for that class
     */

    public int getCapacityForClass(TicketClass ticketClass){
        int capacity = locomotive.getLocomotiveCapacity();
        for (Wagon wagon : wagons ){
            if (wagon.getTicketClass() == ticketClass){
                capacity += wagon.getCapacity();
            }
        }
        return capacity;
    }

    /**
     * Gets the total capacity of the entire train
     *
     * @return the total passenger capacity
     */


    public int getTotalCapacity(){
        return getCapacityForClass(TicketClass.FIRST_CLASS) + getCapacityForClass(TicketClass.SECOND_CLASS);
    }

    public Locomotive getLocomotive(){
        return locomotive;
    }

    public List<Wagon> getWagons(){
        return new ArrayList<>(wagons);
    }

    @Override
    public String toString(){
        return "Train: " + locomotive + " with " + wagons.size() + " wagons";
    }

}
