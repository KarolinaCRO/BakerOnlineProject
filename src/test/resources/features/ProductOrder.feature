Feature: Ordering
  User story: As a logged-in user, I want to be able to order one or more products and select Payment at pickup as a payment method.

  Background:
    Given user is logged in
    When user searches for artisan "Brood en patisserie Utah"
    And user clicks SHOP NOW button


  Scenario: Logged-in user can order one product, and select Payment at pickup as a payment method
    And user searches for "kerststronk vanille"
    And user clicks ORDER button button on the product
    And user opens the cart
    And user clicks ORDER button in the cart
    And user clicks CONTINUE button
    And user selects the first available pickup date
    And the user selects the first available pickup time
    And user clicks CONTINUE button
    And user selects Payment at pickup as payment method
    Then the PLACE ORDER button should be visible


  Scenario: Logged-in user can order two or more products, and select Payment at pickup as a payment method
    And user searches for "lang wit"
    And user clicks the + button
    And user clicks ORDER button button on the product
    And user searches for "kerststronk vanille"
    And user clicks ORDER button button on the product
    And user opens the cart
    And user clicks ORDER button in the cart
    And user clicks CONTINUE button
    And user selects the first available pickup date
    And the user selects the first available pickup time
    And user clicks CONTINUE button
    And user selects Payment at pickup as payment method
    Then the PLACE ORDER button should be visible




