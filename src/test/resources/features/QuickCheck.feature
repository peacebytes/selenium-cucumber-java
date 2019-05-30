Feature: Quick Check

  This feature file to do experiments

  @wip
  Scenario: Experiments with checking elements exist or not
    Given I have logged into Automation Practice
    Then I should "not see" "Sign in" button
    And I should "see" "Sign out" button
