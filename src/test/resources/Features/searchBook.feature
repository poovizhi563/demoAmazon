Feature: Amazon Book Search
  Scenario: Search the book
    Given I launch Amazon website "https://www.amazon.in/" link
    When I search "the power of your subconscious mind" book
    Then I get search result
    And I add product to cart
    Then I see "added to cart"
