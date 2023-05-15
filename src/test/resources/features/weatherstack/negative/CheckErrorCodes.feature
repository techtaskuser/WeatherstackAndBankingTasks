@checkStatusCode @negative
Feature: Check status codes and error messages for responses with error

  Scenario: HTTPS call is not available for free account
    When user calls weatherStack service via HTTPS for Moscow city
    Then request fails with error code 105
    And error message is Access Restricted - Your current Subscription Plan does not support HTTPS Encryption.

  Scenario: Non-existing city name in request
    When user calls weatherStack service via HTTP for abyrvalg city
    Then request fails with error code 615
    And error message is Your API request failed. Please try again or contact support.

  Scenario Outline: Request is missing accessKey/query
    When user calls weatherStack service via HTTP with no <missedParam>
    Then request fails with error code <code>
    And error message is <errorMessage>

    Scenarios:
      | missedParam | code | errorMessage                                                                           |
      | access key  | 101  | You have not supplied an API Access Key. [Required format: access_key=YOUR_ACCESS_KEY] |
      | query       | 601  | Please specify a valid location identifier using the query parameter.                  |
