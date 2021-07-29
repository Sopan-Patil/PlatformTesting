Feature: Validate order flow

@OrderCreditCardValid @Smoke @Full
Scenario: Validate order with valid Credit Card

Given Login To Platform Portal
And Perform order valid credit card flow
