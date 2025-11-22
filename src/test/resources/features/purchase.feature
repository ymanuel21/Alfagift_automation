Feature: Purchase Products

  Scenario: Buy Backpack and Bike Light
    Given the user launches the app
    When the user logs in with "standard_user" and "secret_sauce"
    And the user adds "Sauce Labs Backpack" to the cart
    And the user adds "Sauce Labs Bike Light" to the cart
    And the user proceeds to checkout
    Then both items should appear on the checkout page
