Feature: Get all products from the api

  @SmokeTest
  Scenario: Verify the get api for products
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I receive a response code as 200


  Scenario Outline: Verify the rate of the first product is correct
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I verify that the title of <productNumber> is "<productTitle>"
    And that the count of the <productNumber> is <productCount>
    Examples:
      | productNumber | productTitle                                          | productCount |  |
      | 1             | Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops | 120          |  |
      | 3             | Mens Cotton Jacket                                    | 500          |  |



