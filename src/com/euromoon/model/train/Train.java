package com.euromoon.model.train;
import com.euromoon.model.types.TicketClass;
import java.util.ArrayList;
import java.util.List;

public class Train {
    private Locomotive locomotive;
    private List<Wagon> wagons;

    public Train(Locomotive locomotive){
        this.locomotive = locomotive;
        this.wagons = new ArrayList<>();
    }
    public void addWagon(Wagon wagon){
        if(wagons.size() >= locomotive.getMaxWagons()){
            throw new IllegalStateException("Cannot add more wagons. Maximum capacity of " + locomotive.getMaxWagons() + " wagons reached for " + locomotive.getModel());

        }
        wagons.add(wagon);
    }
    public int getCapacityForClass(TicketClass ticketClass){
        int capacity = locomotive.getLocomotiveCapacity();
        for (Wagon wagon : wagons ){
            if (wagon.getTicketClass() == ticketClass){
                capacity += wagon.getCapacity();
            }
        }
        return capacity;
    }
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
