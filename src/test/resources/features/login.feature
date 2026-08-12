Feature: OrangeHRM login

  Scenario: Login with valid credentials
    Given the user is on Orange HRM page
    When the user enters valid username and password
    And the user clicks on the Login button
    Then the OrangeHRM dashboard should open