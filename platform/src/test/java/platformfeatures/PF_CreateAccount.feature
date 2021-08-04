Feature: Create account with new user

@PF_CreateAccount @Smoke @Full
Scenario: Create new account with valid details
Given User is on home page
When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And confirms details
Then Validate that new account is created
#Navigate to home page

@PF_CreateAccountInvalidEmail
Scenario: Create new account with invalid email id
Given User is on home page
When User begins account creation
And User enters invalid email
Then Validate error message is displayed