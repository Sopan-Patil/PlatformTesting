
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox
@WithdrawAccount @Full @Smoke @PT_111
#Withdrawal PT_111
Feature: Withdraw user account

Scenario: User is clicking on Top button in Withdrawal Page.

Given Login To Platform Portal
Then Click Withdrawal link on Footer
Then Check Top button on Withdrawal Page
