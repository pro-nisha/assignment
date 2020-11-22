Feature: Query a postcode and receive a 200 response

  Scenario Outline: Verify response for Post code API
    When I send a get request to url with post code "<postCode>"
    Then I get a "<response>" response

    Examples:
    |postCode||response|
    |SW1P4JA|      |200|
    |NE65TY| |200|
    |NE65TY1| |404|

