
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox

Feature: Withdraw user account
@WithdrawAccount
Scenario: User is withdrawing the account

Given Login To Platform Portal
Then Click Withdrawal link on Footer
Then Withdraw Account
