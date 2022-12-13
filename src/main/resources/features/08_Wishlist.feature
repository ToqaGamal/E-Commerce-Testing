@smoke
Feature: This is Wishlist Feature


  Scenario: Adding HTC One M8 Android L 5.0 Lollipop to wishlist
    When User click on wishlist button of HTC One M8 Android L 5.0 Lollipop
    Then Success MSG appears

  Scenario: Adding HTC One M8 Android L 5.0 Lollipop to wishlist and get Qty value
    When User click on wishlist button of HTC One M8 Android L 5.0 Lollipop
    Then Success MSG appears
    And user get Qty value and verify that it is <0
    Then no. of wishlist inc.