@petStore

Feature: Delete pet by ID
  @Delete
  Scenario Outline: Verify success response for delete pet API
    Given Create a "DELETE" request for "DeletePetById" API using below data
      | id   |
      | <id> |
    When Store "<id>" for validation
    When Invoke the "DELETE" method for "DeletePetById" api using endpoint "/pet/"
    Then Verify the response status code is "200"
   Examples:
     | id |
     | 1  |