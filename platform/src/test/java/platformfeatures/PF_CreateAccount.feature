Feature: Create account with new user

@PF_CreateAccount
Scenario: Create new account with valid details

When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And confirms details
Then Validate that new account is created
#Navigate to home page

