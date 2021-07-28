@OrderValid @Smoke
Feature: Validate order with credit card

@FunctionalTest 
Scenario Outline: Validate order with credit card

Given Navigate to URL and login and perform order flow with valid credit <browser>
Given Navigate to URL and login and perform order flow with invalid credit<browser>
Then Close browsers

Examples:
|browser|
|chrome	|




