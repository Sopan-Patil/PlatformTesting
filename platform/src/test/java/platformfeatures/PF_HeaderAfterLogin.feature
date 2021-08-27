Feature: To check Header Links After Login

@HeaderValidationAfterLogin @Full @Smoke

Scenario: Validate Header Links After Login

When User logins
Then Validate that menus and SubMenus are Visible
And Validate that menus and Submenus are working



