#@Author : Chetan Sonparote
#@Date : 12 Jul 2021
#@Description: Feature to test localization for difft user states


@PF_Localization
Feature: Test Localization 
@PF_Localization_NoLogin
Scenario: Test Localization strings without login
When Read localization data from sheet
| NoLogin |
Then Validate that localization is correct

@PF_Localization_WithLogin
Scenario: Test Localization strings with login
When Read localization data from sheet
| WithLogin |
Then Validate that localization is correct


@PF_Localization_FreeUser
Scenario: Test Localization strings for free user
When Read localization data from sheet
| FreeUser |
Then Validate that localization is correct

@PF_Localization_PrimeUser
Scenario: Test Localization strings for prime user
When Read localization data from sheet
| PrimeUser |
Then Validate that localization is correct