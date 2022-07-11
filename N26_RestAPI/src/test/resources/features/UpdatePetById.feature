@petStore

Feature: Update an existing pet in the store
  @AddPets
  Scenario Outline: Verify success response for PetStore update API
    Given Create a "PUT" request for "updatePet" API using below data
      | id   | name   | category   | photoUrls   | tags   | status   |
      | <id> | <name> | <category> | <photoUrls> | <tags> | <status> |
    When Store "<id>" for validation
    When Invoke the "POST" method for "updatePet" api using endpoint "/pet"
    Then Verify the response status code is "200"
    Examples:
      | id | name | category           | photoUrls | tags                | status    |
      | 10 | lucy | {id: 1,name: Dogs} | string    | {id:0,name: string} | available |