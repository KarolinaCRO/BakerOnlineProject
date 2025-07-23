Feature: Reset Password Functionality
  As a user, I want to be able to reset my password
  so that I can regain access to my account if I forget my password.


  @mailslurp
  Scenario: User successfully resets password
    Given user is on the home page
    When user clicks the LOG IN link
    And user clicks on the Forgot password? link
    And user enters the registered email address in the forgot password form
    And user clicks the send button
    Then user should see a confirmation message
    When user receives a password reset email
    And user clicks on the reset password link in the email
    And user enters a new password and confirms it
    And user clicks the reset password button
    Then user is logged in again

