@tag
Feature: Title of your feature

  @tag1
  Scenario: Verify product name and product price 
    Given user opened Banggood Easy Online Shopping App
    When Click to the Category on footer menu
    And Scroll and click to “Home and Garden” in Left menu
    Then the right category displayed
    When click to the “Home Decor”
    And Click to the Filter and input price from 20 to 30
    And Click Done
    And Click first product
    Then product name should be displayed and product price in range 20 to 30
  @tag2
  Scenario: Verify display product name, price and quantity
    Given user opened Banggood Easy Online Shopping App
    When scroll to “Hot Categories”
    And Click to the first category
    And Click to the first product
    Then The product detail page should be displayed : Product name, product price, Buy now button and Add to Cart button.
    When Click “Add to Cart”
    And Click to “Add to Cart” button
    And Click to Cart icon on footer
    Then product name, product size, product price and quantity should be dislayed
  @tag3
  Scenario: Verify login screen display 
    Given user opened Banggood Easy Online Shopping App
    When Click Account on footer menu
    And Click View All Order
    Then the login screen should be displayed with: Email, password and Sign In button.
