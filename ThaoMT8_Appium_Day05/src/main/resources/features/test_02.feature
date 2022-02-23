Feature:  Verify product name and product price

  Scenario: Click first product on Thuong Hieu of Danh Muc San Pham
    Given user at homepage App
    When On menu bar click on Danh Muc San Pham
    And Click “Điện thoại – Máy tính bảng”
    And Scroll to “Bộ lọc Phổ Biến” and click “Thương Hiệu”
    Then button “Xem +++ Sản Phẩm” should be displayed
    And Click “Xem +++ sản phẩm”
    And Click the first product
    Then the product name, product price should be displayed