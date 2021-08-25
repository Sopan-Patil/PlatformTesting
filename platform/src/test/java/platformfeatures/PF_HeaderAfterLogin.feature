Feature: To check Header Links After Login

@HeaderValidationAfterLogin

Scenario: Validate Header Links After Login

When User logins
Then Validate that menus and SubMenus are Visible
And Validate that menus and Submenus are working



