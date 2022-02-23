Feature: Google Searching

 Scenario: Google search result page elements
 Given the user navigates to the Google home page
 When the user entered "panda" at the search bar
 Then the results page shows links related to "panda"
 And image links for "panda"
 And video links for "panda"
 
Scenario: Simple Google search
 Given a web browser is on the Google page
 When the search phrase "panda" is entered
 Then results for "panda" are shown
 And the following related results are shown