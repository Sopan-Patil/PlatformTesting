Feature: Open and close intended browser

@OpenBrowser
Scenario: Open browser

When User opens browser 
Then Validate browser is open 


@CloseBrowser
Scenario: Close browser

Given Browser is open
Then Close browser