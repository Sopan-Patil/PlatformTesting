Feature: Validate Invalid credit card no

@PFInvalidCC
Scenario: Validate Invalid Credit Card

#Given Navigate to URL on <browser>
Given Login To Platform Portal
Then Click on Membership Status link
Then Click on Change Card
Then Enters invalid credit card details
#Then close browser

#Examples:
#|browser|
#|chrome	|

