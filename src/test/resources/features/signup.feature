Feature: Magento Sign Up Functionality

  Background:
    Given User is on the signup page

  Scenario: Verify user can successfully register with valid details
    When User enters valid details and submits
    Then Account should be created successfully

  Scenario: Verify sign-up with existing email
    When User enters an already registered email
    Then An error message should be displayed

  Scenario: Verify sign-up with invalid email format
    When User enters an invalid email format
    Then An appropriate error message should be displayed

  Scenario: Verify sign-up with weak password
    When User enters a weak password
    Then A password strength error message should be displayed

  Scenario: Verify sign-up without filling mandatory fields
    When User submits the form without entering required fields
    Then Validation messages should be displayed

  Scenario: Verify password and confirm password mismatch
    When User enters different passwords in password and confirm password fields
    Then A password mismatch error message should be displayed

  Scenario: Verify sign-up with spaces in mandatory fields
    When User enters only spaces in mandatory fields
    Then An invalid input error should be displayed

  Scenario: Verify sign-up with special characters in name fields
    When User enters special characters in name fields
    Then A name format validation message should be displayed

  Scenario: Verify sign-up with maximum character limit for fields
    When User enters maximum allowed characters in all fields
    Then Account should be created successfully or an error message should be displayed

