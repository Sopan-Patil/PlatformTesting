Feature: Validate footer links
@FooterPage
Scenario Outline: Validate Footer Links

Given Navigate to URL and check footer links <browser>
#SAnd check footer links after login
Then Close browser


Examples:
|browser|
|chrome	|

