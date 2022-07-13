Feature: As a user
  I want to input two Natural numbers and add then together

#  Scenario: Two natural numbers
#    Given I create a new Function object
#    When I add 1 and 1 into the function
#    Then I get 2 as a result
#
#  Scenario: Two natural numbers
#    Given I create a new Function object
#    When I add 3 and 3 into the function
#    Then I get 6 as a result

  Scenario Outline: Two natural numbers
    Given I create a new Function object
    When I add <a> and <b> into the function
    Then I get <result> as a result

    Examples:
      | a | b | result |
      | 1 | 1 | 2      |
      | 3 | 3 | 6      |
