Feature: Login
  As user I should be able to login into the library web application

  Scenario: Login as a librarian
    Given User is on the library login page
    When User enters librarian "librarian62@library" email address
    And User enters librarian "DdZ8SHvz" password
    And User clicks on login button
    And User should see library main page
    Then User clicks on logout button


  Scenario: Login as a student
    Given User is on the library login page
    When User enters student's "student69@library" email address
    And User enters student's "gk9RIiC1" password
    And User clicks on login button
    Then User should see main book page