Feature: My first feature file in here

  Scenario Outline: My first scenario
    Given kogito-training rules are initialized
    And set customer of type Customer with values
      | Name | Value  |
      | name | <name> |
      | age  | <age>  |
      
    When we run all the rules from process
    
    
    Then resOut must have one object in response named as resp1 with values
      | Name    | Value     |
      | inScope | <inScope> |
      | reason  | <reason>  |

    Examples: 
      | name | age | inScope | reason                 |
      | bob  |  19 | true    | Valid Customer         |
      | bob  |  17 | false   | InValid Customer - Age |
      
      Examples: 
      | name | age | inScope | reason                 |
      | bob  |  19 | true    | Valid Customer         |
      | bob  |  17 | false   | InValid Customer - Age |

      
       Examples: 
      | name | age | inScope | reason                 |
      | bob  |  19 | true    | Valid Customer         |
      | bob  |  17 | false   | InValid Customer - Age |
      