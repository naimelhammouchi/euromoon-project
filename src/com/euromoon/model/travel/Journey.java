package com.euromoon.model.travel;
import com.euromoon.model.types.TicketClass;
import com.euromoon.model.person.Conductor;
import com.euromoon.model.person.Employee;
import com.euromoon.model.person.Steward;
import com.euromoon.model.train.Train;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journey {
    private Station departureStation;
    private Station arrivalStation;
    private LocalDateTime departureTime;
    private Train train;
    private List<Employee> staff;
    private Map<TicketClass, Integer> soldTickets;

    public Journey(Station departureStation, Station arrivalStation, LocalDateTime departureTime){
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.staff = new ArrayList<>();
        this.soldTickets = new HashMap<>();
        this.soldTickets.put(TicketClass.FIRST_CLASS, 0);
        this.soldTickets.put(TicketClass.SECOND_CLASS,0);
    }

    public void assignTrain (Train train){
        this.train = train;
    }

    public void addStaff(Employee employee){
        if (!staff.contains(employee)){
            staff.add(employee);
        }
    }

    public boolean hasRequiredStaff(){
        long conductorCount = staff.stream().filter(e -> e instanceof Conductor).count();
        long stewardCount = staff.stream().filter( e -> e instanceof Steward).count();
        return conductorCount >= 1 && stewardCount >=3;

    }

    public boolean canSellTicket(TicketClass ticketClass){
        if (train == null){
            return false;
        }
        int sold = soldTickets.get(ticketClass);
        int capacity = train.getCapacityForClass(ticketClass);

        return sold < capacity;
    }

    public void sellTickets (TicketClass ticketClass){
        if (!canSellTicket(ticketClass)){
            throw new IllegalStateException("No capacity available for " + ticketClass);
        }
        soldTickets.put(ticketClass, soldTickets.get(ticketClass) +1);
    }
    public String getBoardingListFilename(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return departureStation.getName() + "_" + arrivalStation.getName() + "_" + departureTime.format(formatter) + ".txt";
    }

    public Station getDepartureStation(){
        return departureStation;
    }
    public Station getArrivalStation(){
        return arrivalStation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public Train getTrain(){
        return train;
    }
    public List<Employee> getStaff(){
        return new ArrayList<>(staff);
    }
    public int getSoldTicketsCount(TicketClass ticketClass){
        return soldTickets.get(ticketClass);
    }

    @Override
    public String toString(){
        return departureStation.getName() + "->" + arrivalStation.getName() + " (" + departureTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ")";
    }
}
