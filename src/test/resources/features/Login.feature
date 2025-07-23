Feature: Login
  User story: As a registered user, I want to be able to log in.

  Background:
    Given user is on the home page
    When user clicks the LOG IN link


  Scenario: Registered user can log in successfully
    And user enters a valid email in the email field
    And user enters a valid password in the password field
    And user clicks the LOGIN button in the login form
    Then user is logged in and user account menu displays the user's name


  Scenario Outline: Registered user is not able to log in with invalid credentials
    And user enters "<valid/invalid email>" in the email field
    And user enters "<invalid/valid password>" in the password field
    And user clicks the LOGIN button in the login form
    Then an error message "Your login was incorrect." should be displayed
    And user is not logged in
    Examples:
      | valid/invalid email | invalid/valid password |
      | valid               | invalid                |
      | invalid             | valid                  |


  Scenario: Registered user is not able to log in with empty email
    And user leaves the email field empty
    And user enters a valid password in the password field
    And user clicks the LOGIN button in the login form
    Then the "email" field should display the validation message "Please fill in this field."
    And user is not logged in


  Scenario: Registered user is not able to log in with empty password
    And user enters a valid email in the email field
    And user leaves the password field empty
    And user clicks the LOGIN button in the login form
    Then the "password" field should display the validation message "Please fill in this field."
    And user is not logged in


  Scenario: Registered user is not able to log in with empty credentials
    And user leaves the email field empty
    And user leaves the password field empty
    And user clicks the LOGIN button in the login form
    Then the "email" field should display the validation message "Please fill in this field."
    And user is not logged in



