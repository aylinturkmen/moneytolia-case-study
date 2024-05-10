Feature: Test Case 12: Add Products in Cart

  Scenario: Add multiple products to the cart and verify
    Given I am on the home page of "https://automationexercise.com/"
    When I click the Products button
    And I hover over the 0 product
    And I click Add to Cart button 0
    And I click Continue Shopping button
    And I hover over the 1 product
    And I click Add to Cart button 1
    And I click View Cart button
    Then I verify that both products are added to the cart
    And I verify their prices, quantities, and total price
