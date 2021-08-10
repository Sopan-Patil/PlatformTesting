Feature: To check Header Links

@HeaderValidation
Scenario Outline: Validate Header Links

Given Open and Navigate to URL on <browser> 
When User hovers on header Links
Then Validate that links are visible
And Validate that menus are working
And Validate that sub menus are working
And Close the browsers


Examples:
|browser|
|chrome	|



