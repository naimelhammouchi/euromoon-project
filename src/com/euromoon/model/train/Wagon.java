package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;

/**
 * Represents a train wagon with a specific class and capacity.
 *
 * @author Student
 * @version 1.0
 */


public class Wagon {
    private TicketClass ticketClass;
    private int capacity;

    /**
     * Constructor for Wagon
     *
     * @param ticketClass the class of this wagon
     * @param capacity the passenger capacity of this wagon
     */


    public Wagon(TicketClass ticketClass, int capacity){
        this.ticketClass = ticketClass;
        this.capacity = capacity;
    }
    public TicketClass getTicketClass(){
        return ticketClass;
    }
    public int getCapacity(){
        return capacity;
    }
    @Override
    public String toString(){
        return ticketClass + " wagon (capacity: " + capacity + ")";
    }

}

