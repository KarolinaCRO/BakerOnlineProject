@register
Feature: Creating an account
  User story: As a visitor user, I want to be able to create an account.

  Background:
    Given user is on the home page
    When user clicks the REGISTER link


  Scenario: Visitor can successfully create an account
    And user fills out the registration form with valid data
    And user clicks the CREATE ACCOUNT button
    And user accepts the terms and conditions
    And user acknowledges the privacy policy
    Then a success message "Hurray! Your account has been created." should be displayed


  Scenario: Visitor user is not able to create an account with the already registered email
    And user fills out the registration form with already registered email
    And user clicks the CREATE ACCOUNT button
    And user accepts the terms and conditions
    And user acknowledges the privacy policy
    Then email duplication error message "This email address is already in use" should be displayed


