Feature: Validate buttons on member plan page

@FunctionalTest
Scenario Outline: Validate all the buttons on member plan page

Given Login To Platform and check membership plan <browser>
Then Click membership status
When validate link 


Examples:
|browser|
|chrome	|