Feature: Validate Account information

@PFAccountAndSecurity @Smoke
 Scenario:  Validate Account information
 
#Given Navigate to URL on <browser>
Given Login To Platform
Then Click on Account and Security
Then Click on Change button
And Update Account Information
And Validate Updated Account Information
And logout
#Examples:
#|browser|
#|chrome	|
