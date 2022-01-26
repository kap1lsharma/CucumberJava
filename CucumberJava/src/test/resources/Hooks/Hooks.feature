Feature: check login functionality 

Scenario Outline: 
	Given user is on login Page 
	When user enters valid <username> and <password> 
	And clicks on login button 
	Then user is navigated to the Home Page
	
		Examples:
	
	|username|password|
	|samriddh.malik@psagtechnologies.com.psagorg.qa|SAMRIDDH@123|
 