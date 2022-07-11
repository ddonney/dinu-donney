@User

Feature: Delete User by username
  @Delete
  Scenario Outline: Verify success response for delete pet API
    Given Create a "DELETE" request for "DeleteUserByUsername" API using below data
      | username   |
      | <username> |
    When Store "<username>" for validation
    When Invoke the "DELETE" method for "DeleteUserByUsername" api using endpoint "/user/"
    Then Verify the response status code is "200"
    Examples:
      | username |
      | theUser  |