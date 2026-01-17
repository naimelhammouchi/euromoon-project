**Euromoon - Treinreserveringssysteem**

**Projectbeschrijving**

Euromoon is een command-line java applicatie voor het beheren van treinreizen binnen Europa. Het systeem maakt het mogelijk om passagiers te registreren, reizen aan te maken, treinen te koppelen en tickets te verkopen.

**Functionaliteit**

Het systeem biedt de volgende functionaliteit:

1. **Passagier registreren**: registreer nieuwe passagiers met persoonlijke gegevens
2. **Reis aanmaken**: maak nieuwe reizen aan tussen Europese hoofdsteden
3. **Trein koppelen**: koppel een trein met locomotief en wagons aan een reis
4. **Ticket verkopen**: verkoop tickets aan passagiers met capaciteitscontrole
5. **Boardinglijst afdrukken**: genereer een tekstbestand met alle passagiers voor een reis

**Technische details**

**Projectstructuur**

com.euromoon
1. model
   1. person
      1. Person
      2. Passenger
      3. Employee
      4. Conductor
      5. Steward
      6. BaggageHandler
   2. train
      1. Locomotive
      2. Wagon
      3. Train
   3. travel
      1. Station
      2. Journey
      3. Ticket
   4. types
      1. TicketClass
      2. Certification
2. main

**Requirements**

* Java 8 of hoger

**Installatie en Uitvoering**

1. Clone deze repository:
2. git clone https://github.com/naimelhammouchi/euromoon-project
3. open het project in de IDE
4. Compileer en run de Main.java klasse
5. volg de instructies in het command-line menu

**Gebruik**
**Passagiers Registreren**

Voer de persoonlijke gegevens in van de passagier:
* Voornaam
* Achternaam
* Rijkregisternummer
* Geboortedatum (formaat: yyyy-MM-dd)

**Reis Aanmaken**

Maak een nieuwe reis aan door:
* Vertrek- en aankomststation op te geven
* Vertrektijd in te stellen (formaat: yyyy-MM-dd HH:mm)
* Personeel tie te wijzen aan de reis

**Trein Koppelen**

Koppel een trein aan een reis:
* Kies het locomotief type (Class 373 of Class 374)
* Voeg eerste klas wagons toe
* Voeg tweede klas wagons toe

Ticket Verkopen

Verkoop een ticket:
* Selecteer een passagier
* Kies een reis
* Selecteer ticket klasse (eerste of tweede klas)

het systeem controleerty automatisch of er nog capaciteit beschikbaar is.

**Boardinglijst Afdrukken**

Genereer een tekstbestand met alle passagiers voor een specifieke reis. het bestand wordt opgeslagen met de naam: [Vertrek]_[Aankomst]_[Datum].txt

**Design Keuzes**

**Inheritance Hierarchie**
* Person: Abstract superklasse voor alle personen
* Employee: Abstract klasse die overerft van Person, met certificatenbeheer
* Passenger: Concrete klasse voor passagiers
* Specifieke employee types: Conductor, Steward, BaggageHandler

**Enumeraties**
* TicketClass: FIRST_CLASS,SECOND_CLASS
* Certification: Verschillende certificatietypes voor personeel

**Validaties**
* Maximum aantal wagons gebaseerd op locomotief type
* Capaciteitscontrole bij ticket verkoop
* Minimum personeel vereist (1 conducteur + 3 stewards)

**File I/O**
* Boardinglijsten worden weggeschreven naar tekstbestanden
* Gebruik van BufferedWriter voor efficiënte file operaties

**Referenties en Bronnen**
**Gebruikte Bronnen**
**Cursusmateriaal**
* **Canvas EHB**
  * Programming advanced slides + oefeningen

* **Java documentatie**
  * Oracle Java SE Documentation
  * https://docs.oracle.com/javase/8/docs/api/

* **w3schools**
  * https://www.w3schools.com/java/

* **stackoverflow**
  * https://stackoverflow.com/questions/tagged/java



**Git en Version Control**
* Git Documentation - https://git-scm.com/docs
* GitHub Guides - https://docs.github.com/en

**Auteur**
**Student**: El hammouchi Naïm
**Klas**: graduaatopleiding - Programmeren
**Academiejaar**: 2025-2026
**Erasmus hogeschool Brussel**

**Licentie**

Dit project is gemaakt voor educatieve doeleinden als onderdeel van een eindexamen van de cursus Programming advanced