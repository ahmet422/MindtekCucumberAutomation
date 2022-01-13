@regression @smoke @ui @MB2P-122
Feature: Validating pizza application functionalities

  Scenario Outline: Validating place order functionality
    Given user navigates to pizza application
    When user creates pizza order with data
      | Pizza        | <Pizza>        |
      | Toppings 1   | <Toppings 1>   |
      | Toppings 2   | <Toppings 2>   |
      | Quantity     | <Quantity>     |
      | Name         | <Name>         |
      | Email        | <Email>        |
      | Phone        | <Phone>        |
      | Payment Type | <Payment Type> |
    Then user validates that order is created with success message "Thank you for your order! TOTAL: " "<Pizza>"
    Examples:
      | Pizza                        | Toppings 1 | Toppings 2   | Quantity | Name         | Email             | Phone     | Payment Type   |
      | Small 6 Slices - no toppings | Mushrooms  | Extra cheese | 1        | John Doe     | johndoe@gmail.com | 123456789 | Cash on Pickup |
      | Medium 8 Slices - 2 toppings | Mushrooms  | Extra cheese | 2        | Patel Harsh  | ptaljo@gmail.com  | 977456789 | Credit Card    |
      | Large 10 Slices - 2 toppings | Olives     | Extra cheese | 3        | Harry Potter | cucu@gmail.com    | 567456789 | Cash on Pickup |