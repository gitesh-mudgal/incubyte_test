Feature: signup functionality

  Background:
    Given User is on the signup page

  Scenario: Verify user can successfully register with valid details
    When User enters valid details and submits
    Then Account should be created successfully
