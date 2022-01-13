@regression @UI @MB2P-120
Feature: Validating calculate and order creation functionalities
  Scenario Outline: Validating calculate functionality
    Given user navigates to the weborders application
    When user provides username "Tester" and password "test"clicks on login button
    And user clicks on Order module
    And user selects "<product>" product with <quantity> quantity
    Then validates total is calculated correctly for quantity <quantity>
    Examples:
      | product     | quantity |
      | MyMoney     | 1        |
      | FamilyAlbum | 100      |
      | ScreenSaver | 55       |
      | MyMoney     | 20       |
@MB2-413
Scenario Outline: Validating create order functionality
  Given user navigates to the weborders application
  When user provides username "Tester" and password "test" clicks on login button
  And user counts number of orders in table
  And user clicks on Order module
  And user creates Order module
  And user creates order with date
    | order   | quantity   | name   | street   | city   | state   | zip   | cc   | expire date   |
    | <order> | <quantity> | <name> | <street> | <city> | <state> | <zip> | <cc> | <expire date> |
  Then user validates success message "New order has been successfully added."
  Then user validates order added to list of orders
  Examples:
    | order       | quantity | name        | street     | city     | state      | zip   | cc               | expire date |
    | MyMoney     | 1        | John Doe    | 123 MyRoad | Chicago  | Illinois   | 12345 | 1234567890123456 | 12/21       |
    | FamilyAlbum | 5        | Patel Harsh | 234 Third  | Rockford | Illinois   | 12345 | 1234567890127777 | 12/21       |
    | ScreenSaver | 50       | Kim Yan     | 456 Green  | Chico    | California | 94566 | 1234567890129999 | 12/21       |
