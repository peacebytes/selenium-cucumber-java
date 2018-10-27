Feature: Addresses

  This feature file to do address updating

    Scenario: Add Addresses
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I add all addressses from test data
        And I log out Automation Practice

    Scenario: Update Address
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I update address "test1"
        And I log out Automation Practice

    Scenario: Delete Address
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I delete address "test2"
        And I log out Automation Practice