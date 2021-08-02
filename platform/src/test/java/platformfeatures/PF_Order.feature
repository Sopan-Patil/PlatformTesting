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


@OrderWithCreditCardValid @Smoke @Full
Scenario: Validate order with valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step2 Payment With Valid Credit Card
And Step 3 page proceed to next page
And Verify thank you page for credit card transaction
And Verify thank you page data on order history page for credit card transaction


@OrderWithCreditCardInValid @Smoke @Full
Scenario: Validate order with In valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step2 Payment With In Valid Credit Card

@OrderWithCreditCardBlankValid @Smoke @Full
Scenario: Validate order with Blank valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step2 Payment With Blank Credit Card

@OrderWithConvenienceStoreValid @Smoke @Full
Scenario: Validate order with Blank valid Credit Card

Given Login To Platform Portal
And Select 1st product from product list page
And Step 1 page proceed to next page
And Reglogin between Step 1 page to Step 2 page
And Step2 Payment With Valid Convenience Store
And Step 3 page proceed to next page
And Verify thank you page for convenience store transaction
And Verify thank you page data on order history page for convenience store transaction

@OrderWithExistingCreditCardPurchaseKanji @Smoke @Full
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


