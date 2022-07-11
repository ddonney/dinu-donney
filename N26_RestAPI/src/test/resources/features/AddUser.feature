@User

Feature: Add a new user

  @AddUser
  Scenario Outline: Verify success response for User Add API
    Given Create a "POST" request for "AddUser" API using below data
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    When Invoke the "POST" method for "AddUser" api using endpoint "user/createWithList" for "sectionType" as users
    Then Verify the response status code is "200"
    Examples:
      | id | username | firstName | lastName | email          | password | phone | userStatus | sectionType |
      | 10 | theUser  | John      | James    | john@email.com | 12345    | 12345 | 1          | User        |


