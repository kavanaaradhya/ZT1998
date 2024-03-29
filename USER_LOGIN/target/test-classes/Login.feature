Feature: User Login
  As a user,
  I want to log in to the system
  So that I can access my account

  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully
