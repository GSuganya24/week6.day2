Feature: Create Lead in Leaftaps

Scenario Outline: TC001_CreateLead

When Click the CreateLead Button
Then CreateLead page should open
Given Enter the companyName as <company>
And Enter the firstName as <fName>
And Enter the lastName as <lName>
And Enter the Email Address as <email>
And Enter the PhoneNumber as <phoneNo>
When Click Submit button
Then ViewLead should be displayed

Examples:
|company|fName|lName|email|phoneNo|
|'Testleaf'|'Suganya'|'Gopalakrishnan'|'gsuganyakrishnan@gmail.com'|'9886337375'|
|'IBM'|'Rishikesh'|'Venkat'|'rishikesh2016@gmail.com'|'8122105073'|





