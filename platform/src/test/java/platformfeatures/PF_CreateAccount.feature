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

@PF_CreateAccountInvalidEmail
Scenario: Create new account with invalid email id
Given User is on home page
When User begins account creation
And User enters invalid email
Then Validate error message is displayed


@PF_CreateAccount_Return
Scenario: Functionality of Return button
Given User is on home page
When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And clicks return button on step 4
Then Validate redirection to previous page

@PF_CreateAccount_StudyGear
Scenario: Redirection to study gear
Given User is on home page
When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And confirms details
And clicks start study gear button
Then Validate that user is redirected to study gear page
