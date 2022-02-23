@tag
Feature: verify element of tab
  @tag1
  Scenario: Verify Home Screen
    Given user at splash activity
    When Click to bắt đầu trải nghiệm
    And Click to Deny
    Then The Home screen should displayed
  @tag2
  Scenario: Verify "Thương hiệu" screen
    Given user at splash activity
    When Click to bắt đầu trải nghiệm
    And Click to Deny
    And Click to Thương hiệu on footer menu
    Then The screen should be displayed 9 branch name
  @tag3
  Scenario: Verify "Ưu đãi" screen
    Given user at splash activity
    When Click to bắt đầu trải nghiệm
    And Click to Deny
    And Click to Ưu đãi on footer menu
    And Click to the first item
    Then The screen should be displayed with some item
  @tag4
  Scenario: Verify "Voucher" screen
    Given user at splash activity
    When Click to bắt đầu trải nghiệm
    And Click to Deny
    And Click to Voucher on footer menu
    And Swipe and click to the last Voucher
    Then Screen should be displayed with some item
  @tag5
  Scenario: Verify "Cá nhân" screen
    Given user at splash activity
    When Click to bắt đầu trải nghiệm
    And Click to Deny
    And Click to Cá nhân on footer menu
    Then The screen should be displayed with 4 tabs: Mã ưu đãi, Ưu đãi, Voucher and Thương hiệu. 