Feature: Validate new login 


@FunctionalTest
Scenario: Validate new login features 

#Given Navigate to URL on <browser>
Then Login To Platform
And logout



@APF_Login_InvalidUser
Scenario: Login with invalid user name
Given User is on home page
When User clicks login button
And User enters invalid user name and valid password
Then Validate that error is displayed for invalid user name

@APF_Login_InvalidPassword
Scenario: Login with invalid password
Given User is on home page
When User clicks login button
And User enters valid user name and invalid password
Then Validate that error is displayed for invalid password

@APF_Login_InvalidDetails
Scenario: Login with invalid password
Given User is on home page
When User clicks login button
And User enters invalid details
Then Validate that error is displayed for invalid details