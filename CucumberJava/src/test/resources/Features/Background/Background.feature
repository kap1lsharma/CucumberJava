Feature: check homepage functionality 


Background: user is logged in 
	Given user is on login page 
	When user enters username and password 
	And clicks on login button 
	Then user is navigated to the homepage 
	
Scenario: check view profile link 
	When user clicks on view link 
	Then logout link is displayed 
	
Scenario: verify setup button is present 
	When user clicks on gear icon 
	Then setup button is displayed  