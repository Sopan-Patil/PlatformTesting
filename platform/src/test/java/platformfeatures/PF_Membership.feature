Feature: Validate buttons on member plan page

@MembershipPlan
Scenario Outline: Validate all the buttons on member plan page

Given Navigate to URL and Login To PF Portal<browser> 
When User clicks on Membership Status
Then User clicks on apply for prime membership banner
Then Check the link validation on member plan page



Examples:
|browser|
|chrome	|