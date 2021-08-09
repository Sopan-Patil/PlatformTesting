Feature: Validate footer links
@FooterPage
Scenario Outline: Validate Footer Links

Given Navigate to URL <browser>
And Check footer links
Then Check footer links on Login Page
Then Check footer links on top page after login
Then Close browser


Examples:
|browser|
|chrome	|

