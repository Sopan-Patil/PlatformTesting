Feature: Validate Invalid credit card no

@FunctionalTest
Scenario Outline: Validate Invalid Credit Card

Given Login To Platform Portal <browser>
Then Click on Membership Status
Then Click on Change Card
Then Enters invalid credit card details

Examples:
|browser|
|chrome	|

