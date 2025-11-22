Feature: AlfaGift Change User Name

  Scenario: User Cancel Change Name
    Given the user launches the app
    When the user already logged in, open the profile menu
    And the user click its profile
    And the user click Changes profile info
    And the user click back 
    Then the name should be still the same
