@smoke
Feature: F02_Login | users could use login functionality to use their accounts


  #Scenario 1
  Scenario:(P1) user could login with valid email and password
    Given user go to login page
    When user login with "valid" "fast@gmail.com" and "P@ssw0rd"
    And user press on login button
    Then user login to the system successfully


  #Scenario 2
  Scenario:(P2) user could login with invalid email and password
    Given user go to login page
    When user login with "invalid" "wrong@example.com" and "P@ssw0rd"
    And user press on login button
    Then user could not login to the system
