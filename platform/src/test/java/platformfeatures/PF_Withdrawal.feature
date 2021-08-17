
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox
@WithdrawAccount
Feature: Withdraw user account

Scenario: User is clicking on Back button

Given Login To Platform Portal
Then Click Withdrawal link on Footer
Then Check Back button on Withdrawal Page


Scenario: User is withdrawing the account

Then Click Withdrawal link on Footer
Then Withdraw Account