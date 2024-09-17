Feature: Login Feature

  Scenario: Login Success
    Given I open login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

//Feature: Login Features

 // Scenario: Login Failure
   // Given I open login Page
    //When I enter email "demo@class.com"
    //And I enter wrong password "te$t3$tudent"
    //And I submit
    //Then Login Fails
