Feature: Test Login Functionality 

Scenario Outline: Check login is successful with valid creadentials 
	Given browser is open 
	And user is on login page 
	When user enters <username> and <password> 
	And user clicks on login 
	Then user is navigated to the home page 
	And user clicks on new 
	
	
	
	#	And user fills the details 
	#	And clicks on next 
	#	Then Wizard two appears
	
	Examples: 
	
		|username|password|
		|samriddh.malik@psagtechnologies.com.psagorg.qa|SAMRIDDH@123|
		
		
		
		  