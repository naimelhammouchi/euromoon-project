package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;

public class Wagon {
    private TicketClass ticketClass;
    private int capacity;

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

