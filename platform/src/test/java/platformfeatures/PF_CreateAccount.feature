Feature: Create account with new user

@CreateAccountTest 
Scenario Outline: Create new account with valid details

Given Navigate to URL on <browser>
When User begins account creation
And creates new credentials
And enters valid details
And confirms details
Then Validate that new account is created
And Close browser


Examples:
|browser|
|chrome	|