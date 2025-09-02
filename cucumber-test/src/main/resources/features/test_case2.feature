# test_case2.feature
Feature: Test Case 2 - User Creation

  @TestCase2
  Scenario: Save a new user
    Given I want to save a user with ID "user3" and name "Alice Johnson"
    When I save the user to the database
    Then the operation should be successful