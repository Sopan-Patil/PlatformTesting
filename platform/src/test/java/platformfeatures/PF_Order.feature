Feature: Validate order flow

@OrderWithExistingCreditCard @Smoke @Full
Scenario: Validate order with Existing valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 page proceed to next page
And Step 3 page proceed to next page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction
And logout

@OrderWithCreditCardValid @Smoke @Full
Scenario: Validate order with valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With Valid Credit Card
And Step 3 page proceed to next page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction
And logout


@OrderWithCreditCardInValid @Smoke @Full
Scenario: Validate order with In valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With InValid Credit Card
And logout

@OrderWithCreditCardBlankValid @Smoke @Full
Scenario: Validate order with Blank valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With Blank Credit Card
And logout

@OrderWithConvenienceStoreValid @Smoke @Full
Scenario: Validate order with valid con store

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With Valid Convenience Store
And Step 3 page proceed to next page
And Verify thank you page for convenience store transaction
And Verify thank you page data on order history page for convenience store transaction
And logout


@OrderWithConvenienceStoreInValid @Smoke @Full
Scenario: Validate order with invalid con store

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With InValid Convenience Store
And logout

@OrderWithConvenienceStoreBlank @Smoke @Full
Scenario: Validate order with Blank Con store

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With Blank Con Store
And logout

@OrderWithExistingCreditCardPurchaseKanji  @Full
Scenario: Validate order with Existing valid Credit Card to purchase kanji product

Given Login To Platform Portal
And Select 1st kanji product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 page proceed to next page
And Step 3 page proceed to next page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction
And Verify learn button from Service you are using page
And logout

@OrderRefreshPageWithExistingCreditCard  @Full
Scenario: Validate refresh page for order with Existing valid Credit Card

Given Login To Platform Portal
And Open Product List Page
And Refresh page
And Select 1st kanji product from product list page
And Confirm Order Flow Step 1 Page Load Successfully
And Refresh page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Confirm Order Flow Step 2 Page Load Successfully
And Refresh page
And Step 2 page proceed to next page
And Confirm Order Flow Step 3 Page Load Successfully
And Refresh page
And Step 3 page proceed to next page
And Confirm Order Flow Step 4 thank you Page Load Successfully
And Refresh page
And logout

@OrderNavigatePagesWithBackButton @Smoke @Full
Scenario: Validate page with back button from order flow

Given Login To Platform Portal
And Open Product List Page
And Select 1st kanji product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 page proceed to next page
And Confirm Order Flow Step 3 Page Load Successfully
And Click on back button from order flow
And Confirm Order Flow Step 2 Page Load Successfully
And Click on back button from order flow
And Confirm Order Flow Step 1 Page Load Successfully
And logout

@OrderPrimeWithValidCreditCard @Smoke @Full
Scenario: Validate prime with valid Credit Card and check on order history,service you are using and membership page

Given Login To Platform Portal
And Open MemberShip Plan Page from Top page
And Apply MemberShip Plan from Top page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step 2 Payment With Valid Credit Card
And Step 3 page proceed to next page
And Verify thank you page for prime transaction
And Verify thank you page data on order history page for prime transaction
And Verify Service you are using page for prime transaction
And Verify Membership status page for prime transaction




