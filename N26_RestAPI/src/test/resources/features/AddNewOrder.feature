@Order

Feature: Place a new order in the store

  @GetOrdernew
  Scenario Outline: Verify success response for PetStore Orders Add API
    Given Create a "POST" request for "AddNewOrder" API using below data
      | id   | petId  | quantity   | shipDate    | status | complete |
      | <id> | <petId> | <quantity> | <shipDate> | <status> | <complete> |
    When Invoke the "POST" method for "AddNewOrder" api using endpoint "/store/order" for "section"
    Then Verify the response status code is "200"
    Examples:
      | id | petId   | quantity | shipDate                 | status   | complete | section |
      | 2  | 1985672 | 4        | 2022-07-11T04:43:44.083Z | approved | yes      | orders  |