Feature: Validate footer links on Footer Sections

@FooterPage
#Testcase no: PT-090 to 95
Scenario: Validate Footer Links on Top Page

Then Check footer links on Top Page

@FooterPage
#Testcase no: PT-122
Scenario: Check Links on Terms and Conditions Page

Then Check links in Terms of Use Page

@FooterPage
#Testcase no: PT-102 to PT-105
Scenario: Validate Footer on Account and Services Page 
Then Check footer links on Login Page

@FooterPage
#Testcase no: PT-096 to PT-101
Scenario: Validate Footer on User Top Page 

Given Login to Platform Portal
Then Check footer links on top page after login

@FooterPage
#Testcase no: PT-102 to PT-105
Scenario: Validate Footer on Order Screen One

Given Login to Platform Portal
Then Check Footer Links on First Order Screen

@FooterPage
#Testcase no: PT-102 to PT-105
Scenario: Validate Footer on Order Screen Two and Three

Given Login to Platform Portal
Then Check Footer Links on Second Order Screen
Then Check Footer Links on Third Order Screen