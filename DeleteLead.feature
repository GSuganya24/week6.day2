Feature: Delete Lead

Scenario Outline: TC004_Delete Lead

Given Click the Find Leads Tab
And Search by phoneNumber <number>
And Capture the first resulting LeadId
And Click the first resulting LeadId
And Delete the record
And Click the Find Leads Tab
When Search for the LeadId captured
Then No records found should be displayed


Examples:
|number|
|'9886337375'|
|'8122105073'|