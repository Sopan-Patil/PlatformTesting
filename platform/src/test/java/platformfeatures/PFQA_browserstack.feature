Feature: Open and close browserstack 

@OpenBrowserstackSingle
Scenario Outline: Open browserstack single browser

Given Navigate to URL on browserstack with <config> and <environment> 
Then Validate if browserstack browser is open


Examples:

|config				|environment|
|single.conf.json	|chrome		|

@OpenBrowserstackCrossBrowser
Scenario Outline: Open browserstack cross browser

Given Navigate to URL on browserstack with <config> and <environment> 
Then Validate if browserstack browser is open


Examples:

|config				|environment|
|parallel.conf.json	|env1		|
|parallel.conf.json	|env2		|
|parallel.conf.json	|env3		|

@OpenBrowserstackMustHave
Scenario Outline: Open browserstack cross browser

Given Navigate to URL on browserstack with <config> and <environment> 
Then Validate if browserstack browser is open


Examples:

|config				|environment|
|mustHave.conf.json	|env1		|
|mustHave.conf.json	|env2		|
|mustHave.conf.json	|env3		|
|mustHave.conf.json	|env4		|
|mustHave.conf.json	|env5		|
|mustHave.conf.json	|env6		|



@CloseBrowserstack
Scenario: Close browserstack browser

Given Browserstack browser is open
Then Close browserstack browser



