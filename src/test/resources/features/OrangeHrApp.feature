@Regression @smoke @MB1-128
Feature: Validating timesheet functionalities

  Background:
    Given user navigates to OrangeHR application
    When user enters "Admin" for username and "admin123" for password and clicks on login button
    And user clicks on MyTimesheet

  Scenario:  Validate add timesheet functionality

    And user clicks on Add Timesheet button and chooses date "2021-01-03"
    Then user validates the timesheet message "Timesheet Already Exists"

    Scenario: Validate edit timesheet functionality
      When user clicks on dropdown menu and selects "2022-01-03 to 2022-01-09"
      And user clicks on edit button
      And user chooses project name as "Internal - Recruitment" and activity name as "Job Analysis"
      And user enters hours on each day using data
        | Mon 10 | Tue 11 | Wed 12 | Thu 13 | Fri 14 |
        | 1      | 4      | 2      | 3      | 5      |
      When user clicks on save button and submits timesheet
      Then user validates submitted timesheet status by message "Status: Submitted"
