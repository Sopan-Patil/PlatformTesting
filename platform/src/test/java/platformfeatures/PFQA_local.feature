Feature: Open and close local browser

@OpenBrowser
Scenario Outline: Open local browser

Given Navigate to URL on local <browser> 
Then Validate if browser is open


Examples:
|browser|
|chrome|

@CloseBrowser
Scenario: Close local browser

Given Browser is open
Then Close browser



