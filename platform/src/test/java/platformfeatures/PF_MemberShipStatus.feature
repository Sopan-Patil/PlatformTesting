@MembershipStatus
Feature: Validate Membership Status information

@MembershipStatus @Smoke @Full
 Scenario:  Validate Membership Status information

Given Login To Platform
Then Click on Membership Status
And logout

@MembershipStatusEnd @Smoke @Full
 Scenario:  Validate Membership Status information
 
Given Login To Platform
Then Click on End Membership
And logout

@MembershipStatusPlan @Smoke @Full
 Scenario:  Validate Free and Prime Membership Plan Details
 
Given Login To Platform
Then Click on Membership Status
Then Validate Free and Prime Membership Plan Details
And logout
