Feature: Open and close local browser


Scenario Outline: Open local browser
Given Navigate to url on <browser> local
Then Run test script
And Close local browser

@LocalSingleBrowser
Examples: Local single browser
|browser|
|chrome|


@LocalCrossBrowser
Examples: Local cross browser
|browser|
|chrome|
|edge|
|firefox|





