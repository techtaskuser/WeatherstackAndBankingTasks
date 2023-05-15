@getWeatherPerCity @positive
Feature: Get weather info per city

  Scenario Outline: User gets weather info for concrete cities
    When user calls weatherStack service via HTTP for <city> city
    Then response status code is 200
    And location data is:
      | country     | <country>     |
      | lat         | <lat>         |
      | lon         | <lon>         |
      | name        | <name>        |
      | region      | <region>      |
      | timezone_id | <timezone_id> |
      | utc_offset  | <utc_offset>  |
    And current weather data is:
      | temperature  | <temperature>  |
      | weather_code | <weather_code> |
      | wind_degree  | <wind_degree>  |
      | wind_dir     | <wind_dir>     |
      | wind_speed   | <wind_speed>   |

    Scenarios:
      | city   | country        | lat    | lon     | name   | region             | timezone_id     | utc_offset | temperature | weather_code | wind_degree | wind_dir | wind_speed |
      | Moscow | Russia         | 55.752 | 37.616  | Moscow | Moscow City        | Europe/Moscow   | 3.0        | 15          | 113          | 20          | NNE      | 4          |
      | Berlin | Germany        | 52.517 | 13.400  | Berlin | Berlin             | Europe/Berlin   | 2.0        | 22          | 113          | 150         | SSE      | 19         |
      | Prague | Czech Republic | 50.083 | 14.467  | Prague | Hlavni mesto Praha | Europe/Prague   | 2.0        | 19          | 113          | 140         | SE       | 17         |
      | Ottawa | Canada         | 45.417 | -75.700 | Ottawa | Ontario            | America/Toronto | -4.0       | 18          | 113          | 270         | W        | 19         |

