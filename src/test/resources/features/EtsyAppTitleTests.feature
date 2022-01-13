@regression @UI @ONT-3142 @smoke
Feature: Validating etsy titles

  Scenario Outline: Validating etsy separate page titles
    Given user navigates to Etsy application
    When user clicks on "<Section>" section
    Then user validates title is "<Title>"

    Examples:
      | Title                                        | Section                 |
      | End of Year Sales Event \| Etsy              | End of Year Sales Event |
      | Jewelry & Accessories \| Etsy                | Jewelry & Accessories   |
      | Clothing & Shoes \| Etsy                     | Clothing and Shoes      |
      | Wedding & Party \| Etsy                      | Wedding and Party       |
      | Toys & Entertainment \| Etsy                 | Toys and Entertainment  |
      | Art & Collectibles \| Etsy                   | Art and Collectibles    |
      | Craft Supplies & Tools \| Etsy               | Craft Supplies & Tools  |
      | The Etsy Holiday Gift Guide for 2021 \| Etsy | Gifts and GiftCards     |