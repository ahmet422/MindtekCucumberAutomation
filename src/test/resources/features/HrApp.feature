Feature: Validating HrApp`s login functionality
  @hrapploginpositive
  Scenario: Validating login functionality with valid credentials
    Given User navigates to HrApp Login Page
    When user enters "Mindtek" for username and user enters for password "MindtekStudent" and clicks on login button
    Then user lands on main page where he sees the list of employees



