#Usability Testing
Feature: To validate that Buy module is working properly
Background:
Given User is inside Ready to move shortcut

#This Scenerio is to check that property is added to shortlisted
@LikeTheProperty
Scenario: Click on heart to add to shortlist property
When User click on heart present on property card
Then Property is added to shortlisted property list


#This Scenerio is to check if properties are sorted in high to low order
@SortProperty
Scenario: User is able to get sort properties
When User click on Sort By Price High to Low
Then Properties are sorted By Price High to Low


#This Scenerio is to check if user is able to get contact details with valid credentials
@GetPhoneNoWithValidDetails
Scenario Outline: User is able to get contact details of Owner via email
When User click on Get Phone no. button 
And User click on Get Contact Details button
And User Fill the details <userName>, <email>, <phoneNo>
And User click on Get Contact Details button again
And User Enter otp
Then User is able to get the details via email

Examples:
|userName|email|phoneNo|
|Urwashi Patidar|patidarurwashi0@gmail.com|8463837881|



#This Scenerio is to check if user is able to get error messges with invalid credentials
@GetPhoneNoWithInvalidDetails
Scenario: User is able to get error messages for filling invalid details
When User click on Get Phone no. button to fill invalid details 
And User click on Get Contact Details button to fill invalid details 
Then User is able to get diffrent error messages details via email



#This Scenerio is to check if user is able to share property via whatsapp
@ShareProperty
Scenario: User is able to share the property via whatsaap
When User click on share icon button on property card
And User click on whatsapp icon 
Then User is able to get property details via whatsapp





