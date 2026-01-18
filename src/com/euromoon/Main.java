package com.euromoon;
import com.euromoon.model.types.*;
import com.euromoon.model.person.*;
import com.euromoon.model.train.*;
import com.euromoon.model.travel.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Journey> journeys = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args){
        initializeSampleData();

        boolean running = true;

        while (running){
            displayMenu();

            try{
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1:
                        registerPassenger();
                        break;

                    case 2:
                        createJourney();
                        break;

                    case 3:
                        assignTrainToJourney();
                        break;

                    case 4:
                        sellTicket();
                        break;

                    case 5:
                        printBoardingList();
                        break;


                    case 6:
                        running = false;
                        System.out.println("Bedankt voor het gebruiken van Euromoon!");
                        break;

                    default:
                        System.out.println("Ongeldige keuze.Probeer opnieuw.");
                }
            } catch (NumberFormatException e){
                System.out.println("Voer een geldig nummer in.");
            } catch (Exception e) {
                System.out.println("Er is een fout opgetreden: " + e.getMessage());
            }

            System.out.println();

        }

        scanner.close();
    }


    private static void displayMenu(){
        System.out.println("=== EUROMOON TRAIN BOOKING SYSTEEM ===");
        System.out.println("1. Registreer passagier");
        System.out.println("2. Registreer passagier");
        System.out.println("3. Registreer passagier");
        System.out.println("4. Registreer passagier");
        System.out.println("5. Registreer passagier");
        System.out.println("6. Registreer passagier");
        System.out.println("\nKies een optie: ");

    }

    private static void registerPassenger(){
        System.out.println("\n--- Registreer Passagier ---");

        System.out.println("Voornaam: ");
        String firstName = scanner.nextLine();

        System.out.println("Achternaam: ");
        String lastName = scanner.nextLine();

        System.out.println("Rijkregisternummer: ");
        String nationalRegisterNumber = scanner.nextLine();

        System.out.println("Geboortedatum (yyyy-MM-dd): ");
        String birthDateStr = scanner.nextLine();

        try{
            LocalDate birthDate = LocalDate.parse(birthDateStr);
            Passenger passenger = new Passenger(firstName,lastName,nationalRegisterNumber,birthDate);
            passengers.add(passenger);
            System.out.println("Passagier succesvol geregistreerd: " + passenger);
        } catch (DateTimeParseException e){
            System.out.println("Ongeldige datum formaat. Gebruik yyyy-MM-dd");
        }

    }

    private static void createJourney(){
        System.out.println("\n--- Aanmaken Reis ---");

        System.out.print("Vertrekstation naam: ");
        String depName = scanner.nextLine();
        System.out.print("Vertrekstation stad: ");
        String depCity = scanner.nextLine();

        System.out.println("Aankomststation naam: ");
        String arrName = scanner.nextLine();
        System.out.println("Aankomststation stad: ");
        String arrCity = scanner.nextLine();

        System.out.println("Vertrektijd (yyyy-MM-dd HH:mm): ");
        String timeStr = scanner.nextLine();

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime departureTime = LocalDateTime.parse(timeStr, formatter);

            Station departure = new Station(depName,depCity);
            Station arrival = new Station(arrName,arrCity);

            Journey journey = new Journey(departure,arrival,departureTime);

            assignStaffToJourney(journey);

            journeys.add(journey);
            System.out.println("Reis succesvol aangemaakt: " + journey);

            if (!journey.hasRequiredStaff()){
                System.out.println("WAARSCHUWING: Reis heeft niet het minimum vereiste personeel!");
            }

        } catch (DateTimeParseException e){
            System.out.println("Ongeldige datum/tijd formaat. Gebruik yyyy-MM-dd HH:mm");
        }
    }

    private static void assignStaffToJourney(Journey journey){
        System.out.println("\nPersoneel toewijzen aan reis: ");
        System.out.println("Beschikbaar personeel:");

        for (int i = 0; i < employees.size(); i++){
            System.out.println((i+1) + " " + employees.get(i));
        }

        System.out.print("\nVoer personeelsnummer in (gescheiden door komma's): ");
        String input = scanner.nextLine();

        if(!input.trim().isEmpty()){
            String[] indices = input.split(",");
            for (String indexStr : indices){
                try{
                    int index = Integer.parseInt(indexStr.trim()) - 1;
                    if (index >= 0 && index < employees.size()){
                        journey.addStaff(employees.get(index));
                    }
                }catch (NumberFormatException e){
                    System.out.println("Ongeldige invoer genegeerd: " + indexStr);
                }
            }
        }
    }


    private static void assignTrainToJourney(){
        if (journeys.isEmpty()){
            System.out.println("\nGeen reizen beschikbaar. Maak eerst een reis aan.");
            return;
        }
        System.out.println("\n--- Trein Koppelen aan een Reis ---");
        System.out.println("Beschikbare reizen:");

        for (int i = 0; i < journeys.size(); i++){
            System.out.println((i+1) + ". " + journeys.get(i));
        }
        System.out.print("\nKies een reis (nummer): ");
        try{
            int journeyIndex = Integer.parseInt(scanner.nextLine()) -1;

            if (journeyIndex < 0 || journeyIndex >= journeys.size()){
                System.out.println("Ongeldige reis nummer.");
                return;
            }
            Journey selectedJourney = journeys.get(journeyIndex);

            System.out.println("\nKies locomotief type: ");
            System.out.println("1. Class 373 (max 12 wagons)");
            System.out.println("2. Class 374 (max 14 wagons)");
            System.out.print("Keuze: ");

            int locoChoice = Integer.parseInt(scanner.nextLine());
            Locomotive locomotive;

            if (locoChoice == 1){
                locomotive = Locomotive.createClass373();
            } else if (locoChoice == 2) {
                locomotive = Locomotive.createClass374();

            } else {
                System.out.println("Ongeldige keuze.");
                return;
            }

            Train train = new Train(locomotive);

            System.out.print("\nAantal eerste klas wagons: ");
            int firstClassCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Capaciteit per eerste klas wagon: ");
            int firstClassCapacity = Integer.parseInt(scanner.nextLine());

            System.out.print("\nAantal tweede klas wagons: ");
            int secondClassCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Capaciteit per tweede klas wagon: ");
            int secondClassCapacity = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < firstClassCount; i++){
                train.addWagon(new Wagon(TicketClass.FIRST_CLASS, firstClassCapacity));
            }

            for (int i = 0; i < secondClassCount; i++){
                train.addWagon(new Wagon(TicketClass.SECOND_CLASS, secondClassCapacity));
            }

            selectedJourney.assignTrain(train);
            System.out.println("Trein succesvol gekoppeld aan reis!");
            System.out.println("Totale capaciteit: " + train.getTotalCapacity() + " passagiers");




        }catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer.");
        }catch (IllegalStateException e){
            System.out.println("Fout: " + e.getMessage());
        }

    }

    private static void sellTicket(){
        if (passengers.isEmpty()){
            System.out.println("\nGeen passagiers geregistreerd. Registreer eerst een passagier");
            return;
        }
        if (journeys.isEmpty()){
            System.out.println("\nGeen reizen beschikbaar. Maak eerst een reis aan.");
            return;
        }

        System.out.println("\n--- Ticket Verkopen ---");
        System.out.println("Geregistreerde passagiers:");

        for (int i=0; i < passengers.size(); i++){
            System.out.println((i + 1 ) + ". " + passengers.get(i));
        }
        System.out.print("\nKies een passagier (nummer): ");
        int passengerIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (passengerIndex < 0 || passengerIndex >= passengers.size()){
            System.out.println("Ongeldige passagier nummer.");
            return;
        }

        Passenger selectedPassenger = passengers.get(passengerIndex);

        System.out.println("\nBeschikbare reizen:");
        for (int i = 0; i < journeys.size(); i++){
            Journey j = journeys.get(i);
            System.out.println((i+1) + ". " + j +
               " [1e klas: " + j.getSoldTicketsCount(TicketClass.FIRST_CLASS) + "/" +
                    (j.getTrain() != null ? j.getTrain().getCapacityForClass(TicketClass.FIRST_CLASS) : "N/A") +
                    ", 2e klas: " + j.getSoldTicketsCount(TicketClass.SECOND_CLASS) +
                    (j.getTrain() != null ? j.getTrain().getCapacityForClass(TicketClass.SECOND_CLASS) : "N/A") + "]");

        }
        System.out.print("\nKies een reis (nummer): ");
        int journeyIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (journeyIndex < 0 || journeyIndex >= journeys.size()){
            System.out.println("Ongeldige reis nummer.");
            return;

        }

        Journey selectedJourney = journeys.get(journeyIndex);

        if (selectedJourney.getTrain() == null){
            System.out.println("Geen trein gekoppeld aan deze reis. Koppel eerst een trein.");
            return;

        }
        System.out.println("\nKies ticket klasse");
        System.out.println("1. Eerste klas");
        System.out.println("2. Tweede klas");
        System.out.print("Keuze: ");

        int classChoice = Integer.parseInt(scanner.nextLine());
        TicketClass ticketClass;

        if(classChoice == 1){
            ticketClass = TicketClass.FIRST_CLASS;
        } else if (classChoice == 2) {
            ticketClass = TicketClass.SECOND_CLASS;

        } else{
            System.out.println("Ongeldige keuze.");
            return;

        }

        if (!selectedJourney.canSellTicket(ticketClass)){
            System.out.println("Geen capaciteit meer beschikbaar voor " + ticketClass);
            return;
        }

        selectedJourney.sellTickets(ticketClass);
        Ticket ticket = new Ticket(selectedPassenger,selectedJourney,ticketClass);
        tickets.add(ticket);

        System.out.println("Ticket succesvol verkocht!");
        System.out.println(ticket);

    }

    private static void printBoardingList() throws IOException {
        if (journeys.isEmpty()){
            System.out.println("\nGeen reizen beschikbaar");
            return;
        }

        System.out.println("\n--- Afdrukken Boardinglijst ---");
        System.out.println("Beschikbaar reizen:");

        for (int i = 0; i < journeys.size(); i++ ){
            System.out.println((i+1) + ". " + journeys.get(i));

        }

        System.out.println("\nKies een reis (nummer): ");
        try {
            int journeyIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (journeyIndex < 0 || journeyIndex >= journeys.size()) {
                System.out.println("Ongeldige reis nummer.");
                return;

            }

            Journey selectedJourney = journeys.get(journeyIndex);
            String filename = selectedJourney.getBoardingListFilename();

            List<Ticket> journeyTickets = new ArrayList<>();
            for (Ticket ticket : tickets) {
                if (ticket.getJourney() == selectedJourney) {
                    journeyTickets.add(ticket);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write("BOARDING LIST - EUROMOON");
                writer.newLine();
                writer.write("=".repeat(60));
                writer.newLine();
                writer.write("Reis: "+ selectedJourney);
                writer.newLine();
                writer.write("Datum: " + selectedJourney.getDepartureTime().format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm")));
                writer.newLine();
                writer.write("=".repeat(60));
                writer.newLine();
                writer.newLine();

                if (journeyTickets.isEmpty()){
                    writer.write("Geen passagiers geboekt voor deze reis.");

                } else{
                    writer.write("EERSTE KLAS: ");
                    writer.newLine();
                    writer.write("=".repeat(60));
                    writer.newLine();

                    boolean hasFirstClass = false;
                    for (Ticket ticket : journeyTickets){
                        if (ticket.getTicketClass() == TicketClass.FIRST_CLASS){
                            Passenger p = ticket.getPassenger();
                            writer.write(String.format("%-25s %-20s %s",
                                    p.getFirstName() + " " +p.getLastName(),
                                    p.getNationalRegisterNumber(),
                                    p.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            writer.newLine();
                            hasFirstClass = true;


                        }
                    }

                    if (!hasFirstClass){
                        writer.write("Geen passagiers");
                        writer.newLine();
                    }
                    writer.newLine();
                    writer.write("TWEEDE KLAS: ");
                    writer.newLine();
                    writer.write("=".repeat(60));
                    writer.newLine();

                    boolean hasSecondClass = false;
                    for (Ticket ticket : journeyTickets){
                        if (ticket.getTicketClass() == TicketClass.SECOND_CLASS){
                            Passenger p = ticket.getPassenger();
                            writer.write(String.format("%-25s %-20s %s",
                                    p.getFirstName() + " " +p.getLastName(),
                                    p.getNationalRegisterNumber(),
                                    p.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            writer.newLine();
                            hasSecondClass = true;


                        }
                    }
                    if (!hasSecondClass){
                        writer.write("Geen passagiers");
                        writer.newLine();
                    }

                    writer.newLine();
                    writer.write("=".repeat(60));
                    writer.newLine();
                    writer.write("Totaal aantal passagiers: " + journeyTickets.size());

                }
                System.out.println("Boardinglijst succesvol opgeslagen als: " + filename);
            } catch (IOException e){
                System.out.println("Fout bij het schrijven van het bestand: " + e.getMessage());
            }
        } catch (NumberFormatException e){
            System.out.println("Ongeldige invoer.");

        }

    }

    private static void initializeSampleData(){
        Conductor conductor1 = new Conductor("Jan", "De Verdachte", "85.01.01-001.23",
                LocalDate.of(1985, 1, 1));
        conductor1.addCertification(Certification.DRIVER_LICENSE_B1);
        conductor1.addCertification(Certification.SAFETY);

        Steward steward1 = new Steward("Marie", "Janssen", "90.05.15-002.45",
                LocalDate.of(1990, 5, 15));
        steward1.addCertification(Certification.SAFETY);
        steward1.addCertification(Certification.TOURISM);

        Steward steward2 = new Steward("Verdachte", "Peeters", "88.11.20-003.67",
                LocalDate.of(1988, 11, 20));
        steward2.addCertification(Certification.FIRST_AID);

        Steward steward3 = new Steward("Sophie", "Verdachtigheid", "92.03.08-004.89",
                LocalDate.of(1992, 3, 8));
        steward3.addCertification(Certification.SAFETY);

        BaggageHandler baggage1 = new BaggageHandler("Tom", "Suspicious", "87.07.12-005.12",
                LocalDate.of(1987, 7, 12));
        baggage1.addCertification(Certification.BAGGAGE_HANDLING);

        employees.add(conductor1);
        employees.add(steward1);
        employees.add(steward2);
        employees.add(steward3);
        employees.add(baggage1);
    }


}
