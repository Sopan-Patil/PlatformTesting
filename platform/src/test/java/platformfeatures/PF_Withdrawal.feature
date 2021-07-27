
#Author: Sahaj Balgunde
#Keywords Summary : Withdawal Test with Checkbox and Without Checkbox



Feature: Withdraw user account
@FunctionalTest 
Scenario Outline: User is withdrawing the account

#Given User is on Withdrawal Page
#When User clicks on accept checkbox
#Then the check box is clickable


#Scenario: User is withdrawing the account

Given User is on Withdrawal Page ticks the checkbox and withdraw account <browser>
Then Account gets deleted


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






















#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
