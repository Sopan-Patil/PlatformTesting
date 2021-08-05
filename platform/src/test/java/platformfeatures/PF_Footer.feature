Feature: Validate footer links
@FooterPage
Scenario Outline: Validate Footer Links

Given Open Browser <browser>
And Check footer links
#SAnd check footer links after login
Then Close browser


Examples:
|browser|
|chrome	|

