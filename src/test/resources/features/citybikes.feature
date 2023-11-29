Feature: Citybikes

  @frankfurt
  Scenario Outline: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Then I should be able to see that <city> is in <country>
    And I should be able to see the correct longitude <longitude> and latitude <latitude>
    Examples:
    |city|country|latitude|longitude|
    |Frankfurt|DE|50.1072|8.66375|

  @londonbikes
    Scenario Outline: As a user I want to verify that there is a bike station in a certain area and return the correct install date and empty slots
    Given there is a bike station at <name>
    Then I should be able to return the correct install date <installDate>
    And I should be able to return the correct number of empty slots <emptySlots>
    Examples:
    |name|installDate|emptySlots|
    |River Street , Clerkenwell|1278947280000|13|
