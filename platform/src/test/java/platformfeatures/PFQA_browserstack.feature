Feature: Open and close browserstack 



@OpenBrowserstack
Scenario Outline: Open browserstack 
	Given Navigate to URL on browserstack with <config> and <environment> 
	Then Validate if browserstack browser is open 
	
	Examples: Single browser parameters 
		|config				|environment|
		|single.conf.json	|chrome		|
		
	
	Examples: Cross browser parameters 
		|config				|environment|
		|parallel.conf.json	|env1		|
		|parallel.conf.json	|env2		|
		|parallel.conf.json	|env3		|
		
	
	Examples: Must Have parameters 
		|config				|environment|
		|mustHave.conf.json	|env1		|
		|mustHave.conf.json	|env2		|
		|mustHave.conf.json	|env3		|
		|mustHave.conf.json	|env4		|
		|mustHave.conf.json	|env5		|
		|mustHave.conf.json	|env6		|
	
#@CloseBrowserstack	
#Scenario: Close browserstack 
#		Given Browserstack browser is open 
#		Then Close browserstack browser 
		
		
		
