Feature: Addresses

  This feature file to do address updating

    @wip
    Scenario: Listing out all addresses
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I view all addresses
        And I log out Automation Practice


    Scenario: Delete Address
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I delete address "BANGOR_ME"
        And I log out Automation Practice


    Scenario: Listing out all addresses
        Given I have logged into Automation Practice
        Then I click My Account
        And I click on "My addresses"
        Then I view all addresses
        And I log out Automation Practice