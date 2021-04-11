Feature: Login Page Feature
 

Scenario: Login Page Title
Given user is on Login Page 
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on Login Page
Then forgot your password link should be displayed

Scenario: Login with correct credential
Given user is on Login Page
Then user enters username "sathiya@gmail.com"
And user enters password "sathiya"
And user clicks on Login button
And page title should be "My account - My Store"
