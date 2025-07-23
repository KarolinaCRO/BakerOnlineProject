Feature: Product search
  User story: As a user (visitor or logged-in), I want to search for products using the search bar,
  so that I can quickly find items I'm interested in without browsing through all categories.


  Scenario Outline: Visitor user can search for products
    Given user is on the home page
    When user searches for artisan "Brood en patisserie Utah"
    And user clicks SHOP NOW button
    And user searches for "<product>"
    Then search results containing "<product>" in the product name are displayed
    Examples:
      | product |
      | pudding |
      | wit     |


  Scenario Outline: Scenario Outline: Logged-in user can search for products
    Given user is logged in
    When user searches for artisan "Brood en patisserie Utah"
    And user clicks SHOP NOW button
    And user searches for "<product>"
    Then search results containing "<product>" in the product name are displayed
    Examples:
      | product |
      | donut   |
      | flap    |


  Scenario Outline: Logged-in user can search for a specific product by exact name
    Given user is logged in
    When user searches for artisan "Brood en patisserie Utah"
    And user clicks SHOP NOW button
    And user searches for "<exactProduct>"
    Then only the product with the name "<exactProduct>" is displayed in the search results
    Examples:
      | exactProduct        |
      | ontbijtmand cat.1   |
      | kerststronk vanille |


  Scenario Outline: No results are shown when a visitor user searches for a product that doesn't exist
    Given user is on the home page
    When user searches for artisan "Brood en patisserie Utah"
    And user clicks SHOP NOW button
    And user searches for "<nonExistingProduct>"
    Then a message "Please try another search or change the chosen filters." is displayed
    Examples:
      | nonExistingProduct |
      | apple pie          |
      | brownie            |