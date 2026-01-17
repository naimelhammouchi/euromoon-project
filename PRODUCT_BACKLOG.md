# **Product Backlog - Euromoon**
# **Treinreserveringssysteem**

Project Planning (11/01 - 18/01/2026)

* Sprint 0
  * 11/01: Planning & Setup
* Sprint 1
  * 12/01 - 13/01: Core Model Classes
* Sprint 2
  * 13/01 - 14/01: Business Logic & UI
* Sprint 3
  * Testing & Documentation

Sprint 0: Planning & Setup
Doelstellingen
* Project setup en structuur bepalen
* Planning opstellen
* Development environment configureren

User Stories

US-001: Project Initialisatie
Als developer wil ik het project opzetten met git zodat ik kan beginnen met ontwikkelen

Acceptatiecriteria
1. [ ] Javaproject aangemaakt in IntelliJ
2. [ ] Git repository geïnitialiseerd
3. [ ] Package structuur aangemaakt
4. [ ] Eerste commit GitHub

geschatte tijd: 1 uur
Prioriteit: HIGH

US-002: Class Diagram Ontwerpen
een class diagram maken zodat ik de relaties tuessen classes begrijp

Acceptatiecriteria
1. [ ] Class diagram getekend met alle entities
2. [ ] inheritance relaties
3. [ ] interfaces geïdentificeerd

geschatte tijd: 2 uur
Prioriteit: HIGH

Sprint 1: Core Model Classes

Doelstellingen
* Implemeteer alle model classes
* Basis constructors getters/setters
* enumeraties


User Stories

US-003: Person Hierarchie Implementeren
personen kunnen opslaan (passagiers & personeel) en gebruikers kunnen beheren

Acceptatiecriteria
1. [ ] Person abstract class met gemeenschappelijk velden
2. [ ] Passenger class extends Person
3. [ ] Employee abstract class extends Person met certificaten lijst
4. [ ] Conductor, Steward, BaggageHandler classes
5. [ ] JavaDoc voor alle classes

geschatte tijd: 3 uur
Prioriteit: High

US-004: Train Components Implementeren
treinen kunnen samenstellen en capaciteiten kunnen beheren

Acceptatiecriteria
1. [ ] Locomotive class met factory methods (Class 373, 374)
2. [ ] Wagon class met TicketClass en capaciteit
3. [ ] Train class met wagon lijst
4. [ ] Validatie: max wagons gebaseerd op locomotief
5. [ ] JavaDoc voor alle classes

geschatte tijd: 2 uur 
Prioriteit HIGH

US-005: Journey & Ticket implementeren
reizen en tickets beheren en reserveringen kunnen afhandelen

Acceptatiecriteria
1. [ ] Station class met naam en stad
2. [ ] Journey class met stations, tijd, trein, personeel
3. [ ] Ticket class met passagier, reis, klasse
4. [ ] JavaDoc voor alle classes

geschatte tijd: 2 uur
Prioriteit: HIGH

US-006: Types Maken
enumaraties voor vaste waarden zodat ik type safe-code

Acceptatiecriteria
1. [ ] TicketClass enum (FIRST_CLASS,SECOND_CLASS)
2. [ ] Certification enum met verschillende types
3. [ ] Javadoc voor types


geschatte tijd: 1 uur
Prioriteit: MEDIUM

Sprint 2: Business Logic & User Interface
Doelstellingen
* Main menu implementeren
* Business validaties toevoegen
* Data management

User Stories

US-007: Passagiers Registreren
Passagiers kunnen registreren zodat zij tickets kunnen kopen.

Acceptatiecriteria
1. [ ] Menu optie "Registreer passagier"
2. [ ] Input validatie voor datum formaat
3. [ ] Passenger opslaan in lijst
4. [ ] Bevestiging tonen
5. [ ] Exception handling

geschatte tijd: 2 uur
Prioriteit: HIGH

US-008: Reis aanmaken
reizen kunnen aanmaken zodat passagiers kunnen boeken.

Acceptatiecriteria
1. [ ] Menu optie "aanmaak reis"
2. [ ] Input voor vertrek/aankomst stations
3. [ ] Input voor vertrektijd (LocalDateTime)
4. [ ] Personeel toewijzen aan reis
5. [ ] Validatie: minimum 1 conducteur + 3 stewards 
6. [ ] journey opslaan in lijst

geschatte tijd: 3 uur
Prioriteit: HIGH

US-009: Trein Koppelen aan Reis
trein aan een reis koppelen zodat er capaciteit beschikbaar is


   Acceptatiecriteria
1. [ ] Menu optie "Trein koppelen aan reis"
2. [ ] Reis selecteren uit lijst
3. [ ] Locomotief type kiezen
4. [ ] Wagons toevoegen (1e en 2e klasse)
5. [ ] Validatie: max wagons niet overschrijden
6. [ ] exception handling

geschatte tijd: 2 uur
Prioriteit: HIGH

US-010: Ticket Verkopen
ticket kunnen verkopen zodat passagiers kunnen reizen

Acceptatiecriteria
1. [ ] Menu optie "Tickets verkopen"
2. [ ] Passagiers selecteren
3. [ ] Reis selecteren
4. [ ] Ticket klasse kiezen 
5. [ ] Validatie: capaciteit beschikbaar ?
6. [ ] Validatie: trein gekoppeld aan reis
7. [ ] ticket opslaan
8. [ ] capaciteit bijwerken

geschatte tijd: 3 uur
Prioriteit: HIGH


Sprint 3: File I/O & finalisatie

Doelstellingen
1. [ ] Boardinglijst functionaliteit
2. [ ] Documentatie completeren
3. [ ] Testing en bug fixes

User Stories

US-011: Boardinglijst afdrukken
een boardinglijst kunnen genereren zodat personeel weet wie mee reis

Acceptatiecriteria
1. [ ] Menu optie "Afdrukken Boardinglijst"
2. [ ] Reis afdrukk
3. [ ] Tekstbestand genereren met correcte naam formaat
4. [ ] Passagiers gesorteerd per klasse
5. [ ] Alle passagiers gegevens in bestand
6. [ ] Exception handling voor file I/O

geschatte tijd: 2 uur
Prioriteit: HIGH

US-012: Sample data initialiseren 
sample data hebben zodat ik het systeem kan testen
Acceptatiecriteria
1. [ ] Personeel aangemaakt bij opstarten
2. [ ] Certificaten toegewezen

geschatte tijd: 1 uur
Prioriteit: Medium

US-013: JavaDoc documentatie
volledig JavaDoc zodat andere developers de code begrijpen

Acceptatiecriteria
1. [ ] Alle classes hebben class-level JavaDoc
2. [ ] Alle publiek methoden hebben JavaDoc
3. [ ] @param, @return, @throws tags gebruikt waar relevant
4. [ ] JavaDoc HTML gegenereerd

geschatte tijd: 3 uur
Prioriteit: HIGH

US-014: README en Product Backlog
complete documentatie zodat het project correct kan worden beoordeeld

Acceptatiecriteria
1. [ ] README.md met projectbeschrijving 
2. [ ] installatie instructies
3. [ ] Gebruik uitgelegd
4. [ ] Referenties naar bronnen
5. [ ] Project backlog met planning

geschatte tijd: 2 uur 
Prioriteit: HIGH


US-015: Testing en Bug Fixes
testing van de applicatie

Acceptatiecriteria
1. [ ] alle menu opties getest
2. [ ] Edge cases getest (lege lijsten, ongeldig input) 
3. [ ] Geen crashes bij normale gebruik
4. [ ] Exception messages zijn duidelijk

geschatte tijd: 2 uur
Prioriteit: HIGH

