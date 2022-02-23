Feature: Google searching

  Scenario: Search from the search bar
    Given a website is at the google home page
    When the user enters "panda" into the search bar
    Then links related to "panda" are shown on the result page

  Scenario: Image search 
    Given results for "panda" are shown 
    When the user clicks on "Iamges" link at the top of the results page
    Then images related to "panda" are shown on the results page

