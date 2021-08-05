Feature: Validate Account information


@PFAccountAndSecurity @Smoke @Full

@PFAccountAndSecurity @Smoke @Full

 Scenario:  Validate Account information with Valid data 

Given Login To Platform
Then Click on Account and Security
Then Click on Change button
And Update Account Information
And Validate Updated Account Information

@PFAccountAndSecurityInvalidData @Smoke @Full
 Scenario:  Validate Account information  with Invalid data
 
Given Login To Platform
Then Click on Account and Security
Then Click on Change button
And Update and Validate Invalid Account Information
And logout

@PFAccountAndSecurityCancel @Smoke @Full 
 Scenario:  Validate Account information  with Invalid data

Then Click on Change button
Then Click on Cancel button
And logout
