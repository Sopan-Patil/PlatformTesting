Feature: Validate footer links

@FooterTest
Scenario Outline: Validate footer links

Given Navigate to URL on <browser> for footer link verification
Then Validate footer links
And Close browser

Examples:
|browser|
|chrome|
|edge|