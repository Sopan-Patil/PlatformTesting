Feature: Validate new login 

@FunctionalTest
Scenario Outline: Validate new SingIn features 

Given Navigate to URL on <browser> Platform
Then SignIn for Platform


Examples:
|browser|
|chrome	|

@BrowserstackTest
Scenario Outline: Validate new login features 

Given Navigate to URL with <config> and <environment> PFQA_123_1
#Given Navigate to URL with <config> PFQA_123_1
Then Login for PFQA_123_1
And Close browser

Examples:
#|config|
#|single.conf.json|
|config|environment|
|single.conf.json|chrome|
#|mustHave.conf.json|env6|

