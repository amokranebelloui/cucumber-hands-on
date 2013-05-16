Feature: Make a car pooling offer

Background:
 Given I am logged in as "Paul"

Scenario: One time, One destination offer
Given I have the folowing offers:
  | id | from   | to         |
  | 1  | Lyon   | Marseille  |
  | 2  | Munich | Strasbourg |
When I register a car polling offer
And I specify the departure from "Caen" on "Monday 12" at "13h"  
And I specify the destination as "La Défense, Paris"
Then The offer should be in the system
