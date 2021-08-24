Feature: Validate Invalid credit card no

@PFInvalidCC @Smoke @Full
Scenario: Validate Invalid Credit Card

#Given Navigate to URL on <browser>
Given Login To Platform
Then Click on Membership Status link
Then Click on Change Card
Then Enters invalid credit card details
And logout

#Examples:
#|browser|
#|chrome	|

