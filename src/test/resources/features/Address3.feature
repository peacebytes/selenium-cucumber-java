Feature: Address three

  This feature file to do address deleting

    Scenario: Delete Address
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I delete address "test1Updated"
        And I log out Automation Practice
