Feature: Create Duplicate Lead

Scenario Outline: TC002_Create Duplicate Lead

Given Click the Find Lead Tab
And Click Email Tab
And Enter the email address as <email>
When Click Find Leads
Then Records should be displayed
Given Take the firstName of the Lead
And Click the first resulting Lead
And Click the Duplicate Lead button
When Click the Create Lead button
Then View Lead page should be displayed
Given Take the firstName of the Lead created
And Check Whether the names are equal

 


Examples:
|email|
|'gsuganyakrishnan@gmail.com'|
|'rishikesh2016@gmail.com'|
