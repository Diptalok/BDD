#Author: Diptalok Sahoo

Feature: OpportunitiesModule.

Scenario: To add new opportunity and delete it

Given I want to launch the browser
And Load the URl
When Log in page is displayed enter the username and password and click on the log in button
Then Validate for Homepage
When Homepage is visible click on opportunities link
Then validate opportunities page is visible
When opportunities page is visible click on Add opportunities picture
Then validate create new opportunities page is visible
When new opportunities page is visible fill up the mandatory fields in create opportunities page and save it
Then validate a new opportunities is created
When going backward twice opportunities page is visible
Then click on delete opportunities
When alert asking for confirmation
Then accept the alert
And take a screenshot for validation
When homepage is displayed move to adminstrator
And Click on sign out
Then validate for signout
And close the browser
