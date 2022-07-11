@Order
  Feature: Get Inventory by orderId

  @GetOrder
  Scenario Outline: Verify success response for Orders Get API
    Given Create a "GET" request for "GetOrderById" API using below data
      | orderId   |
      | <orderId> |
    When Invoke the "GET" method for "GetOrderById" api using endpoint "/store/order/<orderId>"
    Then Verify the response status code is "200"
    Examples:
      | orderId |
      | 1       |
