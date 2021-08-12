Feature: Functionality of forgot and reset password


@PF_Password_ForgotPasswordPage
Scenario: Test working of forgot password link
When User clicks on forgot password link
Then Validate that forgot password page is visible

@PF_Password_ResetPassword
Scenario: Test working of reset password 
When User clicks on forgot password link
And enters email id to reset password
And enters confirmation code
And enters new password
Then Validate that password change is complete


@PF_Password_ResetPassword_InvalidEmail
Scenario: Test working of reset password with invalid email
When User clicks on forgot password link
And enters invalid email id
Then Validate that error message is displayed for invalid email id