Feature: Login

Scenario: Login with correct credentials
Given I am not logged in
And the account "john.doe" with password "pass" exists
When I login with "john.doe" and "pass"
Then A session should exist for "john.doe"
