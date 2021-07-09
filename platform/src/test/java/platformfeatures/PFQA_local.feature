Feature: Open and close local browser

@OpenBrowser
Scenario Outline: Open local browser

Given Navigate to URL on local <browser> 
Then Close local browser


Examples: Local single browser
|browser|
|chrome|

Examples: Local cross browser
|browser|
|chrome|
|edge|

|firefox|



#@CloseBrowser
#Scenario: Close local browser

#Given Local browser is open
#Then Close local browser



