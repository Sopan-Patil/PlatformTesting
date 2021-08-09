Feature: Validate buttons on member plan page

@MembershipPlan
Scenario Outline: Validate all the buttons on member plan page

Given Navigate to URL<browser> 
Then Login To PF Portal 
Then Click on Membership Status and Click on apply for prime membership banner
Then Check the link validation on member plan page



Examples:
|browser|
|chrome	|