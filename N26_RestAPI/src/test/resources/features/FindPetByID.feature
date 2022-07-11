@petStore

Feature: Get Pets by ID

  @GetPets
  Scenario Outline: Verify success response for PetStore Get API
    Given Create a "GET" request for "PetsGetbyID" API using below data
      | ID   |
      | <ID> |
    When Invoke the "GET" method for "PetsGetbyID" api using endpoint "/pet/<ID>"
    Then Verify the response status code is "200"
    Examples:
      | ID |
      | 1  |
#      | 2  |
#      | 3  |






