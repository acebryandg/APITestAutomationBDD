Feature: Create products

Scenario Outline: Verify create a product functionality
When I create a new product with "<title>", <price>, "<description>", "<category>", "<image>"
Then I receive a response code as <responseCode>
Examples:
  | title       | price | description      | category | image                | responseCode |
  | TestProduct | 1.00  | test description | Shoe     | https://example.com/ | 200          |
  | TestProduct | 12    | test description | Shoe     | https://example.com/ | 200          |
