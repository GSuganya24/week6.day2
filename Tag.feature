Feature: Using Tag Name
@Create
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

@Duplicate
Scenario Outline: TC002_DuplicateLead

Given Click the Find Lead Tab
And Click Email Tab
And Enter the email address as <email>
When Click Find Leads
Then Records should be displayed
Given Take the firstName of the Lead
And Click the first resulting Lead
And Click the Duplicate Lead button
When Click Submit button
Then View Lead page should be displayed
Given Take the firstName of the Lead created
And Check Whether the names are equal


Examples:
|email|
|'gsuganyakrishnan@gmail.com'|
|'rishikesh2016@gmail.com'|

@Merge
Scenario: TC003_MergeLead

Given Click the MergeLeads Tab
And Enter the first name as 'Suganya' in the From Lead field
And Enter the first name as 'Rishikesh' in the To Lead field
And Click the Merge button
And Click the FindLeads tab
And Enter the LeadId in the search field
When Click the Find Leads button
Then No record should return

@Delete
Scenario Outline: TC004_DeleteLead

Given Click the FindLeads tab
And Search by phoneNumber <number>
And Capture the first resulting LeadId
And Click the first resulting LeadId
And Delete the record
When Search for the LeadId captured
Then No records found should be displayed


Examples:
|number|
|'9886337375'|
|'8122105073'|