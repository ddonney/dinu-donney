@User
Feature: Get User by UserName

  @GetUser
  Scenario Outline: Verify success response for Orders Get API
    Given Create a "GET" request for "GetUserByName" API using below data
      | username  |
      | <username> |
    When Invoke the "GET" method for "GetUserByName" api using endpoint "/user/<username>"
    Then Verify the response status code is "200"
    Examples:
      | username |
      | theUser         |
