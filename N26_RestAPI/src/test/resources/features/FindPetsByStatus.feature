@petStore

Feature: Get Pets by status

  @GetPets
  Scenario Outline: Verify success response for PetStore Get API
      Given Create a "GET" request for "PetsGet" API using below data
        | Status   |
        | <Status> |
      When Invoke the "GET" method for "PetsGet" api using endpoint "/pet/findByStatus?status=<Status>"
      Then Verify the response status code is "200"
    Examples:
        | Status    |
        | available |
        | pending   |
        | sold      |