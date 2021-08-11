Feature: Create account with new user

@PF_CreateAccount @Full
Scenario: Create new account with valid details
Given User is on home page
When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And confirms details
Then Validate that new account is created


@PF_CreateAccount_ResendCode
Scenario: Resend verification code
Given User is on home page
When User begins account creation
And creates new credentials
And User clicks resend confirmation code
And enters confirmation code
Then Validate that new code is accepted

@PF_CreateAccount_InvalidCode
Scenario: Resend verification code
Given User is on home page
When User begins account creation
And creates new credentials
And User enters invalid code
Then Validate that error is displayed for invalid code
