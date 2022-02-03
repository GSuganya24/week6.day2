Feature: Merge two Leads

Scenario: TC003_Merge two Leads

Given Click the MergeLeads Tab
And Enter the first name as 'Suganya' in the From Lead field
And Enter the first name as 'Rishikesh' in the To Lead field
And Click the Merge button
And Click the FindLeads tab
And Enter the LeadId in the search field
When Click the Find Leads button
Then No record should return




