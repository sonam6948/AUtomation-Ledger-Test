@api
Feature: Login using service

  Scenario: Login
    Given user has credentials
    When login service is called
    Then verify user logged in successfully