#Author: mhaskar16@gmail.com

Feature: Find Owners page - Add new owner & pet for that owner

  Scenario: Add new owner
    Given I click on Find Owners tab
    When I click on Add Owner button
    And Add Owner details
    When I click on Add Owner button again
    Then Verify Onwer details
    
  Scenario: Add new pet for that owner
    Given I click on Add New Pet button
    And Add Pet details
    Then I click on Add Pet button again
    And Verify pet details