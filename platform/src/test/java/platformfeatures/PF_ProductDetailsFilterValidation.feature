@ProductDetailsFilterValidation
Feature: Validate Product Filter feature

@ProductDetailsFilterValidation @Smoke @Full
 Scenario: Validate Product Filter feature for Free User

Given Login To Platform
Then Click on Product List
Then Validate CASEC Product Details
Then Validate Kanji Kentei Product Details
And logout
