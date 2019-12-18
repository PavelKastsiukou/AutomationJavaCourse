Feature: Test login page

#  Scenario: Test positive login page
#    Given I am on main application page
#    When I login as correct user
#    Then I see logout link

#  Scenario Outline: Test negative login page
#    Given I am on main application page
#    When I login as user with "<name>" and "<password>"
#    Then I see error message
#    Examples:
#      | name   | password    |
#      | X XX XX| 123345768   |
#      | -----  |  hfgyt124jfk|


  Scenario: Test positive mail return from spam
    Given I am on main application page spam
    When I login
    And I click icon spam
    And I select message
    And I click not spam
    Then I see message mail return from spam