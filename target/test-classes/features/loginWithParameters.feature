@librarian
Feature: Login into library application with parameters

  Scenario: Login as librarian same line
    Given User is on the library login page
    When User login using "librarian12@library" and "AOYKYTMJ"
    And User clicks on login button
    And dashboard should be displayed
    Then there should be 7347 'users'