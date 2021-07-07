Feature: Open and close browserstack 

@OpenBrowser
Scenario Outline: Open browserstack browser

Given Navigate to URL on browserstack <browser> 
Then Validate if browserstack browser is open


Examples:
|browser|
|chrome|

@CloseBrowser
Scenario: Close browserstack browser

Given Browserstack browser is open
Then Close browserstack browser



