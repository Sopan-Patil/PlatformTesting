Feature: Validate order flow

@OrderWithExistingCreditCard @Smoke @Full 
Scenario: Validate order with Existing valid Credit Card

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Compare Product Data On Order Step 2 Page
And Compare Product Data On Order Step 3 Page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction
And logout

@OrderWithCreditCardValid @Smoke @Full
Scenario: Validate order with valid Credit Card

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With Valid Credit Card
And Compare Product Data On Order Step 3 Page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction
And logout


@OrderWithCreditCardInValid @Smoke @Full
Scenario: Validate order with In valid Credit Card

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With InValid Credit Card
And logout

@OrderWithCreditCardBlankValid @Smoke @Full
Scenario: Validate order with Blank valid Credit Card

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With Blank Credit Card
And logout

@OrderWithConvenienceStoreValid @Smoke @Full
Scenario: Validate order with valid con store

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With Valid Convenience Store
And Compare Product Data On Order Step 3 Page
And Verify thank you page for convenience store transaction
And Verify thank you page data on order history page for convenience store transaction
And logout

@OrderWithConvenienceStoreInValid @Smoke @Full
Scenario: Validate order with invalid con store

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With InValid Convenience Store
And logout

@OrderWithConvenienceStoreBlank @Smoke @Full
Scenario: Validate order with Blank Con store

Given Login To Platform
And Select 1st product from product list page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Step 2 Payment With Blank Con Store
And logout


@OrderPrimeWithValidCreditCard  @Smoke @Full
Scenario: Validate prime with valid Credit Card and check on order history,service you are using and membership page

Given User is on home page
When User begins account creation
And creates new credentials
And enters confirmation code
And enters valid details
And confirms details
Then Validate that new account is created
Given Login To Platform with newly created user
And Open MemberShip Plan Page from Top page
And Apply MemberShip Plan from Top page
And Compare Prime Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with newly created user
And Compare Prime Data On Order Step 2 Page
And Compare Prime Data On Order Step 3 Page
And Verify thank you page for prime transaction
And Verify thank you page data on order history page for prime transaction
And Verify Service you are using page for prime transaction
And Verify Membership status page for prime transaction
And Verify learn button from Service you are using page
And Add prime user credentials in test data excel
And logout


@OrderRefreshPageWithExistingCreditCard  @Full
Scenario: Validate refresh page for order with Existing valid Credit Card

Given Login To Platform
And Open Product List Page
And Refresh page
And Select 1st product from product list page
And Verify Order Flow Step 1 Page Loaded Successfully
And Refresh page
And Compare Product Data On Order Step 1 Page
And Reglogin between Step 1 page to Step 2 page with exiting user
And Verify Order Flow Step 2 Page Loaded Successfully
And Refresh page
And Compare Product Data On Order Step 2 Page
And Verify Order Flow Step 3 Page Loaded Successfully
And Refresh page
And Compare Product Data On Order Step 3 Page
And Verify Order Flow Step 4 Thank You Page Loaded Successfully
And Refresh page
And logout

