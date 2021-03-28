Feature: Check pluto site features

  Scenario: Check Partner definition
    Given I am on the Pluto start page
    When Close popup
    And I click on Annual cover
    Then Click on Our definition of a partner

  Scenario: Check offer with pre-existing medical conditions
    Given I am on the Pluto start page
    When Close popup
    And I click on Annual cover
    And I click on Next button
    And I type name and age
    And I choose I do have pre-existing medical conditions
    And I click on Next button
    Then We aren’t able to offer cover to people with pre-existing medical conditions

  Scenario: Check title page
    Given I am on the Pluto start page
    When Close popup
    And I click on logo site
    And I click on take me home
    Then Page title should start with "Pluto Cover | Hassle-free travel insurance"

