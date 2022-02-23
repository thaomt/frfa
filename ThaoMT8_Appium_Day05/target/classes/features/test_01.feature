Feature:  Verify product name and product price

  Scenario: Click first product on “Hàng mới” of Laptop – May Vi Tinh
    Given user at homepage TIKI App
    When on menu bar click Danh Muc San Pham
    And Click Laptop – May Vi Tinh
    And Scroll and click to “Hàng mới”
    And Click first the product
    Then the product name, product price display