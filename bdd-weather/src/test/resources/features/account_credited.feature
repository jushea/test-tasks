Feature: Account is credited with amount

  Scenario Outline: Get current weather
    Given Prepare stub for API for <city>
    When I get current weather for a city <city>
    Then Parsed result and save in Log for <city>

    Examples:
      | city        |
      | "Paris"     |
      | "Amsterdam" |
      | "Belgrade"  |
      | "London"    |

  Scenario Outline: Get API errors
    Given Prepare stub for incorrect API with status <status> and message <message> with code <code> for <city>
    When Send incorrect request for <city> and get a response with <status>
    Then Check <status>, <code> and <message>
    Examples:
      | city     | status | code | message                       |
      | ""       | 400    | 1003 | "Parameter q is missing."     |
      | "Maskwa" | 400    | 1006 | "No matching location found." |
      | "London" | 401    | 2006 | "API key is invalid."         |
