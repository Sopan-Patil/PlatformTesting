Feature: Validate new login 

@FunctionalTest
Scenario Outline: Validate new login features 

Given Navigate to URL on <browser> PFQA_123_1
Then Login for PFQA_123_1
And Close browser

Examples:
|browser|
|chrome|

