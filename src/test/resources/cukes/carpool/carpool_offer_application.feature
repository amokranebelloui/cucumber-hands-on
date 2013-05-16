Feature: Make a car pooling offer

Background:
 Given I am logged in as "John"
 
Scenario: One time, One destination offer
When I register a car polling offer
Then The offer should be in the system
