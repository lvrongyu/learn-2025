# test_case1.feature
Feature: Test Case 1 - User Retrieval

  @TestCase1
  Scenario: Retrieve existing user
    Given a user with ID "user1"
    When I request the user's name
    Then the response should be "John Doe"

  @TestCase1
  Scenario: Retrieve non-existing user
    Given a user with ID "user99"
    When I request the user's name
    Then the response should be "Unknown User"