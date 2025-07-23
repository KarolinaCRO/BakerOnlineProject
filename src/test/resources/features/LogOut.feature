Feature: Log out
  User story: As a logged-in user, I want to be able to log out.


  Scenario: Logged-in user can log out successfully
    Given user is logged in
    When user opens the account menu
    And selects the LOG OUT option
    Then user is logged out
    And the LOG IN option is visible