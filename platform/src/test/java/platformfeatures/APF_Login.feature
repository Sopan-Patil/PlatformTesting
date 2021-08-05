Feature: Validate new login 


@FunctionalTest
Scenario: Validate new login features 

#Given Navigate to URL on <browser>
Then Login To Platform
And logout


#Examples:
#|browser|
#|chrome	|


@APF_Login_InvalidUser
Scenario: Login with invalid user name
Given User is on home page
When User clicks login button
And User enters invalid user name and valid password
Then Validate that error is displayed for invalid user name