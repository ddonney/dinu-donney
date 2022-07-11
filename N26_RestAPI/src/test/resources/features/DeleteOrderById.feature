@Order

Feature: Delete order in the store

  @DeleteOrder
  Scenario Outline: Verify success response for PetStore Orders Delete API
    Given Create a "DELETE" request for "DeleteOrderById" API using below data
      | id   |
      | <id> |
    When Store "<id>" for validation
    When Invoke the "DELETE" method for "DeleteOrderById" api using endpoint "/store/order/"
    Then Verify the response status code is "200"
    Examples:
      | id |
      | 7  |