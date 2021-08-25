@LoginAlltest
Feature: Validate new login 

@FunctionalTest  @PF_test
Scenario: Validate new login features 
#Given Navigate to URL on <browser>
Then Login To Platform
And logout

@APF_Login_InvalidUser @Smoke
Scenario: Login with invalid user name
Given User is on home page
When User clicks login button
And User enters invalid user name and valid password
Then Validate that error is displayed for invalid user name
And logout

@APF_Login_InvalidPassword @Smoke
Scenario: Login with invalid password
Given User is on home page
When User clicks login button
And User enters valid user name and invalid password
Then Validate that error is displayed for invalid password
And logout

@APF_Login_InvalidDetails @Smoke
Scenario: Login with invalid password
Given User is on home page
When User clicks login button
And User enters invalid details
Then Validate that error is displayed for invalid details
And logout