@MembershipStatus
Feature: Validate Membership Status information

@MembershipStatus @Smoke @Full
 Scenario:  Validate Membership Status information

Given Login To Platform
Then Click on Membership Status
And logout

@MembershipStatus @Smoke @Full
 Scenario:  Validate Membership Status information

Given Login To Platform
Then Click on End Membership
And logout
