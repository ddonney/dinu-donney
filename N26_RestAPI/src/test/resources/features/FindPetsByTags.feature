@petStore

Feature: Get Pets by Tags

  @GetPets
  Scenario Outline: Verify success response for PetStore Get API
    Given Create a "GET" request for "PetsGetbyTags" API using below data
      | tags   |
      | <tags> |
    When Invoke the "GET" method for "PetsGetbyTags" api using endpoint "/pet/findByTags?tags=<tags>"
    Then Verify the response status code is "200"
    Examples:
      | tags |
      | tag1 |
      | tag2 |
      | tag3 |