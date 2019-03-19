Feature: Address two

  This feature file to do address updating

    Scenario: Update Address
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I update address "test1"
        And I log out Automation Practice
