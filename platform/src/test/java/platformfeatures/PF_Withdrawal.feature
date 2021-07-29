
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox



Feature: Withdraw user account
@FunctionalTest 
Scenario Outline: User is withdrawing the account

#Given User is on Withdrawal Page
#When User clicks on accept checkbox
#Then the check box is clickable


#Scenario: User is withdrawing the account

Given Open Browser and URL <browser>
Then User is on Withdrawal Page ticks the checkbox and withdraw account
Then Account gets deleted
Then Browser is closed


Examples:
|browser|
|chrome	|

#Scenario: User is withdrawing the account

#Given User is on Withdrawal Page
#When User clicks on "é€€ä¼šã�™ã‚‹" Button without clicking checkbox. 
#Then Account doesn't get deleted


#Scenario: User is withdrawing the account.

#Given User is on Withdrawal Page.
#When User clicks on "æˆ»ã‚‹" Button. 
#Then Button Redirects to top page.





















