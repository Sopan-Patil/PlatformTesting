
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox
@WithdrawAccount @Full @Smoke
Feature: Withdraw user account

Scenario: User is clicking on Back button

Given Login To Platform Portal
Then Click Withdrawal link on Footer
Then Check Back button on Withdrawal Page

@PT_111
Scenario: User is clicking on Top button in Withdrawal Page.

Given Login To Platform Portal
Then Click Withdrawal link on Footer
Then Check Top button on Withdrawal Page


Scenario: User is withdrawing the account

Then Click Withdrawal link on Footer
Then Withdraw Account