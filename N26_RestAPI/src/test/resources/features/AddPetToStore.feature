@petStore

Feature: Add a new pet to the store
  @AddPets
  Scenario Outline: Verify success response for PetStore Add API
    Given Create a "POST" request for "AddNewPetTostore" API using below data
      | id   | name   | category   | photoUrls   | tags   | status   |
      | <id> | <name> | <category> | <photoUrls> | <tags> | <status> |
    When Invoke the "POST" method for "AddNewPetTostore" api using endpoint "/pet"
    Then Verify the response status code is "200"
    Examples:
      | id | name   | category           | photoUrls | tags                | status    |
      | 10 | doggie | {id: 1,name: Dogs} | string    | {id:0,name: string} | available |