#Author: mhaskar16@gmail.com

Feature: Find Owners page - Verify owner and pet informaion

  Scenario: Verify owner information
    Given I navigate to Find Owners tab
    When I enter user last name
    And I click on Find Owner button
    #And I  select first row
    Then Verify Onwer details
    And Verify pet details
   