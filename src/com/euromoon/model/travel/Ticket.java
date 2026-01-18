package com.euromoon.model.travel;
import com.euromoon.model.types.TicketClass;
import com.euromoon.model.person.Passenger;



public class Ticket {
    private Passenger passenger;
    private Journey journey;
    private TicketClass ticketClass;

    public Ticket(Passenger passenger, Journey journey, TicketClass ticketClass){
        this.passenger = passenger;
        this.journey = journey;
        this.ticketClass = ticketClass;
    }
    public Passenger getPassenger(){
        return passenger;
    }

    public Journey getJourney() {
        return journey;
    }
    public TicketClass getTicketClass(){
        return ticketClass;
    }

    @Override
    public String toString(){
        return "Ticket for " + passenger + " - " + journey + "( " + ticketClass + ")";
    }
}
