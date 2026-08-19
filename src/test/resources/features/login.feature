Feature: OrangeHRM login

  Background:
    Given the user is on Orange HRM login page

  @positive
  Scenario: Login with valid credentials
    When the user enters valid username and password
    And the user clicks on the Login button
    Then the OrangeHRM dashboard should open
    And the profile name should be displayed
    And the profile name should be displayed

  @negative
  Scenario Outline: Login with invalid credentials
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the Login button
    Then the invalid credentials message should be displayed
    And the invalid credentials message should be "Invalid credentials"

    Examples:
      | username      | password      |
      | WrongAdmin    | admin123      |
      | Admin         | wrongPassword |
      | WrongAdmin    | wrongPassword |

  @validation
  Scenario: Login with a blank username
    When the user leaves the username blank
    And the user enters password "admin123"
    And the user clicks on the Login button
    Then the username required message should be displayed

  @validation
  Scenario: Login with a blank password
    When the user enters username "Admin"
    And the user leaves the password blank
    And the user clicks on the Login button
    Then the password required message should be displayed

  @validation
  Scenario: Login with both fields blank
    When the user leaves the username and password blank
    And the user clicks on the Login button
    Then the username required message should be displayed
    And the password required message should be displayed