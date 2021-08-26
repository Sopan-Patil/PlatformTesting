Feature: Validate Invalid credit card no

@PFProductRepurchase @Smoke @Full
Scenario: Validate Invalid Credit Card

Given Login To Platform with Prime user
Then Select product from test data excel
And Select product from test data excel
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Compare Product Data On Order Step 2 Page
And Compare Product Data On Order Step 3 Page
And logout
